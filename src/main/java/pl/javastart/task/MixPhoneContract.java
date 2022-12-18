package pl.javastart.task;

public class MixPhoneContract extends Phone {
    private int smsCount;
    private int mmsCount;
    private int minuteCount;

    public MixPhoneContract(double balance, double smsPrice, double mmsPrice, double callPrice, int smsCount,
                            int mmsCount, int minute) {
        super(balance, smsPrice, mmsPrice, callPrice);
        this.smsCount = smsCount;
        this.mmsCount = mmsCount;
        this.minuteCount = minute;
    }

    @Override
    public void call(int seconds) {
        int minute = seconds / 60;
        double price = minute * getCallPrice();
        if (minuteCount > 0) {
            minuteCount -= minute;
            System.out.println("Połączenie telefoniczne trwało " + seconds + " sekund");
        } else {
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
    }

    @Override
    public void sendSms() {
        if (smsCount > 0) {
            super.sendSms();
            smsCount--;
        } else {
            setBalance(getBalance() - getSmsPrice());
        }
    }

    @Override
    public void sendMms() {
        if (mmsCount > 0) {
            super.sendMms();
            mmsCount--;
        } else {
            setBalance(getBalance() - getMmsPrice());
        }
    }

    @Override
    public String toString() {
        return "Na koncie zostało " + getBalance() + " zł\n"
                + "Zostało smsów: " + smsCount + "\n"
                + "Zostało mmsów: " + mmsCount + "\n"
                + "Zostało minut: " + minuteCount + "\n";
    }
}
