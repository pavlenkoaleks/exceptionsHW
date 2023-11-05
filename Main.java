import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
   public static void main(String[] args) {
       System.out.println("Введите ФИО, дату рождения, телефон, пол через пробел.");
       Scanner scanner = new Scanner(System.in,"Cp866");
       String str = scanner.nextLine();
       String[] data = str.split(" ");
       // for (String item : data) {
       //     System.out.println(item);
      //}
        String men = "m";
        String women = "f";
        int count  = 0;

       if (data.length!=6) {
        System.out.println("Неправильный ввод данных");
        if(data.length>6) {System.out.println("Введено больше, чем нужно");}
        else{System.out.println("Введено меньше, чем нужно");}
       }

       else{
        count++;
        SimpleDateFormat  dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try{
            Date date = dateFormat.parse(data[3]);
            count++;
            

            }
        catch(ParseException e){
            System.out.println("ParseException : неправильный ввод даты");
        }
        


        try{
            int telephone = Integer.parseInt(data[4]);
            count++;

        }
        catch(NumberFormatException e) {System.out.println("NumberFormatException : неправильный ввод телефона");}


        
        if(((data[5].equals(men))||(data[5].equals(women)))==false) {System.out.println("Sex Exception: неправильный ввод пола ");}
        else{count++;}
       }
       

       if(count==4){
          
        try{
            File file = new File(data[0]+".txt") ;
            if(!file.exists()){file.createNewFile();}
            FileWriter pw = new FileWriter(file,true);
            pw.write("<");  pw.write(data[0]); pw.write(">"); 
            pw.write("<");  pw.write(data[1]); pw.write(">"); 
            pw.write("<");  pw.write(data[2]); pw.write(">"); 
            pw.write("<");  pw.write(data[3]); pw.write(">"); 
            pw.write("<");  pw.write(data[4]); pw.write(">"); 
            pw.write("<");  pw.write(data[5]); pw.write(">"); 
            pw.write("\n");
            pw.close();
        }
        catch(IOException e){
             
            System.out.println("file Error"+e );
        } 


       }
       

   }

}


