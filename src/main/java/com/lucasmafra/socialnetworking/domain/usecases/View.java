package com.lucasmafra.socialnetworking.domain.usecases;

public interface View<ViewModel> {
    void generateView(ViewModel viewModel);
}
