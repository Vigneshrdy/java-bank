abstract class bank
    {
        String accHolder,accType;

        abstract void deposit(double amount);
        abstract void withdraw(double amount);
        bank(String name,String type)
        {
            this.accHolder=name;
            this.accType=type;
            System.out.println("Account Holder Name: "+name);
            System.out.println("Account Type: "+type);

        }

    }
    class savings extends bank
    {
        double accBalance;
        double dayBalance=50000;
        final static float roi = 0.0825f;
        final static int minDuration=24;
        final static int minBalance=1000;
        double fixedmoney;
        double finalmoney;
        savings(String accHolder,double accBalance)
        {
            super(accHolder,"Savings");
            this.accBalance=accBalance;
        }
        void newDay()
        {
            this.dayBalance=50000;
        }

        void deposit(double amount)
        {
            this.accBalance+=amount;
            System.out.println("The account balance after crediting Rs "+amount+" is: "+this.accBalance);
        }
        void withdraw(double amount)
        {
                if((this.accBalance-amount>=minBalance))
                {
                    if((this.dayBalance-amount)>=0)
                    {
                        this.dayBalance = this.dayBalance - amount;
                        this.accBalance = this.accBalance-amount;
                        System.out.println("Bank Balance "+this.accBalance+" Day balance "+this.dayBalance+" after deducing "+amount);

                    }else{
                        System.out.println("Day balance limit exceeded");
                    }

                }else{
                    System.out.println("Insufficient funds");
                }
        }


         void transfer(double amount,bank b)
         {

             if(this.accBalance-amount>=minBalance && amount<=50000)
             {
                 withdraw(amount);
                 b.deposit(amount);
                 System.out.println("Successfully transferred "+amount+" to "+b.accHolder);
             }else if (accBalance-amount>=minBalance && amount>50000)
             {
                 withdraw(amount);
                 b.deposit(50000);
                 System.out.println("Successfully transferred "+50000+" to "+b.accHolder);
             }
             else{
                 System.out.println("Insufficient Balance");
             }
         }
         void fixedDeposit(double amount,int period)
         {
            if(period>=minDuration)
            {
                if(this.accBalance-amount>=minBalance)
                {
                    this.fixedmoney=amount;
                    this.accBalance-=amount;
                    this.finalmoney=amount+(amount*period*roi)/100;
                }else{
                    System.out.println("Insufficient balance");
                }
            }else{
                System.out.println("FD Not possible due to less period");
            }
         }
        void finalBalance() {
            System.out.println(this.accHolder +" has "+this.accBalance+" in Savings account with fd "+this.finalmoney);
        }
    }


    class current extends bank
    {
        double odLimit = 10000;
        double odTaken = 0;
        final static float roi = 0.05f;
        double accBalance;
        current(String accHolder,double accBalance)
        {
            super(accHolder,"Current");
            this.accBalance=accBalance;
        }
        void fixedDeposit(double amount, int months) {
            System.out.println("FD not allowed in Current Account");
        }
        void deposit(double amount)
        {
            if(this.odTaken>0)
            {
                double interest = this.odTaken * roi;
                double totalDue = this.odTaken + interest;
                System.out.println("Overdraft repayment due: " + totalDue);

                if(amount>=totalDue)
                {
                    amount-=totalDue;
                    totalDue=0;
                    System.out.println("Overdraft fully cleared!");
                    this.accBalance+=amount;
                }else{
                    this.odTaken-=amount;
                    this.odLimit+=amount;
                    System.out.println("Partial overdraft repayment of " + amount);

                }
            }else {
                this.accBalance+=amount;
        }
        }
        void withdraw(double amount)
        {
                if(this.accBalance-amount>=0)
                {
                    accBalance-=amount;
                    System.out.println("The account balance after debiting Rs "+amount+" is: "+accBalance);
                }else if (this.odLimit+(this.accBalance-amount)>=0){
                    this.odTaken=amount-this.accBalance;
                    this.odLimit-=this.odTaken;
                    System.out.println("Over draft used "+odTaken);
                }
                else{
                    System.out.println("Insufficinet Balance");
                }
        }
        void transfer(double amount,bank b)
        {


                withdraw(amount);
                b.deposit(amount);

        }
        void finalBalance() {
            System.out.println(this.accHolder + "'s Current Account balance: " + this.accBalance +" Overdraft left: " + this.odLimit +" Overdraft taken: " + this.odTaken);
        }
    }
    public class Main {
        public static void main(String[] args)
        {
            // Ram's Accounts
            savings ramSavings = new savings("Ram", 10000);
            current ramCurrent = new current("Ram", 500);

            // Shyam's Accounts
            current shyamCurrent = new current("Shyam", 20000);
            savings shyamSavings = new savings("Shyam", 40000);

            ramSavings.deposit(20000);
            ramCurrent.deposit(60000);

            ramSavings.fixedDeposit(25000, 36);

            ramCurrent.withdraw(6000);
            ramCurrent.withdraw(4000);
            ramCurrent.withdraw(25000);

            ramCurrent.withdraw(20000);
            shyamSavings.deposit(20000);

            shyamSavings.withdraw(30000);

            shyamSavings.withdraw(40000);

            shyamSavings.deposit(45000);

            shyamSavings.fixedDeposit(5000, 6);

            System.out.println("\nFinal Balances");
            ramSavings.finalBalance();
            ramCurrent.finalBalance();
            shyamSavings.finalBalance();
            shyamCurrent.finalBalance();
        }
    }
