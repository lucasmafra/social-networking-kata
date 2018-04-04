package com.lucasmafra.socialnetworking.presentation.console;

import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;

public interface StorageContext {
    PostGateway getPostGateway();
}
