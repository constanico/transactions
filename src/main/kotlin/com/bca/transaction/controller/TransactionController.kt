package com.bca.transaction.controller

import com.bca.transaction.datasource.TransactionList
import com.bca.transaction.model.Transaction
import com.bca.transaction.service.TransactionService
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.apache.commons.io.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException
import java.nio.charset.StandardCharsets

@RestController
@RequestMapping(value = ["/transaction/"])
class TransactionController(private val transactionService: TransactionService, @Autowired private val restTemplate: RestTemplate) {

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @CrossOrigin
    @PostMapping("/sale")
    fun transactionSale(): TransactionList {
        val staticDataResource = ClassPathResource("data.json")
        val staticDataString = IOUtils.toString(staticDataResource.inputStream, StandardCharsets.UTF_8.name())
        val req: TransactionList = objectMapper.readValue(staticDataString)
//        val stringBody = objectMapper.writeValueAsString(req.transactions)
        transactionService.postTransactions(req)
        return req
    }

    @CrossOrigin
    @GetMapping("/history")
    fun transactionHistory(): Collection<Transaction> {
        return transactionService.getTransactions()
    }
}