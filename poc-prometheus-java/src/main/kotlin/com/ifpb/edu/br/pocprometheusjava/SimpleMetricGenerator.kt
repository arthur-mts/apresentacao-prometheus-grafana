package com.ifpb.edu.br.pocprometheusjava

import io.micrometer.core.instrument.MeterRegistry
import io.prometheus.client.CollectorRegistry
import io.prometheus.client.Gauge
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled


@Configuration
class SimpleMetricGenerator(collectorRegistry: CollectorRegistry) {
    private val gauge: Gauge = Gauge.build("animacao_palestra", "Metrica que descreve o sono de voces nessa palestra")
        .register(collectorRegistry)


    @Scheduled(fixedDelay = 1000)
    fun metricGenerator() {
        val animacao = System.currentTimeMillis() % 10
        println(animacao)
        this.gauge.set(animacao.toDouble())
//        this.meterRegistry.gauge("animacao_palestra", animacao)
//        metricGauge.set(animacao.toDouble())
    }

}