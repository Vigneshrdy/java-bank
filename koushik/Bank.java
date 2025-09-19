
abstract class Bank{
    static final String BankName ="Preetham National Bank";
    String name;
    String type;
    Bank(String name,String type){
        System.out.println("Bank Name: "+BankName);
        System.out.println("Name : "+name);
        System.out.println("type: "+type);
    }
    abstract void deposit(double amount,int day);
    abstract void withdraw(double amount,int day);
    abstract void fixedDeposit(double amount,int months);
}