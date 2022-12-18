package pl.javastart.task;

public class SubscriptionPhoneContract extends Phone {
    double phoneBill = 0;

    public SubscriptionPhoneContract(double smsPrice, double mmsPrice, double callPrice) {
        super(smsPrice, mmsPrice, callPrice);
    }

    @Override
    public void sendSms() {
        super.sendSms();
        smsCount++;
        phoneBill += getSmsPrice();
    }

    @Override
    public void sendMms() {
        super.sendMms();
        mmsCount++;
        phoneBill += getSmsPrice();
    }

    @Override
    public void call(int seconds) {
        double price = (seconds / 60) * getCallPrice();
        System.out.println("Połączenie telefoniczne trwało " + seconds + " sekund");
        totalCallSeconds += seconds;
        phoneBill += price;
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
    }

    @Override
    public String toString() {
        return super.toString() + "Rachunek: " + phoneBill + " zl";
    }
}


