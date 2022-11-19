import express, {Express, Request, Response} from 'express';

const app: Express = express();
const port = 8089;

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


app.post('/cat/food/:catId', async (req: Request, res: Response) => {
    let response = await fetch(`http://localhost:8080/cats/${req.params["catId"]}`);
    let jsonRes = await response.json();
    if (jsonRes.status >= 400) {
        res.status(500)
            .send(
                {
                    message: "falhou"
                }
            )
    }

    res.send()
});

app.listen(port);
