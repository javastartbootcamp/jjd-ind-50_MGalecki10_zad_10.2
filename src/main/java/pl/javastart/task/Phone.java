package pl.javastart.task;

public abstract class Phone {
    private double balance;
    private double smsPrice;
    private double mmsPrice;
    private double callPrice;

    int smsCount = 0;
    int mmsCount = 0;
    int totalCallSeconds = 0;

    public Phone(double balance, double smsPrice, double mmsPrice, double callPrice) {
        this(smsPrice, mmsPrice, callPrice);
        this.balance = balance;
    }

    public Phone(double smsPrice, double mmsPrice, double callPrice) {
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.callPrice = callPrice;
    }

    public void sendSms() {
        System.out.println("SMS wysłany\n");
    }

    public void sendMms() {
        System.out.println("MMS wysłany\n");
    }

    public abstract void call(int seconds);

    public void printAccountState() {
        String info = toString();
        System.out.println(info);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    public double getMmsPrice() {
        return mmsPrice;
    }

    public void setMmsPrice(double mmsPrice) {
        this.mmsPrice = mmsPrice;
    }

    public double getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(double callPrice) {
        this.callPrice = callPrice;
    }

    @Override
    public String toString() {
        return "=== STAN KONTA ===\n"
                + "Wysłanych SMSów: " + smsCount + "\n"
                + "Wysłanych MMSów: " + mmsCount + "\n"
                + "Liczba sekund rozmowy:" + totalCallSeconds + "\n";
    }
}
