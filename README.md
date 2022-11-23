## Prometheus

Bibliotecas do Prometheus para Java:
- https://micrometer.io/docs/registry/prometheus
- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator

Bibliotecas para NodeJS:
- https://www.npmjs.com/package/prom-client
- https://www.npmjs.com/package/express-prom-bundle

Para executar o prometheus, rode o seguinte comando:
```sh
docker run --network="host" -d -v (sua pasta atual)/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
```

## Grafana
[Documentação](https://grafana.com/docs/grafana/v9.0/setup-grafana/configure-docker/)

Execute esse comando para criar um volume para guardar as configurações do grafana:

```sh
docker volume create grafana-storage
```

Esse comando vai criar uma pasta no seguinte diretório:
```sh
cd /var/lib/docker/volumes/grafana-storage
```

Para executar o grafana:
```sh
docker pull grafana/grafana-oss:6.6.1
docker run --network="host" -d --name=grafana -v grafana-storage:/var/lib/grafana grafana/grafana-oss:6.6.1
```
Agora, é só abrir o broser em http://localhost:3000 e tudo deve estar funcionando!  
Lembre que as credenciais padrão são admin-admin.