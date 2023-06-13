package com.bca.transaction.controller

import com.bca.transaction.datasource.TransactionList
import com.bca.transaction.model.Transaction
import com.bca.transaction.service.TransactionService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/transaction/"])
class TransactionController(private val transactionService: TransactionService) {

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @CrossOrigin
    @PostMapping("/sale")
    fun transactionSale(): TransactionList {
        val transactionList = TransactionList()
        transactionList.transactions.add(Transaction("TX001",150000,"SUCCESS"))
        transactionList.transactions.add(Transaction("TX002",80000,"FAILED"))
        val requestBody = HttpEntity(transactionList)
        transactionService.postTransactions(requestBody)
        return transactionList
    }

    @CrossOrigin
    @GetMapping("/history")
    fun transactionHistory(): Collection<Transaction> {
        return transactionService.getTransactions()
    }
}