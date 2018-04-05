package com.lucasmafra.socialnetworking.domain.usecases.readwall;

public interface ReadWallOutputBoundary {

    void present(ReadWallResponseModel response);

    ReadWallViewModel getViewModel();

}
