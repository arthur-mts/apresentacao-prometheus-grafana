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