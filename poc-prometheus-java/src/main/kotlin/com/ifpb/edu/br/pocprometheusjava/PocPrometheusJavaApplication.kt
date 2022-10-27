package com.ifpb.edu.br.pocprometheusjava

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class PocPrometheusJavaApplication

fun main(args: Array<String>) {
	runApplication<PocPrometheusJavaApplication>(*args)
}
