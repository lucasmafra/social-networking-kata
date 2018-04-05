package com.lucasmafra.socialnetworking.domain.usecases.readwall;

public interface ReadWallOutputBoundary<ViewModel> {

    void present(ReadWallResponseModel response);
    ViewModel getViewModel();

}
