package com.anggar.fdc.repository

import com.anggar.fdc.model.Food
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.PathVariable
import java.awt.print.Pageable
import java.util.Optional

@Repository
interface FoodRepository : MongoRepository<Food, String>, FoodRepositoryCustom {

    fun findByDataType(dt: String) : List<Food>?
    fun findByFdcId(id: Int) : List<Food>?

    fun findByDescriptionLike(q: String) : List<Food>?
}