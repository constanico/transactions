package com.bca.transaction.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Transaction(
        @JsonProperty("tx_id")
        var txId: String,

        @JsonProperty("amount")
        var amount: Number,

        @JsonProperty("status")
        var status: String
)
