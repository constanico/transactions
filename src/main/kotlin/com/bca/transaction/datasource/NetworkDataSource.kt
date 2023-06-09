package com.bca.transaction.datasource

import com.bca.transaction.model.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSource(@Autowired private val restTemplate: RestTemplate) : TransactionDataSource {
    override fun retrieveTransactions(): Collection<Transaction> {
        val response: ResponseEntity<TransactionList> =
                restTemplate.getForEntity("http://")
        return response.body?.transactions
                ?: throw IOException("Could not fetch data")
    }

}