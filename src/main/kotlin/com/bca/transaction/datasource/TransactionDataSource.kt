package com.bca.transaction.datasource

import com.bca.transaction.model.Transaction

interface TransactionDataSource {
    fun retrieveTransactions(): Collection<Transaction>
}