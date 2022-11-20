import express, {Express, Request, Response} from 'express';
import {Registry, Counter} from 'prom-client';
import promBundle from 'express-prom-bundle';

const app: Express = express();
const port = 8089;

const register = new Registry();

const httpRequestCounter = new Counter({
    name: 'http_server_requests_seconds_count',
    registers: [register],
    help: 'Contador de requisições',
    labelNames: ['status', 'uri', 'method']
})

type CatFoodBill = {
    value: number,
    catId: number,
    catName: string
}

type CatFood = {
    name: string,
    price: number,
    stock: number
}

const bills: CatFoodBill[] = []

const availableFoods: CatFood[] = [
    {
        name: 'peixe',
        price: 1.5,
        stock: 100
    },
    {
        name: 'whiskas sache',
        price: 3,
        stock: 10
    },
    {
        name: 'rato',
        price: 10,
        stock: 4
    },
    {
        name: 'lagartixa',
        price: 100,
        stock: 2
    }
]

app.use(
    promBundle({
        includeMethod: true,
        includePath: true,
        promRegistry: register,
        promClient: {
            collectDefaultMetrics: {register, labels: {app_name: "poc-prometheus-node"}}
        }
    })
)

// Métricas padrão
// app.get('/metrics', async (req, res) => {
//     res.send(await register.metrics())
// });

app.post('/cat/food/:catId', async (req: Request, res: Response) => {
    let response = await fetch(`http://localhost:8080/cats/${req.params["catId"]}`);
    let jsonRes = await response.json();
    let labels = {status: 200, uri: '/cat/food/:catId', method: 'POST'};
    if (jsonRes.status >= 400) {
        labels.status = 500;
        res.status(500)
            .send(
                {
                    message: "falhou"
                }
            )
    }
    httpRequestCounter.inc(labels)

    res.send()
});

app.listen(port);
