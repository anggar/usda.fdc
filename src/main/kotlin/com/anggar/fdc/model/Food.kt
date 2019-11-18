package com.anggar.fdc.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Food (
        @Id val _id: ObjectId,
        val fdc_id: String,
        val data_type: String?,
        val description: String?,
        val food_category_id: String?,
        val publication_date: String?,
        val scientific_name: String?,
        val food_key: String?
)