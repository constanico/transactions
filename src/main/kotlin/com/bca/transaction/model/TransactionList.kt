package com.bca.transaction.model

import com.bca.transaction.model.Transaction

data class TransactionList(
        val transactions: MutableList<Transaction> = mutableListOf()
)
