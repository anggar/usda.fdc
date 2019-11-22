package com.anggar.fdc.controller

import com.anggar.fdc.model.Food
import com.anggar.fdc.model.FoodNutrient
import com.anggar.fdc.repository.FoodNutrientRepository
import com.anggar.fdc.repository.FoodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/food_nutrient")
class FoodNutrientController {

    @Autowired
    lateinit var repository: FoodNutrientRepository

    fun pageRequest(page: Int): PageRequest {
        return PageRequest.of(page, 10)
    }

    @GetMapping
    fun findAll(@RequestParam page: Int?): Page<FoodNutrient> {
        val res = repository.findAll(pageRequest(page?:0))
        return res
    }

    @GetMapping("/{id}")
    fun findByDataType(@PathVariable id: Int)
            = repository.findByFnId(id)

}