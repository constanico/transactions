package com.bca.transaction.datasource

import com.bca.transaction.model.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.client.exchange
import java.io.IOException

@Repository("network")
class NetworkDataSource(@Autowired private val restTemplate: RestTemplate) : TransactionDataSource {
    override fun sendTransactions(req: HttpEntity<TransactionList>): String {
        val response: ResponseEntity<TransactionList> =
                restTemplate.exchange("http://localhost:8080/payment/sale", HttpMethod.POST, req, TransactionList::class.java)
        return "Success"
    }

    override fun retrieveTransactions(): Collection<Transaction> {
        val response: ResponseEntity<TransactionList> =
                restTemplate.getForEntity("http://localhost:8080/payment/sale")
        return response.body?.transactions
                ?: throw IOException("Could not fetch data")
    }

}