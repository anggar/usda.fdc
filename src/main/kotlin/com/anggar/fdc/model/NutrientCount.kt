package com.anggar.fdc.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
data class NutrientCount (
    @Id
    val unit_name: String,
    val count: Int
)