package com.bca.transaction.service

import com.bca.transaction.model.Transaction
import com.bca.transaction.model.TransactionList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class TransactionServiceImpl(@Autowired private val restTemplate: RestTemplate) : TransactionService {

    override fun postTransaction(req: String): ResponseEntity<Transaction> {
        return restTemplate.postForEntity("http://localhost:8080/payment/sale", req, Transaction::class.java)
    }

    override fun getTransactions(): ResponseEntity<TransactionList> {
        return restTemplate.getForEntity("http://localhost:8080/payment/sale", TransactionList::class.java)
    }
}