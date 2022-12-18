package pl.javastart.task;

public class CardPhoneContract extends Phone {

    public CardPhoneContract(double balance, double smsPrice, double mmsPrice, double callPrice) {
        super(balance, smsPrice, mmsPrice, callPrice);
    }

    @Override
    public void sendSms() {
        super.sendSms();
        smsCount++;
        setBalance(getBalance() - getSmsPrice());
    }

    @Override
    public void sendMms() {
        super.sendMms();
        mmsCount++;
        setBalance(getBalance() - getMmsPrice());
    }

    @Override
    public void call(int seconds) {
        double price = (seconds / 60) * getCallPrice();
        if (price <= getBalance()) {
            System.out.println("Połączenie telefoniczne trwało " + seconds + " sekund");
            totalCallSeconds += seconds;
            setBalance(getBalance() - price);
        } else {
            double priceUnderLine = getBalance() - price;
            int leftTime = (int) ((-priceUnderLine / getCallPrice()) * 60);
            int currentTime = seconds - leftTime;
            totalCallSeconds += currentTime;
            System.out.println("Połączenie przerwane po " + currentTime + "sekund. Brak środków na końcie.");
            setBalance(0);
        }
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
    }

    @Override
    public String toString() {
        return super.toString() + "Na koncie zostało " + getBalance() + " zł\n";
    }
}
