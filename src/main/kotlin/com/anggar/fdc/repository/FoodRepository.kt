package com.anggar.fdc.repository

import com.anggar.fdc.model.Food
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodRepository : MongoRepository<Food, String> {

}