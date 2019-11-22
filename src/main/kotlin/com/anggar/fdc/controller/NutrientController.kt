package com.anggar.fdc.controller

import com.anggar.fdc.model.Food
import com.anggar.fdc.model.FoodNutrient
import com.anggar.fdc.model.Nutrient
import com.anggar.fdc.model.NutrientCount
import com.anggar.fdc.repository.FoodNutrientRepository
import com.anggar.fdc.repository.FoodRepository
import com.anggar.fdc.repository.NutrientRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import java.util.*
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping





@RestController
@RequestMapping("/nutrient")
class NutrientController {

    @Autowired
    lateinit var repository: NutrientRepository

    fun pageRequest(page: Int): PageRequest {
        return PageRequest.of(page, 10)
    }

    @GetMapping
    fun findAll(@RequestParam page: Int?): Page<Nutrient> {
        val res = repository.findAll(pageRequest(page?:0))
        return res
    }

    @GetMapping("/{id}")
    fun findByDataType(@PathVariable id: Int)
            = repository.findByNid(id)

    @PutMapping("/{deptId}")
    fun updateDept(@RequestBody nutrient: Nutrient, @PathVariable id: String): Nutrient {
        var nd = nutrient
        nd._id = ObjectId(id)
        repository.save(nd)
        return nd
    }


    @DeleteMapping("/{id}")
    fun deleteDept(@PathVariable id: String): String {
        repository.deleteById(id)
        return id
    }

    @GetMapping("/units")
    fun getUnits() : List<NutrientCount> {
        val res = repository.groupNutrient()
        println("# GNC {$res}")
        return res
    }
}