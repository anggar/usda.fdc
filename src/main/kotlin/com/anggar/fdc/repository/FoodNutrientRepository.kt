package com.anggar.fdc.repository

import com.anggar.fdc.model.Food
import com.anggar.fdc.model.FoodNutrient
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface FoodNutrientRepository : MongoRepository<FoodNutrient, Int> {
    fun findByFnId(id: Int): List<FoodNutrient>
    fun findByFdcId(id: Int): List<FoodNutrient>
}