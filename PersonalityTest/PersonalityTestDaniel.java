import java.util.*;
import java.io.*;
/**
*  author: <Daniel Garza>
*  date:  <Nov 19 2012>
*  CS 312 Assignment 7
*  On my honor, Daniel Garza, this programming assignment is my own work. 
*
*  EID: <dag2788>
*  Section: <Section: <52720 Discussion on W.1-2>
*
* <Brief Description - This program reads from a file "personality.txt" and processes the data and prints it to a file "output.txt"
* The user is promted for a file name, if the file is not found, the user will be promted for a file name until it exists. The file contains
* a name followed by the answers to the The Keirsey Temperament Sorter (personality test) which are divided into 4 categories. The answers to the personality test are analyzed
* by first storing the answer in a string response. Then I took this string and stored it in an array of 10 substring each 7 characters long using a for loop.
* I then analyzed each of substring using nested loops and a switch statement. The outside loop stores the value of each substring in a temporary string.
* Then I used another for loop to access and process each element of each temporary strings (the substrings). Inside this last for loop I used a 
* switch statement in which the value of the counter of the for loop is switched so that each case determines the category of the question. Inside each switch case
* the counters are updated for each category and the percentages are computed. Then each percent is processed through methods to determine the
* personality type of each category of questions. Then these values are sent to a method that prints the processed information to the output file.
*
* Slip Days I am using on this project: 0
* Slip Days I have used this semester: 0
*/
public class PersonalityTestDaniel{

  public static void main (String[] args)  throws IOException { 
     //GET INPUT FOR FILE NAME
     File personalityFile = (getFile());
     Scanner fileRead = new Scanner(personalityFile);   //SCANNER TO READ THE FILE
     PrintStream fileout = new PrintStream((getOutFile())); //CREATES THE OUTPUT FILE
     
     //ANALYSIS FROM THE FILE
          while (fileRead.hasNextLine()){     //WHILE IT CAN CONTINUE TO READ
                
              //VARIABLES THAT NEED TO BE RESET AFTER EACH LOOP
                String name = "";
                String response = "";
                String temp = "";
                String[] subLines = new String[10]; 
            
                name = fileRead.nextLine();     
                response = fileRead.nextLine();
                response = response.toLowerCase();      //TO NOT WORRY ABOUT LETTER CASE
            
                //COUNTERS NEEDED FOR ANALYSIS IN THE INNER LOOP
                
                // COUNTERS FOR CATEGORY 1
                int Icount = 0;
                double Iresponses = 10;
                
                double Ipercentage = 0.0;
                int Ipercent = 0;
                // COUNTERS FOR CATEGORY 2
                int Ncount =0;
                double Nresponses = 20;
                
                double Npercentage = 0.0;
                int Npercent = 0;
                //COUNTERS FOR CATEGORY 3
                int Fcount =0;
                double Fresponses = 20;
                
                double Fpercentage = 0.0;
                int Fpercent = 0;
                // COUNTERS FOR CATEGORY 4
                int Pcount =0;
                double Presponses = 20;
                
                double Ppercentage = 0.0;
                int Ppercent = 0;
          
               //CATEGORY VARIABLES
               char category1 = ' ';
               char category2 = ' ';
               char category3 = ' ';
               char category4 = ' ';
     
               int j =0;   //Substring divider
               for (int i =0; i <10; i++){
                    subLines[i] = response.substring(j,(j+7));     //Store sets of SUBSTRINGS from string response in an array
                    j +=7;   //update the substring divider
               }
        
                                //ENTIRE RESPONSE ANALYSIS THROUGH SUBSTRING ANALYSIS
                for(int k =0; k < 10; k++){
                    
                  temp = subLines[k];   
                                    //TEMP WILL TAKE ON THE VALUE OF EACH SUBSTRING
                                       
                             // ANALYSIS OF EACH SUBSTRING STORED IN TEMP VARIABLE  
                       for(int p = 0; p<= temp.length()-1; p++){    //ITERATES AS MANY TIMES AS THERE ARE SUBSTRINGS IN SUBLINES ARRAY
                          
                                switch(p){
                                         case 0 :       //FOR EVERY CATEGORY 1 QUESTION
                                               if(temp.charAt(0) == 'b')
                                                  Icount++;                     //INCREMENT B RESPONSE
                                                     if(temp.charAt(0) == '-')
                                                        Iresponses--;           //DECREASE TOTAL AMOUNT OF RESPONSE BY AMOUNT OF DASH
                                               Ipercentage = (Icount/Iresponses)*100;
                                               Ipercent = (int)(Ipercentage + 0.5);     //CALCULATE PERCENTAGE OF B ANSWERS
                                         break;
                                         
                                         //EACH CASE HAS THE EXACT LOGIC OF ANALYSIS!!
                                         
                                              case 1 :  //FOR EVERY CATEGORY 2 QUESTIONS
                                              case 2 :
                                                 if(temp.charAt(p) == 'b')
                                                    Ncount++;
                                                     if(temp.charAt(p) == '-')
                                                        Nresponses--;
                                               Npercentage = (Ncount/Nresponses)*100;
                                               Npercent = (int)(Npercentage + 0.5);
                                          break;
                                          
                                          case 3:     //FOR EVERY CATEGORY 3 QUESTIONS
                                          case 4:
                                                 if(temp.charAt(p) == 'b')
                                                    Fcount++;
                                                    if(temp.charAt(p) == '-')
                                                        Fresponses--;
                                         Fpercentage = (Fcount/Fresponses)*100;
                                         Fpercent = (int)(Fpercentage + 0.5);
                                         break;
                                         
                                         case 5:    //FOR EVERY CATEGORY 4 QUESTIONS
                                         case 6: 
                                               if(temp.charAt(p) == 'b')
                                                Pcount++;
                                                    if(temp.charAt(p) == '-')
                                                        Presponses--;
                                            Ppercentage = ((Pcount/Presponses)*100);
                                            Ppercent = (int)(Ppercentage + 0.5);
                                          break;
                
                
                                }   //END SWITCH
           
                       } //END INNER FOR LOOP FOR EACH SUBSTRING ANALISYS
        
               }//END FOR LOOP FOR EACH ELEMENT IN THE ARRAY SUBLINES
            
            
          //DETERMINE THE CATEGORY OF PERSONALITY BASED ON THE PERCENTAGE OF B ANSWERS
          category1 = Cat1(Ipercent);  
          category2 = Cat2(Npercent);
          category3 = Cat3(Fpercent);
          category4 = Cat4(Ppercent);
           
         //PRINT OUT TO FILE 
         
          display (fileout, name,Ipercent, Npercent, Ppercent, Fpercent,  category1,category2, category3, category4);  
       }    //END WHILE LOOP [AFTER FILE HAS NO MORE LINES TO BE READ]
       
       fileout.close(); // TO CLOSE PRINTSTREAM OBJECT
  }//END OF MAIN METHOD
  
  //METHOD TO CHECK FOR A VALID FILE
  public static File getFile() throws IOException{
      
     Scanner read = new Scanner(System.in);      
     System.out.print("Enter a file name: ");
     File tempFile = new File(read.next());
          while(!tempFile.exists()){
              System.out.print("File not found. Try again: "); 
              tempFile = new File(read.next());
          }
          
     return tempFile;    
      
    }
   public static File getOutFile() throws IOException{
      
     Scanner read2 = new Scanner(System.in);      
     System.out.print("Output file name: ");
     File tempFile2 = new File(read2.next());
          
          
     return tempFile2;    
      
    } 
    
      //DETERMINE PERSONALITY TYPE E OR I
  public static char Cat1(int Ipercent){
    
        char temp = ' ';
           if(Ipercent > 50)
                temp = 'I';
                    if(Ipercent == 50)
                            temp = 'X';
                           if(Ipercent < 50)
                                temp = 'E';
                                return temp;             
    }
    
    
      //DETERMINE PERSONALITY TYPE N OR S
   public static char Cat2(int Npercent){
     
        char temp = ' ';
           if(Npercent > 50)
                temp = 'N';
                    if(Npercent == 50)
                            temp = 'X';
                           if(Npercent < 50)
                                temp = 'S';
                                return temp;
  }
  
  
      //DETERMINE PERSONALITY TYPE F OR T
  public static char Cat3(int Fpercent){
      //CHECK FOR F OR T
        char temp = ' ';
           if(Fpercent > 50)
                temp = 'F';
                    if(Fpercent == 50)
                            temp = 'X';
                           if(Fpercent < 50)
                                temp = 'T';
                                return temp;
  }
  
  
      //DETERMINE PERSONALITY TYPE P OR J
  public static char Cat4(int Ppercent){
      //CHECK FOR P OR J
        char temp = ' ';
           if(Ppercent > 50)
                temp = 'P';
                    if(Ppercent == 50)
                            temp = 'X';
                           if(Ppercent < 50)
                                temp = 'J';
                                return temp;
  }
  
    //THIS METHOD PRINTS TO THE OUTUT FILE AND CONSOLE IF THE DASHES ARE REMOVED FROM THE SYSTEM.OUT. STATEMENT
  public static void display (PrintStream fileout,String name,int Ipercent, int Npercent, int Ppercent, int Fpercent, char category1,char category2,char category3,char category4) throws IOException{
        //System.out.println( name + " " + "[" +Ipercent + ", " + Npercent + ", " + Fpercent + ", " + Ppercent + "]"+ " = " + category1 + category2+ category3+ category4);
        fileout.println( name + " " + "[" +Ipercent + ", " + Npercent + ", " + Fpercent + ", " + Ppercent + "]"+ " = " + category1 + category2+ category3+ category4);
        
  }
  }
