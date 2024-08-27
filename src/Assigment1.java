
import java.util.*;
/* 
Name: Dequan Kong
Assignment #: Assignment 1 - My dessert store
Date: September 11 2023
Description: This is a program created for my new dessert place
"DAIRYQUAN" (a branch of the famous Dairy Queen). It lets the customers input quantity of desserts 
they want, then outputs the cost of the items after discount & with tax. 
Afterwards, the program lets the customers input the amount of money
they will pay, and outputs the amount of change.
 */
public class Assigment1 {

	public static void main(String[] args) {
		// Creating Scanner
		Scanner in = new Scanner (System.in);

		// Welcome
		System.out.println("WELCOME TO MY DAIRYQUAN DESSERT PLACE\n"); 

		// Letting the customer input the amount of desserts he/she wants
		System.out.print("How many cheesecakes would you like?  ");
		int numCheesecakes = Integer.parseInt(in.nextLine());
		System.out.print("How many waffles would you like?  ");
		int numWaffles = Integer.parseInt(in.nextLine());
		System.out.print("How many apple pies would you like?  ");
		int numApplePies = Integer.parseInt(in.nextLine());
		System.out.print("How many mango milkshakes would you like?  ");
		int numMangoMilkshakes = Integer.parseInt(in.nextLine());
		System.out.print("How many tiramisus would you like?  ");
		int numTiramisus = Integer.parseInt(in.nextLine());


		// Calculating and rounding the cost for each dessert
		// Prices: Cheesecakes $4.67 each, Waffles $6.80 each, Apple Pies $5.29 each, Mango Milkshakes $4.00 each, Tiramisus $5.15 each
		double costCheesecakes = numCheesecakes * 4.67;
		double costWaffles = numWaffles * 6.80;
		double costApplePies = numApplePies * 5.29;
		double costMangoMilkshakes = numMangoMilkshakes * 4.00;
		double costTiramisus = numTiramisus * 5.15;
		costCheesecakes = Math.round(costCheesecakes*100) / 100.0;
		costWaffles = Math.round(costWaffles*100) / 100.0;
		costApplePies = Math.round(costApplePies*100) / 100.0;
		costMangoMilkshakes = Math.round(costMangoMilkshakes*100) / 100.0;
		costTiramisus = Math.round(costTiramisus*100) / 100.0;

		// Outputting the amounts ordered and sub-totals for each dessert
		// Note that for the rest of the program, we will use printf to output any decimal number even though we have rounded already
		// because if the output is a whole number / decimal number with 1 decimal place (for example, 3 or 3.1)
		// we still wish that 2 decimal digits are shown in the output (for example, 3.00 or 3.10)
		System.out.println("\nYOUR BILL\n");

		// Making the program "grammatically correct"
		if (numCheesecakes == 1 || numCheesecakes == 0) {
			System.out.printf("%d cheesecake @ $4.67 each = $%.2f%n", numCheesecakes, costCheesecakes);
		} else {
			System.out.printf("%d cheesecakes @ $4.67 each = $%.2f%n", numCheesecakes, costCheesecakes);
		}
		if (numWaffles == 1 || numWaffles == 0) {
			System.out.printf("%d waffle @ $6.80 each = $%.2f%n", numWaffles, costWaffles);
		} else {
			System.out.printf("%d waffles @ $6.80 each = $%.2f%n", numWaffles, costWaffles);
		}
		if (numApplePies == 1 || numApplePies == 0) {
			System.out.printf("%d apple pie @ $5.29 each = $%.2f%n", numApplePies, costApplePies);
		} else {
			System.out.printf("%d apple pies @ $5.29 each = $%.2f%n", numApplePies, costApplePies);
		}
		if (numMangoMilkshakes == 1 || numMangoMilkshakes == 0) {
			System.out.printf("%d mango milkshake @ $4.00 each = $%.2f%n", numMangoMilkshakes, costMangoMilkshakes);
		} else {
			System.out.printf("%d mango milkshakes @ $4.00 each = $%.2f%n", numMangoMilkshakes, costMangoMilkshakes);
		}
		if (numTiramisus == 1 || numTiramisus == 0) {
			System.out.printf("%d tiramisu @ $5.15 each = $%.2f%n%n", numTiramisus, costTiramisus);
		} else {
			System.out.printf("%d tiramisus @ $5.15 each = $%.2f%n%n", numTiramisus, costTiramisus);
		}

		// Calculating and rounding the total cost, the total cost with discount
		// and the total cost with discount and taxes
		double totalCost = costCheesecakes + costWaffles + costApplePies + costMangoMilkshakes + costTiramisus;
		totalCost = Math.round(totalCost*100)/100.0;
		double totalCostWithDiscount = costWaffles*0.5 + (costCheesecakes + costApplePies + costMangoMilkshakes 
				+ costTiramisus)*(1-0.2); // Discount: 50% off the most expensive item (waffles), 20% off the other items
		totalCostWithDiscount = Math.round(totalCostWithDiscount*100)/100.0;
		double totalCostWithDiscountAndTaxes = totalCostWithDiscount*(1+0.13); // 13% taxes
		totalCostWithDiscountAndTaxes = Math.round(totalCostWithDiscountAndTaxes*100)/100.0;

		// Outputting the costs
		System.out.printf("Total = $%.2f%n", totalCost);
		System.out.printf("Total with discount = $%.2f%n", totalCostWithDiscount);
		System.out.printf("Total with tax = $%.2f%n%n", totalCostWithDiscountAndTaxes);

		// Letting the customer input the amount they will pay
		System.out.print("Please enter the amount paid:  $");
		double amountPaid = Double.parseDouble(in.nextLine());

		// Calculating and outputting the change
		double change = amountPaid - totalCostWithDiscountAndTaxes;
		change = Math.round(change*100) / 100.0;
		System.out.printf("The change will be:  $%.2f\n\n", change);
		System.out.println("To make up this amount, you will need:");

		// Calculating and outputting the number of bills
		// x - remainder of x divided by 50 = largest number that is a multiple of 50 smaller than x
		// then we divide this result by 50 to get the largest number of bills of $50
		// this works for any amount of bills ($20,$10,...)
		// We are also rounding the variable change after each operation

		int fiftyBills = (int) (change - change % 50 )/ 50; 
		// Note that the casting does not change the correctness of the output, 
		// we are just converting a double without decimal places to an integer 
		// (i.e. we are converting 7.0 to 7, 100.0 to 100, etc.)
		// the purpose of this operation is that our output does not have any decimal places

		change -= fiftyBills*50; // substract the amount of money (that the fifty bills cover) from the variable change
		change = Math.round(change*100)/100.0;
		int twentyBills = (int) (change - change % 20) / 20;
		change -= twentyBills*20;
		change = Math.round(change*100)/100.0;
		int tenBills = (int) (change - change % 10) / 10;
		change -= tenBills*10;
		change = Math.round(change*100)/100.0;
		int fiveBills = (int) (change - change % 5) / 5;
		change -= fiveBills*5;
		change = Math.round(change*100)/100.0;
		int toonies = (int) (change - change % 2) / 2;
		change -= toonies*2;
		change = Math.round(change*100)/100.0;
		int loonies = (int) (change - change % 1) / 1;
		change -= loonies*1;
		change = Math.round(change*100)/100.0;

		// Now we are dealing with decimals (by decimals we mean quarters = $0.25, dimes = $0.10, etc.)
		// We will multiply everything by 100 because otherwise java just crashes
		change*=100;
		int quarters = (int) (change - change % 25) / 25;
		change -= quarters*25;
		int dimes = (int) (change - change % 10) / 10;
		change -= dimes * 10;
		int nickels = (int) (change - change % 5) / 5;
		change -= nickels*5;
		int pennies = (int) (change - change % 1) / 1;
		change -= pennies*1;

		// Making the program "grammatically correct" and outputting the number of bills
		// We use printf here so that the output has a nice and uniform format
		// If there is 0 bill for an amount, the amount is skipped and not displayed
		int index = 0;
		if (fiftyBills != 0) {
			if (index % 2 == 0) {
				if (fiftyBills == 1) {
					System.out.printf("%4d  fifty-dollar bill  ", fiftyBills);
					index++;
				} else {
					System.out.printf("%4d  fifty-dollar bills ", fiftyBills);
					index++;
				}
			} else {
				if (fiftyBills == 1) {
					System.out.printf("%5d  fifty-dollar bill%n", fiftyBills);
					index++;
				} else {
					System.out.printf("%5d  fifty-dollar bills%n", fiftyBills);
					index++;
				}
			}
		}
		if (twentyBills != 0) {
			if (index % 2 == 0) {
				if (twentyBills == 1) {
					System.out.printf("%4d  twenty-dollar bill ", twentyBills);
					index++;
				} else {
					System.out.printf("%4d  twenty-dollar bills", twentyBills);
					index++;
				}
			} else {
				if (twentyBills == 1) {
					System.out.printf("%5d  twenty-dollar bill%n", twentyBills);
					index++;
				} else {
					System.out.printf("%5d  twenty-dollar bills%n", twentyBills);
					index++;
				}
			}
		}
		if (tenBills != 0) {
			if (index % 2 == 0) {
				if (tenBills == 1) {
					System.out.printf("%4d  ten-dollar bill    ", tenBills);
					index++;
				} else {
					System.out.printf("%4d  ten-dollar bills   ", tenBills);
					index++;
				}
			} else {
				if (tenBills == 1) {
					System.out.printf("%5d  ten-dollar bill%n", tenBills);
					index++;
				} else {
					System.out.printf("%5d  ten-dollar bills%n", tenBills);
					index++;
				}
			}
		}
		if (fiveBills != 0) {
			if (index % 2 == 0) {
				if (fiveBills == 1) {
					System.out.printf("%4d  five-dollar bill   ", fiveBills);
					index++;
				} else {
					System.out.printf("%4d  five-dollar bills  ", fiveBills);
					index++;
				}
			} else {
				if (fiveBills == 1) {
					System.out.printf("%5d  five-dollar bill%n", fiveBills);
					index++;
				} else {
					System.out.printf("%5d  five-dollar bills%n", fiveBills);
					index++;
				}
			}
		}
		if (toonies != 0) {
			if (index % 2 == 0) {
				if (toonies == 1) {
					System.out.printf("%4d  toonie             ", toonies);
					index++;
				} else {
					System.out.printf("%4d  toonies            ", toonies);
					index++;
				}
			} else {
				if (toonies == 1) {
					System.out.printf("%5d  toonie%n", toonies);
					index++;
				} else {
					System.out.printf("%5d  toonies%n", toonies);
					index++;
				}
			}
		}
		if (loonies != 0) {
			if (index % 2 == 0) {
				if (loonies == 1) {
					System.out.printf("%4d  loonie             ", loonies);
					index++;
				} else {
					System.out.printf("%4d  loonies            ", loonies);
					index++;
				}
			} else {
				if (loonies == 1) {
					System.out.printf("%5d  loonie%n", loonies);
					index++;
				} else {
					System.out.printf("%5d  loonies%n", loonies);
					index++;
				}
			}
		}
		if (quarters != 0) {
			if (index % 2 == 0) {
				if (quarters == 1) {
					System.out.printf("%4d  quarter            ", quarters);
					index++;
				} else {
					System.out.printf("%4d  quarters           ", quarters);
					index++;
				}
			} else {
				if (quarters == 1) {
					System.out.printf("%5d  quarter%n", quarters);
					index++;
				} else {
					System.out.printf("%5d  quarters%n", quarters);
					index++;
				}
			}
		}
		if (dimes != 0) {
			if (index % 2 == 0) {
				if (dimes == 1) {
					System.out.printf("%4d  dime               ", dimes);
					index++;
				} else {
					System.out.printf("%4d  dimes              ", dimes);
					index++;
				}
			} else {
				if (dimes == 1) {
					System.out.printf("%5d  dime%n", dimes);
					index++;
				} else {
					System.out.printf("%5d  dimes%n", dimes);
					index++;
				}
			}
		}
		if (nickels != 0) {
			if (index % 2 == 0) {
				if (nickels == 1) {
					System.out.printf("%4d  nickel             ", nickels);
					index++;
				} else {
					System.out.printf("%4d  nickels            ", nickels);
					index++;
				}
			} else {
				if (nickels == 1) {
					System.out.printf("%5d  nickel%n", nickels);
					index++;
				} else {
					System.out.printf("%5d  nickels%n", nickels);
					index++;
				}
			}
		}
		if (pennies != 0) {
			if (index % 2 == 0) {
				if (pennies == 1) {
					System.out.printf("%4d  penny              ", pennies);
					index++;
				} else {
					System.out.printf("%4d  pennies            ", pennies);
					index++;
				}
			} else {
				if (pennies == 1) {
					System.out.printf("%5d  penny%n", pennies);
					index++;
				} else {
					System.out.printf("%5d  pennies%n", pennies);
					index++;
				}
			}
		}
		in.close();
		}
	}
