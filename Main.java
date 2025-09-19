// package BANK;
/*
 Preetam National Bank allows current and savings account. all types of account can withdraw and deposit
1. Current account has a overdraft facility which allow you to withdraw more  money than your balance.
2. It has an interest rate of only 5%
3. Current account does not let you have Fixed Deposit
4. There is no transaction limit
Whereas saving account needs to maintain 1000 balance, Fixed Deposit is allowed for minimum of 2 years , 
interest rate is 8.25% per annum. You can't remove money during the lock-in period.
Transactions limit is only 50000 more than that the bank does not allow to withdraw in a given day.
a)Ram opens 2 accounts in the bank, one's savings with 10000 and current with 500 only.
Shyam opens 2 account in the same bank, current account with 20000 and 40000 in savings account.
b)Ram is businessman whose needs to do a lot of transactions in a single day. Ram deposits 20000 in savings 
account and 60000 in current account
c)He makes an FD for 25000 for 3 years
d)Ram needs to pay 6000 to paper vendor.
4000 to canteen guy, 25000 to transport.
Ram transfers 20000 to Shyam . Can he transfer?
is Ram allowed to make an FD?
What would be his amount when it matures.
e)Shyam needs to send 30000 to his sister. How can he do that?
Shyam needs to pay school fees 40000 would he be allowed to pay
f)Shyam receives a payment and deposits 45000
g)Again he wants to make FD of 5000 for six months,Would be allowed.What is his total money now in both the accounts
*/

//methods used => deposit,withdraw,fixedDeposit,transfer,finalBal;
//Current: methods used deposit,withdraw,fixedDeposit,finalBal;


public class Main {
    public static void main(String[] args){
        Savings ramS = new Savings("Ram", 10000);
        Current ramC = new Current("Ram", 500);
        Savings shyamS = new Savings("Shyam", 40000);
        Current shyamC = new Current("Shyam", 20000);
        System.out.println("Accounts are created");
        //ram makes deposit into his savings and current
        ramS.deposit(20000,1);
        ramC.deposit(60000,1);
        //ram makes fixed deposit from the amount
        ramS.fixedDeposit(25000, 36);
        //ram pays to vendor,canteen and transport
        ramS.withdraw(6000, 1);
        ramS.withdraw(4000,1);
        ramS.withdraw(25000,1);
        //ram trnsfers to Shyam
        ramS.transfer(shyamS,20000,1);
        //shyam send his sister and school fees;
        shyamS.withdraw(30000, 1);
        shyamS.withdraw(40000,1);
        shyamS.deposit(45000,1);
        shyamS.fixedDeposit(5000,6);
        ramS.finalBal();
        ramC.finalBal();
        shyamS.finalBal();
        shyamC.finalBal();
    }
}
