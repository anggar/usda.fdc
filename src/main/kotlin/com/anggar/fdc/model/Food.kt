package com.anggar.fdc.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("food")
data class Food (
        @Id
        val _id: ObjectId,
        @Field("fdc_id")
        val fdcId: Int,
        @Field("data_type")
        val dataType: String?,
        val description: String?,
        val food_category_id: String?,
        val publication_date: String?,
        val scientific_name: String?,
        val food_key: String?,
        val nutrients: List<FoodNutrientDetail>?
)