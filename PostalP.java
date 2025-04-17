import java.util.*;
public class PostalP {
    public static void main(String[] args) {  
        
        Scanner sc = new  Scanner(System.in);
        System.out.println(" =====Enter Your Name=====");
         String name = sc.nextLine();

         System.out.println("=====Enter Your Age=====");
         int age =sc.nextInt();
         sc.nextLine();//consume newline

        System.out.println("=====Enter Your Gender (male/female):=====");
        String gender =sc.nextLine();
        User user = new User(name,age,gender);

        SchemeManager manger = new SchemeManager();
        manger.showSchemes(user);

       



    }
}
class User {   // encapsulation is 
    private String name;
    private int age;
    private String gender;
     
    public User(String name,int age ,String gender ){
        this.name=name;
        this.age= age ;
        this.gender=gender;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getGender(){
        return gender;
    }

}


abstract class PostalScheme{  // abstraction is used

    public abstract void displayScheme();

}
class ChildSchemes extends  PostalScheme{  //inheritance
    public void displayScheme(){
                // 0-10 years
        System.out.println(" |  1.(SSA)sukanya samaruddhi Yojana(For Only Girls Below 10 Years ) ");
        System.out.println(" |  2.(CSS)Child Saving Schemes ");
        System.out.println("=====Where do you want to invest 1 OR 2=====" );
        Scanner sc= new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1 :child.ssa();

            break ;
            case 2 :child.css();
            break ;
        }

    }
}
class SeniorSchemes extends PostalScheme{  //inheritance
    public void displayScheme(){
        System.out.println(" | 1.senior Citizen Saving Scheme(SCSS)");
        System.out.println(" | 2.month Income Scheme(MIS)");
        System.out.println("=====Where do you want to invest 1 OR 2=====" );
        Scanner sc = new Scanner(System.in);
        int choice =sc.nextInt();
        if(choice ==1 ){
            System.out.println("=====How much you want to invest===== ");
            double invest = sc.nextLong();
            double i= invest + (invest *8.2)/100 ;
            System.out.println("Your investing Amount is : "+invest + "  your Maturity Amount for per Annum will be :"+i);

        }
        else if(choice ==2){  //
            System.out.println("=====How much do you Want to invest=====");
            Long invest = sc.nextLong();
            System.out.println("Your investing Amount is : "+invest +"/n your Maturity Amount for per month will be :"+(invest *7.4)/12);

        }
    }
}
class WomenSchemes extends PostalScheme{   // inheritance
        public void displayScheme(){
            System.out.println(" || Mahila Sanman Saving Certificate || ");
        
            Women.mssc();

        }
}
 class GeneralScheme extends PostalScheme{ //inheritance
    public void displayScheme(){
        System.out.println(" | 1.recurring deposite  (RD )");
        System.out.println(" | 2.Time Deposite Account  (TD for 1 year ,TD for 2  year , TD For 3 Year)");
        System.out.println(" | 3.Public Provident Funds(PPF)");
        Scanner sc =new Scanner (System.in);
        int choice = sc.nextInt();
        
        
        switch (choice){
            case 1:General.rd();
            break;
            case 2:General.td();
            break;
            case 3: General.ppf();
            break ;

        }
    }
 }
 class SchemeManager{
    public void showSchemes(User user){
        System.out.println(" HELLO  "+user.getName()+   ", based on  your details,this schemes are suitable :");
    
        if (user.getAge()<=18){
            new ChildSchemes().displayScheme();
        }


        if(user.getAge()>=60){
            new SeniorSchemes().displayScheme();
        }

        if(user.getGender().equals("Female") || user.getGender().equals("f")){

            new WomenSchemes().displayScheme();
        }
        new GeneralScheme().displayScheme(); //applicable to all
    }
 }
 class child{

     public static void ssa(){
        
     //input 
     Scanner sc = new Scanner (System.in);
    System.out.println("Enter the annually invest amount ");
     int yearlyDeposite =sc.nextInt();

     double rate =8.2;  //annual interset rate

     int depositeYears =14;
     int totalyears=21;
     double totalamount=0;
      //compound intersest during deposite 14 years 
      for(int i=1;i<=depositeYears;i++){
        totalamount +=yearlyDeposite*Math.pow(1+rate/100,totalyears-i);

      }
      //no deposite from 15 to 21 just got compound interest 

      //output
       System.out.println("   --- Samrudhhi Yojna Full Calculation--- ");
       System.out.println("YearlyDeposite :"+yearlyDeposite);
       System.out.println("Deposite made for 14 years");
       System.out.println("Maturity after :21 years");
       System.out.println("Interest Rate :"+rate);
       System.out.println("Maturity Amount After 21 Years: ₹ " + String.format("%.2f", totalamount));
        System.out.println("Total Interest Earned: ₹ " + String.format("%.2f", totalamount - (yearlyDeposite * depositeYears)));
    }

 

    public static void css(){
       
        Scanner sc = new Scanner(System.in);

        // Input section
        System.out.println("----- PPF Investment Calculator -----");
        System.out.print("Enter yearly investment amount (₹): ");
        double yearlyInvestment = sc.nextDouble();
        int years =15;
        System.out.print("This is for 15 years : ");
        double interestRate = 7.1;
        
        // Compound interest calculation (compounded yearly)
        double maturityAmount = 0;
        for (int i = 1; i <= years; i++) {
            maturityAmount += yearlyInvestment * Math.pow(1 + interestRate / 100, years - i + 1);
        }

        double totalInvested = yearlyInvestment * years;
        double interestEarned = maturityAmount - totalInvested;

        // Output section
        System.out.println("\n========== PPF Summary ==========");
        
        System.out.printf("Yearly Investment     : ₹%.2f\n", yearlyInvestment);
        System.out.println("Investment Period     : " + years + " years");
        System.out.printf("Interest Rate         : %.2f%%\n", interestRate);

        System.out.println("\n========== Maturity Details ==========");
        System.out.printf("Total Invested Amount : ₹%.2f\n", totalInvested);
        System.out.printf("Maturity Amount       : ₹%.2f\n", maturityAmount);
        System.out.printf("Total Interest Earned : ₹%.2f\n", interestEarned);
            
        System.out.println("\nThank you for using the PPF Calculator!");
    }


}

    
    class General {
        public static void rd(){//recurring deposite method
            System.out.println(" ------This is monthly scheme --- For 5 years ----");
            System.out.println("how much you invest per month");
            Scanner sc = new Scanner(System.in);
            int invest = sc.nextInt();
            double interest =6.8;
            double maturity = invest*12*5*interest;
              System.out.println("Your investment amount is :"+ invest);
              System.out.println("Yearly interest if : "+interest);
              System.out.println("Your maturity amount after 5 years : "+ maturity );
        }

            ///   this method is for time deposite scheme
        public static void td(){

            System.out.println("===== This scheme  is only for Fixed investment ");
           
            Scanner sc =new Scanner(System.in);
            
            System.out.println("===== Enter amount to be invest=====");
            int invest =sc.nextInt();
            
             System.out.println("=====For how many years you want to invest =====");
             System.out.println("| 1. For 1 years ");
             System.out.println("| 2. For 2 years ");
             System.out.println("| 3. For 3 years ");
             System.out.println("| 5. For 5 years ");
              
             int years =sc.nextInt();
             double rateOfInterest=0;
            switch(years){
                case 1 :  rateOfInterest=6.8;
                break;
                case 2 :  rateOfInterest=6.9;
                break;
                case 3 :  rateOfInterest=7.0;
                break;
                case 5 :  rateOfInterest=6.5;
                break;
                default : System.out.println("=====INVALID  YEAR INPUT====="); 
                break;

            }
            double interest=(invest*rateOfInterest*years)/100;
            double maturityAmount= invest+interest;
            System.out.println("Investment Amount : "+invest);
            System.out.println("Number of Years : "+years);
            System.out.println("Interset Rate : "+rateOfInterest);
            System.out.println("Total interest : "+interest);
            System.out.println("Maturity amount : "+maturityAmount);

            
        }
        public static void ppf(){
            Scanner sc =new Scanner (System.in);

            System.out.println("=====WELCOME TO PPF SCHEME======");System.out.println();
            System.out.print("=====Enter your Annual Investment Amount(between 500 to 150000) :");
            double yearlyInvestment=sc.nextDouble();
           if (yearlyInvestment<500 || yearlyInvestment>150000){
            System.out.println("=====Invalid Investment Amount.It Should be between 500 and 150000");
            return ;

}           double rateOfInterest=7.1;//ppf
            double totalAmount=0;
            int years =15;

            //compound intestest yearly
            for(int i=1;i<=years;i++){

                totalAmount=(totalAmount+yearlyInvestment)*(1+rateOfInterest/100);
            }
            System.out.println("Annual Investment : "+yearlyInvestment);
            System.out.println("Number of Years : "+years);
            System.out.println("Interest Rate : "+rateOfInterest + "%");
            System.out.println("Maturity Amount After "+ years + " years  Will be :"+ totalAmount);





        }
        
    }
    class Women{
        public static void mssc(){
            Scanner sc =new Scanner(System.in);
            System.out.println("Enter Investment Amount(between 1000 and 200000)");
            double invest =sc.nextDouble();
            if(invest<1000 || invest >200000){
                System.out.println("Invalid Amount (It Should be between 1000 and 200000 )");
                return ;

            }
            int years=2;
            int n=4; //quarterly compound
            double rateOfInterest=7.5;

            double maturityAmount =invest *Math.pow((1+(rateOfInterest/(n*100))),n*years);
            double interest=maturityAmount-invest;
            System.out.println("Investment Amount :"+invest);
            System.out.println("scheme Duration : "+years +" years");
            System.out.println("Interest rate : "+rateOfInterest +"% (compounded querterly)");
            System.out.println("Total interest:"+interest);
            System.out.println("Maturity Amount :"+maturityAmount);


        
        }
    }
     

 