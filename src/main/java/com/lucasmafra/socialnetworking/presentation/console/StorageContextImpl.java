package com.lucasmafra.socialnetworking.presentation.console;

import com.lucasmafra.socialnetworking.data.InMemoryPostGateway;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.utilities.Clock;

public class StorageContextImpl implements StorageContext {

    private Clock clock;
    private PostGateway postGateway;

    public StorageContextImpl(Clock clock) {
        this.clock = clock;
        postGateway = new InMemoryPostGateway(clock);
    }

    @Override
    public PostGateway getPostGateway() {
        return postGateway;
    }
}
