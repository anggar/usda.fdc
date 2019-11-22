package com.anggar.fdc.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("food_nutrient")
data class FoodNutrient (
        @Id
        val _id: ObjectId,
        @Indexed
        @Field("id")
        val fnId: Int,
        @Field("fdc_id")
        val fdcId: Int?,
        @Field("nutrient_id")
        val nutrientId: Int,
        val amount: Double?,
        val data_points: String?,
        val derivation_id: String?,
        val min: String?,
        val max: String?,
        val median: String?,
        val footnote: String?,
        val min_year_acquired: String?
)