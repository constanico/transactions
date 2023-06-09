package com.bca.transaction.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Transaction(
        @JsonProperty("tx_id")
        val txId: String,

        @JsonProperty("amount")
        val amount: Number,

        @JsonProperty("status")
        val status: String
)
