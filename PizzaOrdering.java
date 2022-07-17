package com.jap.pizzaorderingsystem;

import java.util.Scanner;

public class PizzaOrdering {
    public static void main(String[] args) {
        // Make no changes to the main method
        PizzaOrdering pizzaOrdering = new PizzaOrdering();

        String name = "";
        String email = "";
        long phoneNo = 0;
        String address = "";

        // Input customer details
        Scanner scanner = new Scanner(System.in);
        System.out.println("!!! Welcome !!!");
        System.out.println("!!! Enter customer details for placing an order !!!");

        System.out.println("Enter your Name");
        name = scanner.next();
        System.out.println("Enter your Email");
        email = scanner.next();
        System.out.println("Enter your ContactNo.");
        phoneNo = scanner.nextLong();
        System.out.println("Enter your Address");
        address = scanner.next();
        scanner.nextLine();
        System.out.println("\n");
        System.out.println("!!! Thank you for providing your details !!!");
        System.out.println("\n");

        // Display main menu and estimate bill based on user's choice
        int totalPizzaBill = 0;
        totalPizzaBill = pizzaOrdering.displayMenuAndCalculateTotalBill(totalPizzaBill);
        System.out.println("\n");
        System.out.println("Total amount : " + totalPizzaBill);
        System.out.println("\n");

        // Estimate discount amount based on total pizza bill and calculate final bill.
        int discountAmount = pizzaOrdering.estimateDiscountAmount(totalPizzaBill);
        int billAfterDiscount = totalPizzaBill - discountAmount;
        System.out.println("\n");

        // Input the type of delivery of order and add delivery fee and tip charge to total bill
        System.out.println("Please enter 1 for Pick up and 2 for delivery");
        int delivery = scanner.nextInt();
        int deliveryCharge = 0;
        int tipCharge = 0;

        if (delivery == 2)
        {
            deliveryCharge = 100;
            System.out.println("Do you want to give tip to Delivery Boy ");
            System.out.println("Press 0 if you dont want");
            tipCharge = scanner.nextInt();
        }


        // Estimate and display final pizza order bill
        int finalBill = pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(deliveryCharge, tipCharge, billAfterDiscount);
        pizzaOrdering.displayFinalBill(name, phoneNo, totalPizzaBill, discountAmount, deliveryCharge, tipCharge, finalBill);
    }


    // Function to display main menu and call respective methods based on user's choice
    // Do not change the method
    public int displayMenuAndCalculateTotalBill(int totalPizzaBill)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the item from the Main Menu");
        System.out.println("\n");

        //int input = 0;
        //do {
            System.out.format("%10s %30s", "Srno", "Item Category\n");
            System.out.format("%10s %30s", "1", "Pizza\n");
            System.out.format("%10s %30s", "2", "Garlic Bread\n");
            System.out.format("%10s %30s", "3", "Beverages\n");
            System.out.println();
            System.out.println("Enter your Choice of item");
            int choiceForItems = scanner.nextInt();

            if (choiceForItems == 1) {
                //System.out.println("Please enter the number of pizza you want to order :");
                //int noOfPizza = scanner.nextInt();
                //int t1 = displayPizzaChoicesAndCalculateTotalBill(noOfPizza, totalPizzaBill);
                totalPizzaBill = displayPizzaChoicesAndCalculateTotalBill(totalPizzaBill);
            } // End of pizza

            else if (choiceForItems == 2) {
                System.out.println("Menu for breads:");
                System.out.println("S. No.      Bread                        Price (in Rupees)");
                System.out.println("1          Stuffed Garlic Bread          90");
                System.out.println("2          Plain Garlic Bread Sticks     80");
                System.out.println("Please select the bread you want");
                //System.out.println("Enter your choice of bread");
                System.out.println("press '0' if you dont want bread");

                int breadChoice=scanner.nextInt();
                //int totalBreadBill = displayBreadChoiceAndCalculateBill(breadChoice);
                totalPizzaBill = displayBreadChoiceAndCalculateBill(breadChoice);
            }// End of breads

            else if (choiceForItems == 3) {

                System.out.println("Please enter the beverage of bread you want:");
                System.out.println("S. No.       Beverage       Price (in Rupees)");
                System.out.println("1            Pepsi          60");
                System.out.println("2            Coke           60");
                //System.out.println("Enter your choice of beverage");
                System.out.println("press '0' if you dont want beverage");

                int drinksChoice=scanner.nextInt();
                //int totalDrinksBill = displayDrinksChoicesAndCalculateBill(drinksChoice);
                totalPizzaBill = displayDrinksChoicesAndCalculateBill(drinksChoice);
                //totalPizzaBill =
            } // End of drinks

            System.out.println("\n");
            System.out.println("Your total Pizza Bill :" + totalPizzaBill);
            System.out.println("\n");
            System.out.println("Do you want to place another order enter 1 to continue or 0 to exit");
            //input = scanner.nextInt();

         //while (input == 1);
        return totalPizzaBill;
    }


    public int displayPizzaChoicesAndCalculateTotalBill(int totalPizzaBill) {
        Scanner scanner = new Scanner(System.in);

        PizzaOrdering pizzaOrdering = new PizzaOrdering();

        //for (int i = 0; i < noOfPizza; i++) {
        // Call the method displayPizzaChoices() to display pizza choices
        pizzaOrdering.displayPizzaChoices();
        // accept the choice of pizza from user
        System.out.println("Select the pizza you want to order");
        //int pizzaChoice = scanner.nextInt();
		int pizzaChoice = 5;
        // accept the size of the pizza
        System.out.println("Enter Size of Pizza (L for Large, M for Medium, R for Regular) :");
        //char choice1=scanner.next().charAt(0);
        //char choice1='L';
        char pizzaSize = 'L';
        // Call the method calculateBillBasedOnPizzaChoiceAndSize(totalPizzaBill, pizzaChoice, pizzaSize)
        // to calculate total bill amount based on pizza choice and size
        int costOfPizza=pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(pizzaChoice,pizzaSize);
        //totalPizzaBill = 0;

        // Accept the choice of crust from user
        System.out.println("Do you want to choose Crust of your choice ");

        System.out.println("Choose the crust you want");
        System.out.println("S. No.    Crust              Price (in Rupees)");
        System.out.println("1         Wheat Thin Crust     60");
        System.out.println("2         Fresh Pan Base       80");
        System.out.println("3         Hand Tossed          70");
        System.out.println("press '0' if you dont want crust");

        //String choiceOfCrust = scanner.next();
        //if(choiceOfCrust=="yes")
        //{
        int crustChoice =scanner.nextInt();


        //int costOfCrust = 0;

        // Call method displayCrustChoicesAndEstimatePrice(choiceOfCrust) to display the crust choice
        // and returns cost based on crust choice
        int costOfCrust = pizzaOrdering.displayCrustChoicesAndEstimatePrice(crustChoice);
        //String choiceOfCrust, int crustChoice

        System.out.println("\n");
        // Accept the choice of extra toppings from user
        System.out.println("Do you want to choose extra Toppings ");

        System.out.println("Choose the toppings you want");
        System.out.println("S. No.      Toppings         Price (in Rupees)");
        System.out.println("1           Extra Cheese     80");
        System.out.println("2           Veg Toppings     120");
        System.out.println("press '0' if you dont want toppings");

        int toppingsChoice =scanner.nextInt();
        // Call method displayToppingsAndEstimatePrice(choiceOfToppings) to display the choice of toppings
        // and returns the cost of the toppings based on toppings choice
        int costOfToppings = pizzaOrdering.displayToppingsAndEstimatePrice(toppingsChoice);

        // Call method calculateBillWithCrustAndToppings(totalPizzaBill, costOfCrust, costOfToppings)
        // to calculate the total cost of the pizza
        totalPizzaBill = pizzaOrdering.calculateBillWithCrustAndToppings(costOfPizza,costOfCrust,costOfToppings);
        //}
        // return the total amount
        return totalPizzaBill;
    }

    // Function displays choices of pizza
    public void displayPizzaChoices() {
        // Use System.out.format to display the menu in a tabular format

        System.out.println("S. No    Pizza                        Regular      Medium     Large");
        System.out.println("1        African Peri Peri Veg         NA           350         450");
        System.out.println("2        Barbecue Veg                  NA           300         400");
        System.out.println("3        Jamaican Jerk Veg             250          350         450");
        System.out.println("4        What-a-pizza Exotic           200          300         400");
        System.out.println("5        English Cheddar and Veggies   175          375         500");

    }

    // Function calculates total pizza bill based on choice of pizza and its size
    public int calculateBillBasedOnPizzaChoiceAndSize(int pizzaChoice, char pizzaSize)
    {
        // write logic to calculate the cost of pizza based on pizza choice and size
        // return the cost calculated

        int pizzaPrice=0;

        if (pizzaChoice==1)
        {
            if(pizzaSize=='R')
            {
                pizzaPrice=0;
            }
            else if(pizzaSize=='M')
            {
                pizzaPrice=350;
            }
            else if(pizzaSize=='L')
            {
                pizzaPrice=450;
            }
        }
        else if (pizzaChoice==2)
        {
            if(pizzaSize=='R')
            {
                pizzaPrice=0;
            }
            else if(pizzaSize=='M')
            {
                pizzaPrice=300;
            }
            else if(pizzaSize=='L')
            {
                pizzaPrice=400;
            }
        }
        else if (pizzaChoice==3)
        {
            if(pizzaSize=='R')
            {
                pizzaPrice=250;
            }
            else if(pizzaSize=='M')
            {
                pizzaPrice=350;
            }
            else if(pizzaSize=='L')
            {
                pizzaPrice=450;
            }
        }
        else if (pizzaChoice==4)
        {
            if(pizzaSize=='R')
            {
                pizzaPrice=200;
            }
            else if(pizzaSize=='M')
            {
                pizzaPrice=300;
            }
            else if(pizzaSize=='L')
            {
                pizzaPrice=400;
            }
        }
        else if (pizzaChoice==5)
        {
            if(pizzaSize=='R')
            {
                pizzaPrice=175;
            }
            else if(pizzaSize=='M')
            {
                pizzaPrice=375;
            }
            else if(pizzaSize=='L')
            {
                pizzaPrice=500;
            }
        }

        return pizzaPrice;
    }

    // Function displays choices of crusts and calls method to estimate cost of crust
    public int displayCrustChoicesAndEstimatePrice(int crustChoice) {

        //Call method estimatePriceOfCrust(crustChoice) to estimate the cost and return the cost
        //PizzaOrdering pizzaOrdering = new PizzaOrdering();
        int result2=crustChoice;
        //int result2=pizzaOrdering.estimatePriceOfCrust(c);

        int priceOfCrust=0;

        if(result2==0)
        {
            priceOfCrust=0;
        }
        else if (result2==1)
        {
            priceOfCrust=60;
        }
        else if (result2==2)
        {
            priceOfCrust=80;
        }
        else if (result2==3)
        {
            priceOfCrust=70;
        }
        else
        {
            priceOfCrust=0;
        }

        return priceOfCrust;
    }

    // Function estimates cost of crust based on user's choice of crust
    /*public int estimatePriceOfCrust(int crustChoice) {
        //write logic to calculate the estimated price based on choice of crust
        // return the estimated price
        int result=0;

		if(crustChoice==1)
		{
			result=1;
		}
		else if (crustChoice==2)
		{
			result=2;
		}
		else if (crustChoice==3)
		{
			result=3;
		}

        return result;
    }*/

    // Function displays choices of toppings ans calls method to estimate price of topping
    public int displayToppingsAndEstimatePrice(int toppingsChoice) {
        // Call method estimatePriceOfToppings(int toppingsChoice) to estimate the cost and return the cost

        int result3=toppingsChoice;

        int priceOfToppings=0;


        if(result3==0)
        {
            priceOfToppings=0;
        }
        else if (result3==1)
        {
            priceOfToppings=80;
        }
        else if (result3==2)
        {
            priceOfToppings=120;
        }

        return priceOfToppings;
    }

    // Function estimates cost of toppings based on user's choice of toppings
    /*public int estimatePriceOfToppings(int toppingsChoice) {
        //write logic to calculate the estimated price based on choice of toppings
        // return the estimated price
        return -1;
    }*/

    // Function calculates total pizza bill by adding cost of crust and toppings
    public int calculateBillWithCrustAndToppings(int costOfPizza,int costOfCrust,int costOfToppings) {

        int totalCostWithPizzaCrustToppings= costOfPizza + costOfCrust + costOfToppings;

        return totalCostWithPizzaCrustToppings;

    }

    // Function displays choices of bread and calls method to calculates total bill
    public int displayBreadChoiceAndCalculateBill(int breadChoice) {
        // display the choice of breads

        int result4=breadChoice;
        int priceOfBread=0;


        if(result4==0)
        {
            priceOfBread=0;
        }
        else if(result4==1)
        {
            priceOfBread=90;
        }
        else if(result4==2)
        {
            priceOfBread=80;
        }
        // Call the method calculateBillBasedOnChoiceOfBread(breadChoice, totalPizzaBill) to calculate total cost
        // return the total bill amount
        return priceOfBread;
    }

    // Function estimates cost of bread based on user's choice and adds it to the total pizza bill
    public int calculateBillBasedOnChoiceOfBread(int breadChoice, int totalPizzaBill) {
        // write logic to calculate the cost of bread based on choice and add it to the total pizza bill amount
        // return the cost calculated

        return -1;
    }

    // Function displays choices of drinks and calls method to calculates total bill
    public int displayDrinksChoicesAndCalculateBill(int drinksChoice) {
        //display the choice of

        int result5=drinksChoice;
        int priceOfDrinks=0;

        if(result5==0)
        {
            priceOfDrinks=0;
        }
        else if(result5==1)
        {
            priceOfDrinks=60;
        }
        else if(result5==2)
        {
            priceOfDrinks=60;
        }

        //Call the method calculateBillBasedOnDrinksChoice(drinksChoice, totalPizzaBill) to calculate total cost
        // return the cost calculated;

        return priceOfDrinks;
    }

    // Function estimates cost of drink based on user's choice and adds it to the total pizza bill
    /*public int calculateBillBasedOnDrinksChoice(int drinksChoice, int totalPizzaBill) {
        // write logic to calculate the cost of drinks based on choice and add it to the total pizza bill amount
        // return the cost calculated

        return -1;
    }*/

    // Function calculates discount amount based on total pizza bill
    // Do not change the method
    public int estimateDiscountAmount(int totalPizzaBill) {
        int discount = 0;
        int discountamount = 0;

        if (totalPizzaBill >= 500 && totalPizzaBill < 1000) {
            discount = 5;
            discountamount = (totalPizzaBill * discount) / 100;

        } else if (totalPizzaBill >= 1000 && totalPizzaBill < 1500) {
            discount = 10;
            discountamount = (totalPizzaBill * discount) / 100;
        }
        return discountamount;
    } 

    // Function calculates final bill by adding delivery fee and tip charge to total bill
    // Do not change the method
    public int calculateFinalBillBasedOnDeliveryChargeAndTipCharge(int deliveryCharge, int tipCharge, int finalBill) {
        return finalBill + deliveryCharge + tipCharge;
    }

    // Function displays final bill with all necessary details to customer
    // Do not change the method
    public void displayFinalBill(String name, long phoneNo, int totalPizzaBill, int discountAmount, int deliveryCharge, int tipCharge, int finalBill) {
        System.out.println("--------------------------------------------------------");
        System.out.println(" !!! BILL REPORT !!!");
        System.out.println(" Customer Name     : " + name + " \n");
        System.out.println(" Contact No.       : " + phoneNo + " \n");
        System.out.println(" Total Amount      : " + totalPizzaBill + " \n");
        System.out.println(" Discount Applied  : " + "- " + discountAmount + " \n");
        System.out.println(" Delivery Fee      : " + "+ " + deliveryCharge + " \n");
        System.out.println(" Tip               : " + "+ " + tipCharge + " \n");
        System.out.println(" Total Amount      : " + finalBill + " \n");
        System.out.println("--------------------------------------------------------");
    }
}
