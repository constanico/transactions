package com.bca.transaction.service

import com.bca.transaction.model.Transaction
import com.bca.transaction.model.TransactionList
import org.springframework.http.ResponseEntity

interface TransactionService {
    fun postTransaction(req: String): ResponseEntity<Transaction>
    fun getTransactions(): ResponseEntity<TransactionList>
}