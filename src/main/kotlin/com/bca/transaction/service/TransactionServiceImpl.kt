package com.bca.transaction.service

import com.bca.transaction.datasource.TransactionDataSource
import com.bca.transaction.datasource.TransactionList
import com.bca.transaction.model.Transaction
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service

@Service
class TransactionServiceImpl(@Qualifier("network") private val dataSource: TransactionDataSource) : TransactionService {
    override fun postTransactions(req: HttpEntity<TransactionList>): String = dataSource.sendTransactions(req)

    override fun getTransactions(): Collection<Transaction> = dataSource.retrieveTransactions()
}