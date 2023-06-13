package com.bca.transaction.service

import com.bca.transaction.datasource.TransactionList
import com.bca.transaction.model.Transaction
import org.springframework.http.HttpEntity

interface TransactionService {
    fun postTransactions(req: HttpEntity<TransactionList>): String
    fun getTransactions(): Collection<Transaction>
}