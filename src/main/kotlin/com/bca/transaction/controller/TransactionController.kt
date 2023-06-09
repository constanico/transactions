package com.bca.transaction.controller

import com.bca.transaction.model.Transaction
import com.bca.transaction.service.TransactionService
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.apache.commons.io.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.charset.StandardCharsets

@RestController
@RequestMapping(value = ["/transaction/"])
class TransactionController(private val transactionService: TransactionService) {

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @PostMapping("/sale")
    fun sale() {
    }

    @GetMapping("/history")
    fun getHistory(): Collection<Transaction> = transactionService.getTransactions()
}