package com.ifpb.edu.br.pocprometheusjava

import io.prometheus.client.CollectorRegistry
import io.prometheus.client.Gauge
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled
import kotlin.math.floor

@Configuration
class SimpleMetricGenerator(collectorRegistry: CollectorRegistry) {
    private val gauge: Gauge = Gauge.build("animacao_palestra", "Metrica que descreve o sono de voces nessa palestra")
        .register(collectorRegistry)

    @Scheduled(fixedDelay = 1000)
    fun metricGenerator() {
        val animacao = floor(Math.random() * 10)
        println(animacao)
        this.gauge.set(animacao)
    }
}
