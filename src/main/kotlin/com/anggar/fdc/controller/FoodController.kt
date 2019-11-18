package com.anggar.fdc.controller

import com.anggar.fdc.repository.FoodRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/food")
class FoodController {

    @Autowired
    lateinit var repository: FoodRepository

    fun pageRequest(page: Int): PageRequest {
        return PageRequest.of(page, 10)
    }

    @GetMapping
    fun findAll(@RequestParam page: Int?)
        = repository.findAll(pageRequest(page?:0))

//    @GetMapping
//    fun findByFcd_id(@RequestParam id: String)
//        = repository.findByFdc_id(id)
}