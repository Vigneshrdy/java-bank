// package BANK;

class Current extends Bank{
    double acc_bal;
    String name;
    int day;
    double od_amt;
    float intr = 0.05f; 
    double od_int;
    String type = "Current";
    Current(String name,double amount){
        super(name,"Current");
        this.acc_bal = amount;
    }
    //Current: methods used deposit,withdraw,fixedDeposit,finalBal;
    void deposit(double amount,int day){
        acc_bal+=amount;
        System.out.println(amount+" gets credited into your account");
        System.out.println("The account balance rn is: "+acc_bal);
        if(this.day==day){
            if(amount>od_int){
                amount-=od_int;
            }
            if(amount>=od_amt){
                amount-=od_amt;
                acc_bal+=amount;
                od_amt=0;
            }
            else{
                od_amt-=amount;
                amount = 0;
            }
        }
    }
    void withdraw(double amount,int day){
        double a=(amount-acc_bal);
        if(this.day==day){
            if(a<0){
                acc_bal-=amount;
                System.out.println(amount+" is debited");
                System.out.println("The account balance rn is: "+acc_bal);
            }
            if(a>=0){
                acc_bal=0;
                od_amt+=a;
            }
            od_int+= od_amt*intr*(1/365);
        }     
    }
    void fixedDeposit(double amount,int months){
        System.out.println("No Fixed Deposit possible for this Account");
    }
    void finalBal(){
        System.out.println("Final Balance after all transactions: "+acc_bal);
        if(od_amt!=0){
            System.out.println("The Overdraft amount is: "+od_amt);
            System.out.println("The overdraft interest is:"+od_int);
            System.out.println("The total Balance after overdraft is: "+(acc_bal-(od_amt+od_int)));
        }
    }
}
