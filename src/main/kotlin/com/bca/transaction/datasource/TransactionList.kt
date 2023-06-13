package com.bca.transaction.datasource

import com.bca.transaction.model.Transaction
import com.fasterxml.jackson.annotation.JsonProperty

data class TransactionList(
        val transactions: Collection<Transaction>
)
