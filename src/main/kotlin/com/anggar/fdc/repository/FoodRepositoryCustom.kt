package com.anggar.fdc.repository

import com.anggar.fdc.model.Food
import com.anggar.fdc.model.FoodNutrientDetail
import com.anggar.fdc.model.Nutrient
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.stereotype.Repository

@Repository
interface FoodRepositoryCustom {

    fun getNutrientsByFdcId(fdcId: Int): MutableList<FoodNutrientDetail>
}