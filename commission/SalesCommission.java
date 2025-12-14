package commission;

public import java.util.Scanner;
public class SalesCommission {
public static void main(String[] args) {
final double LOCK_PRICE = 45.0;
final double STOCK_PRICE = 30.0;
final double BARREL_PRICE = 25.0;
int totalLocks = 0, totalStocks = 0, totalBarrels = 0;
Scanner sc = new Scanner(System.in);
System.out.println("Enter the number of locks (enter -1 to exit):");
int locks = sc.nextInt();
while (locks != -1) {
System.out.println("Enter the number of stocks and barrels:");
int stocks = sc.nextInt();
int barrels = sc.nextInt();
// Validation for locks
if (locks < 1 || locks > 70) {
System.out.println("Value of locks not in the range 1–70");
} else if (totalLocks + locks > 70) {
System.out.println("New total locks = " + (totalLocks + locks) + " not in the range 1–70");
} else {
totalLocks += locks;
}
// Validation for stocks
if (stocks < 1 || stocks > 80) {
System.out.println("Value of stocks not in the range 1–80");
} else if (totalStocks + stocks > 80) {
System.out.println("New total stocks = " + (totalStocks + stocks) + " not in the range 1–80");
} else {
totalStocks += stocks;
}
// Validation for barrels
if (barrels < 1 || barrels > 90) {
System.out.println("Value of barrels not in the range 1–90");
} else if (totalBarrels + barrels > 90) {
System.out.println("New total barrels = " + (totalBarrels + barrels) + " not in the range 1–90");
} else {
totalBarrels += barrels;
}
System.out.println("Total locks = " + totalLocks);
System.out.println("Total stocks = " + totalStocks);
System.out.println("Total barrels = " + totalBarrels);
System.out.println("\nEnter the number of locks (enter -1 to exit):");
locks = sc.nextInt();
}
// Final totals
System.out.println("\nFinal Totals:");
System.out.println("Locks = " + totalLocks);
System.out.println("Stocks = " + totalStocks);
System.out.println("Barrels = " + totalBarrels);
// Calculate sales
double lockSales = totalLocks * LOCK_PRICE;
double stockSales = totalStocks * STOCK_PRICE;
double barrelSales = totalBarrels * BARREL_PRICE;
double sales = lockSales + stockSales + barrelSales;
System.out.println("Total sales = " + sales);
// Calculate commission
double commission;
if (sales > 1800) {
commission = (0.10 * 1000) + (0.15 * 800) + (0.20 * (sales - 1800));
} else if (sales > 1000) {
commission = (0.10 * 1000) + (0.15 * (sales - 1000));
} else {
commission = 0.10 * sales;
}
System.out.println("Commission = " + commission);
sc.close();
}
} {
    
}
