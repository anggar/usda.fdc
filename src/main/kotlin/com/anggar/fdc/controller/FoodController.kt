package com.anggar.fdc.controller

import com.anggar.fdc.model.Food
import com.anggar.fdc.model.FoodNutrient
import com.anggar.fdc.model.FoodNutrientDetail
import com.anggar.fdc.model.Nutrient
import com.anggar.fdc.repository.FoodNutrientRepository
import com.anggar.fdc.repository.FoodRepository
import com.anggar.fdc.repository.NutrientRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.web.bind.annotation.*
import java.util.*
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping



@RestController
@RequestMapping("/food")
class FoodController {

    @Autowired
    lateinit var repository: FoodRepository

    @Autowired
    lateinit var nutrientRepository: NutrientRepository

    @Autowired
    lateinit var fnRepository: FoodNutrientRepository

    fun pageRequest(page: Int): PageRequest {
        return PageRequest.of(page, 10)
    }

    @GetMapping
    fun findAll(@RequestParam page: Int?): Page<Food> {
        val res = repository.findAll(pageRequest(page?:0))
        return res
    }

    @GetMapping("/{id}")
    fun findByFcdId(@PathVariable id: Int)
            = repository.findByFdcId(id)

    @GetMapping("/{id}/nutrients")
    fun findFoodNutrient(@PathVariable id: Int): MutableList<FoodNutrientDetail> {
        val res = repository.getNutrientsByFdcId(id);
        return res
}

    @GetMapping("/search")
    fun search(@RequestParam q: String, @RequestParam page: Int?): List<Food>?
        = repository.findByDescriptionLike(q)

    @PostMapping
    fun createDept(@RequestBody food: Food): Food {
        repository.save(food)
        return food
    }
}