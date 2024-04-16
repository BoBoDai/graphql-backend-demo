package com.example.graphql

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.github.GetUserQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component

@Component
class GraphQLService {
    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://api.github.com/graphql")
        .addHttpHeader(HttpHeaders.AUTHORIZATION, "token .......")
        .build()

    suspend fun getUser(userId: String): GetUserQuery.User? = withContext(Dispatchers.IO) {
        val response: ApolloResponse<GetUserQuery.Data> = apolloClient.query(GetUserQuery(userId)).execute()
        println(response.data?.user)
        response.data?.user
    }
}
