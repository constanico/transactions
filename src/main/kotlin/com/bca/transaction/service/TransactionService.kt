package com.bca.transaction.service

import com.bca.transaction.model.Transaction


interface TransactionService {
    fun getTransactions(): Collection<Transaction>
}