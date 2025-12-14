import java.util.Scanner;
public class NextDate {
// Check if a year is leap year
private static boolean isLeap(int year) {
return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}
// Get number of days in a given month of a year
private static int getDaysInMonth(int month, int year) {
switch (month) {
case 4: case 6: case 9: case 11:
return 30;
case 2:
return isLeap(year) ? 29 : 28;
default:
return 31;
}
}
// Validate input date
private static boolean isValidDate(int day, int month, int year) {
if (year < 2000 || year > 2100) {
System.out.println("Year not in range 2000–2100");
return false;
}
if (month < 1 || month > 12) {
System.out.println("Month not in range 1–12");
return false;
}
int maxDays = getDaysInMonth(month, year);
if (day < 1 || day > maxDays) {
System.out.println("Day not in range 1–" + maxDays);
return false;
}
return true;
}
// Compute next date
private static int[] getNextDate(int day, int month, int year) {
int maxDays = getDaysInMonth(month, year);
if (day < maxDays) {
day++;
} else {
day = 1;
if (month == 12) {
month = 1;
year++;
} else {
month++;
}
}
return new int[]{day, month, year};
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int day, month, year;
while (true) {
System.out.println("Enter today's date (dd mm yyyy):");
day = sc.nextInt();
month = sc.nextInt();
year = sc.nextInt();
if (isValidDate(day, month, year)) {
break; // exit loop only when input is valid
}
System.out.println("Invalid date. Try again.\n");
}
// Calculate tomorrow’s date
int[] tomorrow = getNextDate(day, month, year);
// If year crosses 2100 boundary
if (tomorrow[2] > 2100) {
System.out.println("The next day is out of boundary value of year");
} else {
System.out.printf("Next day is: %d %d %d\n", tomorrow[0], tomorrow[1], tomorrow[2]);
}
sc.close();
}
}