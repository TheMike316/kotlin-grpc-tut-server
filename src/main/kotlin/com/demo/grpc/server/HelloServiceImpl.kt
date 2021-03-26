package com.demo.grpc.server

import com.demo.grpc.HelloRequest
import com.demo.grpc.HelloResponse
import com.demo.grpc.HelloServiceGrpc
import io.grpc.stub.StreamObserver

class HelloServiceImpl : HelloServiceGrpc.HelloServiceImplBase() {

    override fun hello(request: HelloRequest, observer: StreamObserver<HelloResponse>) {
        val response = HelloResponse.newBuilder()
            .setGreeting("Hello ${request.firstName} ${request.lastName}")
            .build()

        observer.onNext(response)
        observer.onCompleted()
    }
}
