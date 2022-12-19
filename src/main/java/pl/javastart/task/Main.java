package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        CardPhoneContract cardPhoneContract = new CardPhoneContract(0.7, .1, .2, 0.5);
        SubscriptionPhoneContract subscriptionPhoneContract = new SubscriptionPhoneContract(.2, .1,
                0.5);
        MixPhoneContract mixPhoneContract = new MixPhoneContract(3, 0.2, 0.3, 0.5,
                2, 2, 2);


        Phone phone = new Phone(new CardPhoneContract(0.2, .1, .2, 0.5));
        phone.printAccountState();
        
        phone.sendSms();
        phone.call(180);

//        cardPhoneContract.printAccountState();
//        cardPhoneContract.sendSms();
//        cardPhoneContract.call(32);
//        cardPhoneContract.printAccountState();
//
//        subscriptionPhoneContract.printAccountState();
//        subscriptionPhoneContract.sendSms();
//        subscriptionPhoneContract.sendMms();
//        subscriptionPhoneContract.call(345);
//        subscriptionPhoneContract.printAccountState();


        mixPhoneContract.sendSms();
        mixPhoneContract.sendSms();

        mixPhoneContract.sendMms();
        mixPhoneContract.sendMms();



        mixPhoneContract.printAccountState();

    }
}
