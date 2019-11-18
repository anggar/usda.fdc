package com.anggar.fdc.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.Serializable

@Document
data class User (
        @Id val _id: ObjectId,
        val username: String,
        val password: String
) : Serializable