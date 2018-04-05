package com.lucasmafra.socialnetworking.domain.controller;

public interface ViewController<ViewModel> {
    void generateView(ViewModel viewModel);
}
