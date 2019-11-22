package com.anggar.fdc.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
data class FoodNutrientDetail (
        @Field("id")
        val id: Int,
        @Field("nutrient_id")
        val nutrientId: Int,
        val amount: Double,
        val name: String,
        val unit_name: String
)