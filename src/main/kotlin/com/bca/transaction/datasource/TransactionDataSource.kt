package com.bca.transaction.datasource

import com.bca.transaction.model.Transaction
import org.springframework.http.HttpEntity

interface TransactionDataSource {
    fun sendTransactions(req: HttpEntity<TransactionList>) : String
    fun retrieveTransactions(): Collection<Transaction>
}