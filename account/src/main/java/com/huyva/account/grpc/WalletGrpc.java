package com.huyva.account.grpc;

import com.huyva.account.payment.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Log4j2
public class WalletGrpc extends WalletServiceGrpc.WalletServiceImplBase {
    @Override
    public void createWallet(CreateWallet request, StreamObserver<CreateWalletResponse> responseObserver) {
        super.createWallet(request, responseObserver);
    }

    @Override
    public void fundIn(FundIn request, StreamObserver<GetWalletInfoResponse> responseObserver) {
        super.fundIn(request, responseObserver);
    }

    @Override
    public void createTransaction(CreateTransaction request, StreamObserver<UpdateTransactionResponse> responseObserver) {
        super.createTransaction(request, responseObserver);
    }

    @Override
    public void getWallet(GetWallet request, StreamObserver<GetWalletInfoResponse> responseObserver) {
        super.getWallet(request, responseObserver);
    }

    @Override
    public void updateTransaction(UpdateTransaction request, StreamObserver<UpdateTransactionResponse> responseObserver) {
        super.updateTransaction(request, responseObserver);
    }
}
