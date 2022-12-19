package pl.javastart.task;

public class Phone {

    private Contract contract;

    public Phone(Contract contract) {
        this.contract = contract;
    }

    public void sendSms() {
        boolean success = contract.sendSms();
        if (success) {
            System.out.println("SMS wysłany\n");
        } else {
            System.out.println("Nie udało się wysłać");
        }
    }

    public void sendMms() {
        System.out.println("MMS wysłany\n");
    }

    public void printAccountState() {
        contract.printAccountState();
    }

    public void call(int seconds) {
        int secondsCalled = contract.call(seconds);
        if (seconds == secondsCalled) {
            System.out.println("Połączenie telefoniczne trwało " + secondsCalled + " sekund");
        } else {
            
        }
    }
}
