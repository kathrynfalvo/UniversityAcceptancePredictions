import java.util.Scanner;

public class GroupAssignment {

	
//Question #1 - Group 8 
public static void main(String[] args) {
	System.out.println("Welcome in Humber College!"); 
	


//Question #2 - Group 8

int attempt = 0;
Scanner read = new Scanner(System.in);
String password;
boolean validPasswd = false;
{

do {
    validPasswd = false;
    System.out.print("Please enter password : ");
    password = read.nextLine();
    attempt++;

    int numUpper = 0;
    int numNumbers = 0;
    int numSpecialChars = 0;
    for (int i = 0; i < password.length(); i++) {
        if (Character.isUpperCase(password.charAt(i))) {
            numUpper++;
        } else if (Character.isDigit(password.charAt(i))) {
            numNumbers++;
        } else if (!Character.isDigit(password.charAt(i)) && !Character.isAlphabetic(password.charAt(i))) {
            numSpecialChars++;
        }
    }

    if (password.length() >= 10 && numUpper >= 1 && (numNumbers == 2 || numNumbers == 3)
            && numSpecialChars == 1) {
        validPasswd = true;
    } else if (attempt == 3) {
        System.out.println("No attempts left");
        System.exit(0);
    } else {
        System.out.println("Please enter a valid password...[ Attempts left : " + (3 - attempt) + "]");
        System.out.println("Password policy : ");
        System.out.println("Minimum length of password = 10");
        System.out.println("Password must contain at least 1 upper case letter");
        System.out.println("Password must contain exactly 2 or 3 numbers");
        System.out.println("Password must contain exactly 1 special character");
    }

} while (attempt < 3 && !validPasswd);
	if (attempt < 3)
		System.out.println("You have entered a valid password.");

{
// Question 3 - Group 8
	 attempt = 0;
     int numStudents = 0;
     do {
         System.out.print("Please enter number of students [1-50] : ");
         numStudents = read.nextInt();
         read.nextLine();
         attempt++;
         if ((numStudents < 1 || numStudents > 50) && attempt < 3) {
             System.out.println("Please enter correct number of students [ Attempts left : " + (3 - attempt) + "]");
         } else if ((numStudents < 1 || numStudents > 50)) {
             System.out.println("No attempts left");
             System.exit(0);
         }

     } while (attempt < 3 && (numStudents < 1 || numStudents > 50));

 //Questions 4,5,6 - Group 8
   
     
     double marks[][] = new double[numStudents][6];
     int credits[] = new int[6];
     double gpa[] = new double[numStudents];
     String names[] = new String[numStudents];
     credits[0] = 4; // credit for Math
     credits[1] = 5; // credit for Science
     credits[2] = 4; // credit for Language
     credits[3] = 3; // credit for Drama
     credits[4] = 2; // credit for Music
     credits[5] = 4; // credit for Biology
     
     double totalCredits = credits[0] + credits[1] + credits[2] + credits[3] + credits[4] + credits[5];
     for (int i = 0; i < numStudents; i++) {
         System.out.print("\nEnter name of Student " + (i + 1) + ": ");
         names[i] = read.nextLine();
         double sum = 0;
         System.out.print("Input your mark in Math: ");
         marks[i][0] = read.nextDouble();
         read.nextLine();
         sum += marks[i][0] * credits[0];
         System.out.print("Input your mark in Science: ");
         marks[i][1] = read.nextDouble();
         read.nextLine();
         sum += marks[i][1] * credits[1];
         System.out.print("Input your mark in Language: ");
         marks[i][2] = read.nextDouble();
         read.nextLine();
         sum += marks[i][2] * credits[2];
         System.out.print("Input your mark in Drama: ");
         marks[i][3] = read.nextDouble();
         read.nextLine();
         sum += marks[i][3] * credits[3];
         System.out.print("Input your mark in Music: ");
         marks[i][4] = read.nextDouble();
         read.nextLine();
         sum += marks[i][4] * credits[4];
         System.out.print("Input your mark in Biology: ");
         marks[i][5] = read.nextDouble();
         read.nextLine();
         sum += marks[i][5] * credits[5];
         gpa[i] = sum / totalCredits;
         System.out.println("GPA = " + gpa[i]);
     }     
     
 //Questions 7,8 - Group 8    
     int count = 0;
     int notAccepted = 0;
     var engineNames = "";
     int engCount = 0; 
     var busNames = "";
     int busCount = 0;
     var lawNames = "";
     int lawCount = 0;
     var naNames = "";
     int naCount = 0;
     for (int i = 0; i < numStudents; i++) {
 
    	 //Setting bounds for Engineering Requirements 
         if (gpa[i] > 90 && gpa[i] <= 100) {
        	 if (engineNames != "") {
        		 engineNames = engineNames + ", " + names[i]; 
        	 } else {
        		 engineNames = names[i];
        	 } 
        	 engCount++;
         }

         //Setting bounds for Business Requirements
         if (gpa[i] > 80 && gpa[i] <= 90) {
        	 if (busNames != "") {
        		 busNames = busNames + ", " + names[i]; 
        	 } else {
        		 busNames = names[i];
        	 }
        	 busCount++;
         }
    
         //Setting bounds for Law School requirements 
         if (gpa[i] > 70 && gpa[i] <= 80) {
        	 if (lawNames != "") {
        		 lawNames = lawNames + ", " + names[i]; 
        	 } else {
        		 lawNames = names[i];
        
        	 }
        	 lawCount++;
         }
         
         //No one under Gpa of 70% will be accepted.
        if (gpa[i] <70) {
        	if (naNames != "") {
       		 naNames = naNames + ", " + names[i]; 
       	    } else {
       		 naNames = names[i];
        	
            }
        	naCount++;
        
         }
        
         count++; 
     }
     
         //Total Count for Students Accepted
         double accCount = 0;
      		accCount += engCount + busCount + lawCount;
     
    
     	//Print of report 1 - showing names accepted 
     System.out.println("\n\nReport 1");
     System.out.println("Students accepted to School of Engineering: " + engineNames);
     System.out.println("Students accepted to School of Business: " + busNames);
     System.out.println("Students accepted to Law School: " + lawNames);
     System.out.println("Students not accepted: " + naNames);
    
     	// Print of report 2 - showing counts 
     System.out.println("\n\nReport 2");
     //Number of students accepted and their distribution to each school
     System.out.println("Total Students Applied:" + numStudents);
     System.out.println("Total Students Accepted to School of Engineering:" + engCount);
     System.out.println("Total Students Accepted to School of Business:" + busCount);
     System.out.println("Total Students Accepted to Law School:" + lawCount);
     System.out.println("Total Students Accepted to a School:" + accCount);
    
     
     	// Report 3 - showing count of students  not accepted
     System.out.println("\n\nReport 3");
     System.out.println("Total students not accepted = " + naCount);
     
     
     	// For report 4, we decided to calculate: Acceptance Rate 
     System.out.println("\n\nReport 4");
     double accRate = accCount / numStudents; 
     System.out.println("Acceptance Rate (%) = " + accRate*100); 
    		 
}
}
}
}









