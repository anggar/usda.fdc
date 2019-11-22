package com.anggar.fdc.repository

import com.anggar.fdc.model.Food
import com.anggar.fdc.model.Nutrient
import com.anggar.fdc.model.NutrientCount
import org.springframework.stereotype.Repository

@Repository
interface NutrientRepositoryCustom {

    fun groupNutrient(): MutableList<NutrientCount>
}