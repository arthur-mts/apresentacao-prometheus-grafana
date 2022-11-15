import express, { Express, Request, Response } from 'express';

const app: Express = express();
const port = 8089;

app.get('/', (req: Request, res: Response) => {
    res.send('Express + TypeScript Server');
});

app.listen(port);
