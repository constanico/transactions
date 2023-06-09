package com.bca.transaction.service

import com.bca.transaction.datasource.TransactionDataSource
import com.bca.transaction.model.Transaction
import org.springframework.stereotype.Service

@Service
class TransactionServiceImpl(private val dataSource: TransactionDataSource) : TransactionService {
    override fun getTransactions(): Collection<Transaction> = dataSource.retrieveTransactions()

}