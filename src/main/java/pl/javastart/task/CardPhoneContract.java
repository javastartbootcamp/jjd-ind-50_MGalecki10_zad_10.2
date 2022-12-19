package pl.javastart.task;

public class CardPhoneContract extends Contract {

    protected double balance;
    protected double smsPrice;
    protected double mmsPrice;
    protected double callPrice;

    public CardPhoneContract(double balance, double smsPrice, double mmsPrice, double callPrice) {
        this.balance = balance;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.callPrice = callPrice;
    }

    @Override
    public boolean sendSms() {
        if (balance > smsPrice) {
            smsCount++;
            balance = balance - smsPrice;
            return true;
        } else {
            return false;
        }
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
        System.out.println("Koszt abonamentu: " + phoneBill);
    }

    @Override
    public String toString() {
        return super.toString() + "Na koncie zostało " + getBalance() + " zł\n";
    }
}
