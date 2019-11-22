package com.anggar.fdc.repository

import com.anggar.fdc.model.Food
import com.anggar.fdc.model.FoodNutrientDetail
import com.anggar.fdc.model.Nutrient
import com.mongodb.client.model.Aggregates.project
import com.mongodb.client.model.Aggregates.unwind
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.*
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.data.mongodb.core.update


class FoodRepositoryImpl : FoodRepositoryCustom {

    @Autowired
    private lateinit var mongoTemplate : MongoTemplate

    override fun getNutrientsByFdcId(fdcId: Int): MutableList<FoodNutrientDetail> {
        val firstLookup = LookupOperation.newLookup()
                .from("food_nutrient")
                .localField("fdc_id")
                .foreignField("fdc_id")
                .`as`("nutrients")

        val secondLookup = LookupOperation.newLookup()
                .from("nutrient")
                .localField("nutrients.nutrient_id")
                .foreignField("id")
                .`as`("nutrient_detail")

        val list: MutableList<AggregationOperation> = mutableListOf<AggregationOperation>()
        list.add(Aggregation.match(Criteria.where("fdc_id").isEqualTo(fdcId)))
        list.add(firstLookup)
        list.add(Aggregation.unwind("nutrients"))
        list.add(secondLookup)
        list.add(Aggregation.unwind("nutrient_detail"))
        list.add(Aggregation
                    .project("nutrients.id", "nutrients.nutrient_id", "nutrients.amount",
                        "nutrient_detail.name", "nutrient_detail.unit_name")
                    .andExclude("_id"))
        list.add(Aggregation.match(Criteria.where("amount").ne(0)))
        val agg = Aggregation.newAggregation(Food::class.java, list)

        return mongoTemplate.aggregate(agg, Food::class.java, FoodNutrientDetail::class.java).mappedResults
    }
}
