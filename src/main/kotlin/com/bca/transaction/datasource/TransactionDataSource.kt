package com.bca.transaction.datasource

import com.bca.transaction.model.Transaction

interface TransactionDataSource {
    fun sendTransactions(req: TransactionList) : String
    fun retrieveTransactions(): Collection<Transaction>
}