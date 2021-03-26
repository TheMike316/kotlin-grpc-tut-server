package com.demo.grpc.client

import com.demo.grpc.HelloRequest
import com.demo.grpc.HelloServiceGrpc
import io.grpc.ManagedChannelBuilder

fun main() {
    val channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        .usePlaintext()
        .build()

    val request = HelloRequest.newBuilder()
        .setFirstName("Baum")
        .setLastName("Baumsson")
        .build()

    val stub = HelloServiceGrpc.newBlockingStub(channel)

    val response = stub.hello(request)

    println(response)

    channel.shutdown()
}
