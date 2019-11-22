package com.anggar.fdc.repository

import com.anggar.fdc.model.Nutrient
import com.anggar.fdc.model.NutrientCount
import org.bson.conversions.Bson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.AggregationOperation
import org.springframework.data.mongodb.core.aggregation.GroupOperation

class NutrientRepositoryImpl : NutrientRepositoryCustom {

    @Autowired
    private lateinit var mongoTemplate : MongoTemplate

    override fun groupNutrient(): MutableList<NutrientCount> {
        val list: MutableList<AggregationOperation> = mutableListOf()
        list.add(Aggregation.group("unit_name").count().`as`("count"))
        val agg = Aggregation.newAggregation(Nutrient::class.java, list)

        return mongoTemplate.aggregate(agg, "nutrient", NutrientCount::class.java).mappedResults
    }
}