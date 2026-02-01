package az.wallet.service;

public class WalletService {
    private double balance;
    String[] history;
    double[] amounts;
    private int count = 0;

    public WalletService(int size) {
        this.history = new String[size];
        this.amounts = new double[size];
    }

    public void recharge(double amount) {
        if (count >= 5) {
            System.out.println("Maksimum 5 emeliyyat etmek mumkundur");
            return;
        }
        history[count] = "Recharge " + amount;
        amounts[count] = amount;
        count++;
        balance += amount;
        System.out.println("Balans ugurla " + amount + "AZN artirildi");
    }

    public void spend(double amount, String description) {
        if (count >= 5) {
            System.out.println("Maksimum 5 emeliyyat etmek mumkundur");
            return;
        }
        if (amount > balance) {
            System.out.println("Balansinizda kifayet qeder mebleg yoxdur");
            return;
        } else {
            balance -= amount;
            history[count] = description + " " + amount;
            amounts[count] = -amount;
            count++;
            System.out.println("Balansinizdan " + amount + "AZN cixildi");
        }
    }

    public void printHistory() {
        System.out.println("Emeliyyat tarixcesi : ");
        for (int i = 0; i < count; i++) {
            System.out.println(history[i]);
            System.out.println("-----------------");
        }
    }

    public double getBalance() {
        return balance;
    }
}
