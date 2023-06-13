package com.bca.transaction.datasource

import com.bca.transaction.model.Transaction

data class TransactionList(
        val transactions: MutableList<Transaction> = mutableListOf()
)
