public class bankAccount {
    private String name;
    private int accountNumber;
    private int savings = 0;

    public bankAccount(String name, int accountNumber, int savings){
        this.name = name;
        this.accountNumber = accountNumber;
        this.savings = savings;
    }

    public bankAccount(String name, int accountNumber){
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    @Override
    public String toString() {
        return "bankAccount{" +
                "name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                ", savings=" + savings +
                '}';
    }
}