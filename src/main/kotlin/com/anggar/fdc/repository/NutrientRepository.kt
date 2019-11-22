package com.anggar.fdc.repository

import com.anggar.fdc.model.FoodNutrient
import com.anggar.fdc.model.Nutrient
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NutrientRepository : MongoRepository<Nutrient, String>, NutrientRepositoryCustom {
    fun findByNid(id: Int): List<Nutrient>?


}