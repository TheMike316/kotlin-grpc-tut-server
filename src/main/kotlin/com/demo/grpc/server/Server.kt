package com.demo.grpc.server

import io.grpc.ServerBuilder

fun main() {
    val server = ServerBuilder
        .forPort(8080)
        .addService(HelloServiceImpl())
        .build()

    server.start()
    server.awaitTermination()
}
