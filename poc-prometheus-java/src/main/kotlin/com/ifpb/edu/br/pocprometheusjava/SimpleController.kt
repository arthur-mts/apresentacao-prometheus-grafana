package com.ifpb.edu.br.pocprometheusjava

import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Data
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

data class CreateCat(val name: String, val age: Int?)
data class Cat(val id: Int, val name: String, val age: Int?)

object Database {
    val cats: MutableList<Cat> = mutableListOf()
    var idCounter = 0
}

@RestController
@RequestMapping("/cats")
class SimpleController {


    @GetMapping
    fun getCats(): List<Cat> {
        return Database.cats
    }


    @PostMapping
    fun registerCat(@RequestBody cat: CreateCat): Cat {
        if (Database.cats.firstOrNull { it.name == cat.name } != null)
            throw ResponseStatusException(HttpStatus.CONFLICT, "A cat with the name \'${cat.name}\' already exists")

        val createdCat = Cat(
            Database.idCounter++,
            cat.name,
            cat.age
        )

        Database.cats.add(
            createdCat
        )

        return createdCat
    }

    @GetMapping("/{id}")
    fun findCat(@PathVariable id: Int): Cat {
        return Database.cats.firstOrNull { it.id == id } ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Cat not found"
        )
    }
}