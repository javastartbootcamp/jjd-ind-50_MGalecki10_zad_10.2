package pl.javastart.task;

public abstract class Contract {
    int smsCount = 0;
    int mmsCount = 0;
    int totalCallSeconds = 0;

    public abstract void printAccountState();
    
    protected void printUsages() {
        System.out.println("Wysłanych smsów: " + smsCount);
    }

    public abstract boolean sendSms();

    public abstract int call(int seconds);
}
