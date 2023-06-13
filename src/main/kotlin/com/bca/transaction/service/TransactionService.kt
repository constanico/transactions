package com.bca.transaction.service

import com.bca.transaction.datasource.TransactionList
import com.bca.transaction.model.Transaction

interface TransactionService {
    fun postTransactions(req: TransactionList): String
    fun getTransactions(): Collection<Transaction>
}