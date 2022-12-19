package pl.javastart.task;

public class SubscriptionPhoneContract extends Contract {
    private double phoneBill = 0;

    public SubscriptionPhoneContract(double phoneBill) {
        this.phoneBill = phoneBill;
    }

    public boolean sendSms() {
        smsCount++;
        return true;
    }

    public void sendMms() {
        super.sendMms();
        mmsCount++;
        phoneBill += getSmsPrice();
    }

    public void call(int seconds) {
        double price = (seconds / 60) * getCallPrice();
        System.out.println("Połączenie telefoniczne trwało " + seconds + " sekund");
        totalCallSeconds += seconds;
        phoneBill += price;
    }

    @Override
    public void printAccountState() {
        System.out.println("Koszt abonamentu: " + phoneBill);
        printUsages();
    }

    @Override
    public String toString() {
        return super.toString() + "Rachunek: " + phoneBill + " zl";
    }
}


