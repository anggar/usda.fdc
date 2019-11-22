package com.anggar.fdc.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document
data class Nutrient (
        @Id
        var _id: ObjectId,
        @Field("id")
        val nid: Int?,
        val name: String,
        val unit_name: String,
        val nutrient_nbr: Int?,
        val rank: Int?
)