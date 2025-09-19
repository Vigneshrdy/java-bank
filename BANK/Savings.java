package BANK;


class Savings extends Bank{
//    Scanner s = new Scanner(System.in);
    double money;
    int day;
    Savings(String name,double money){
        super(name,"Savings");
        this.money = money;
    }
    //methods used => deposit,withdraw,fixedDeposit,transfer,finalBal
    static int min_acc_bal = 1000;
    int period = 2; //s.nextInt()
    int total_time = period*12;
    double roi = 8.25;
    static int limit = 50000;
    int k=0;
    void deposit(double amount,int day){
        if(this.day==day){
            money+=amount;
            System.out.println(amount+" got credited from account");
            System.out.println("The account balance rn is: "+money);
        }
    }
    void withdraw(double amount,int day){
        if(this.day==day){
            if(money-amount>=min_acc_bal){
                k+=amount;
                if(k<limit){
                    money-=amount;
                    System.out.println(amount+" got debited from account");
                    System.out.println("The account balance rn is: "+money);
                }
                else{
                    System.out.println("You are out of Transaction limit");
                }
            }
            else{
                System.out.println("You have insufficient Account Balance");
            }
        }
        else{
            k = 0;
            if(money-amount>=min_acc_bal){
                k+=amount;
                if(k<limit){
                    money-=amount;
                    System.out.println(amount+" got debited from account");
                    System.out.println("The account balance rn is: "+money);
                }
                else{
                    System.out.println("You are out of Transaction limit");
                }
            }
            else{
                System.out.println("You have insufficient Account Balance");
            }
        }
    }
    void fixedDeposit(double amount,int months){
        if(months<total_time){
            System.out.println("The fixed Deposit is not possible , Minimum 2 years maturity period required or the amount is insufficient");
        }
        else{
            money-=amount;
            double fin_amount = amount+(amount*total_time*roi)/1200;
            System.out.println("The Total Amount after "+(total_time/12)+" years is: "+fin_amount);
        }
    }
    void transfer(Bank a,int amount,int day){
        double qwerty = money;
        this.withdraw(amount,day);
        if(qwerty!=money){
            a.deposit(amount,day);
        }
        else{
            System.out.println("The transfer is not possible due to insufficient funds");
        }
    }
    void finalBal(){
        System.out.println("The final balance of the saving Account is: "+money);
    }
}
