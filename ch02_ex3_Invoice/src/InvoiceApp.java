import java.util.Scanner;

public class InvoiceApp 
{

    public static void main(String[] args) 
    {
        // welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();  // print a blank line

        // create a Scanner object named sc
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        
        //set these variable to zero before loop, otherwise they will reset to zero each time loop is called
        int invoiceCount = 0;
        double invoiceavg = 0;
        double discountavg = 0;
        double invoiceTotal = 0;
    	double discountTotal= 0;
    	
        // perform invoice calculations until choice isn't equal to "y" or "Y"
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) 
        {
        	//increment the invoiceCount by 1 each time while loop repeats
        	invoiceCount++;
            // get the invoice subtotal from the user
            System.out.print("Enter subtotal:   ");
            double subtotal = sc.nextDouble();

            // calculate the discount amount and total
            double discountPercent;
            if (subtotal >= 500) {
            	discountPercent = .25;
            }else if (subtotal >= 200) {
                discountPercent = .2;
            } else if (subtotal >= 100) {
                discountPercent = .1;
            } else {
                discountPercent = 0.0;
            }
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;
            //each time loop passes, invoiceTotal and discountTotal are summed with the total and discountAMount
            invoiceTotal = invoiceTotal + total;
            discountTotal = discountTotal + discountAmount;
            

            // display the discount amount and total
            String message = "Discount percent: " + discountPercent + "\n"
                           + "Discount amount:  " + discountAmount + "\n"
                           + "Invoice total:    " + total + "\n";            
            System.out.println(message);

            // see if the user wants to continue, using loop to circle back until a y or n is input
            while (!choice.equalsIgnoreCase("N")) 
            {
            	System.out.print("Continue? (y/n): ");
            	choice = sc.next();
            	//If Y, break this loop and return to outerloop
            	if (choice.equalsIgnoreCase("Y")) {break;}
            	System.out.println();
            }
        }
        //find and print counts and averages
        invoiceavg= invoiceTotal/invoiceCount;
        discountavg= discountTotal/invoiceCount;
        System.out.println("Number of invoices: " + invoiceCount);
        System.out.println("Invoice Average: " + invoiceavg);
        System.out.println("Discount Average: " + discountavg);
        System.out.println("");
        System.out.println("Bye");
    }


}