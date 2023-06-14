package com.bca.transaction.controller

import com.bca.transaction.model.TransactionList
import com.bca.transaction.model.Transaction
import com.bca.transaction.service.TransactionService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/transaction/"])
class TransactionController(private val transactionService: TransactionService) {

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @CrossOrigin
    @PostMapping("/sale")
    fun transactionSale(@RequestBody req: Transaction): String {
        val request = objectMapper.writeValueAsString(req)
        transactionService.postTransaction(request)
        return "Success"
    }

    @CrossOrigin
    @GetMapping("/history")
    fun transactionHistory(): ResponseEntity<TransactionList> {
        return transactionService.getTransactions()
    }
}