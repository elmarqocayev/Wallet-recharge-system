package az.wallet.main;

import az.wallet.service.WalletService;

public class Main {
    public static void main(String[] args) {
        WalletService walletService = new WalletService(5);
        walletService.recharge(100.0);
        walletService.recharge(50.0);

        double balance = walletService.getBalance();
        System.out.println("Cari balans : " + balance);

        walletService.spend(30, "Coffee");
        walletService.spend(50, "Books");


        walletService.printHistory();

    }
}