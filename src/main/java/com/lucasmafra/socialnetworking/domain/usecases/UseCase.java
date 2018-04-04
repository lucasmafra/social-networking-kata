package com.lucasmafra.socialnetworking.domain.usecases;

public interface UseCase<RequestModel, ResponseModel> {
    public ResponseModel execute(RequestModel request);
}
