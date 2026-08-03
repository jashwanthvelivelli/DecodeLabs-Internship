import java.util.Scanner;
public class StudentGradeCalculator{
    public static char calculategrade(double percentage){
        if (percentage>=90){
            return 'A';
        }
        else if(percentage>=80){
            return 'B';
        }
        else if(percentage>=70){
            return 'C';
        }
        else if(percentage>=60){
            return 'D';
        }
        else{
            return 'F';
        }
    }
    public static String calculateStatus(double percentage){
        if (percentage>=60){
            return "PASS";
        }
        else{
            return "FAIL";
        }
    }
    public static void displayresult(String studentname,int totalmarks,int maximummarks,double percentage,char grade,String status){
        System.out.println("\n========================================");
        System.out.println("           STUDENT RESULT");
        System.out.println("========================================");

        System.out.println("Student Name: "+ studentname );
        System.out.println("Total Marks : "+ totalmarks+"/"+maximummarks);
        System.out.printf("Percentage  : %.2f%%\n",percentage);
        System.out.println("Grade       : "+grade);
        System.out.println("Status      : "+status);

        System.out.println("========================================");
        System.out.println("            THANK YOU");
        System.out.println("========================================");
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("========================================");

        System.out.print("Enter Student Name: ");
        String studentname=sc.nextLine();

        int numberofsubjects=0;

        while(true){
            try{
                System.out.print("Enter the number of subjects: ");
                numberofsubjects=sc.nextInt();
                if(numberofsubjects>0){
                    break;
                }
                System.out.println("Number of subjects must be greater than 0.");
            }
            catch (Exception e){
                System.out.println("Invalid Input! Please enter numbers only.");
            }
        }

        int totalmarks=0;
        for(int i=1;i<=numberofsubjects;i++){
            int marks;
            while(true){
                try{
                    System.out.print("Enter marks for Subjects "+i+"(0-100): ");
                    marks=sc.nextInt();

                    if(marks>=0 && marks<=100){
                        totalmarks+=marks;
                        break;
                    }
                    else{
                        System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                    }
                }
                catch(Exception e){
                    System.out.println("Invali Input! Please enter numbers only.");
                    sc.next();
                }
            }
        }
        int maximummarks=numberofsubjects*100;
        double percentage=(double) totalmarks/numberofsubjects;
        char grade=calculategrade(percentage);
        String status=calculateStatus(percentage);
        displayresult(studentname,totalmarks,maximummarks,percentage,grade,status);
        sc.close();
    }
}