package com.lucasmafra.socialnetworking.domain.usecases.readwall;

public interface ReadWallInputBoundary {
    void readWall(ReadWallRequestModel request, ReadWallOutputBoundary presenter);
}
