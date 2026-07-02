import java.util.Scanner;

public class WaterTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Constants and variables
        final int GOAL = 2000; // Daily target in ml
        int currentTotal = 0;

        System.out.println("====== 💧 DAILY HYDRATION TRACKER ======");
        System.out.println("Your goal for today is: " + GOAL + "ml");
        System.out.println("(Type -1 at any time to close the tracker and view stats)\n");

        // The loop runs as long as the user hasn't hit the goal
        while (currentTotal < GOAL) {
            System.out.print("Enter amount of water consumed (in ml): ");
            int amount = scanner.nextInt();

            // Check for the early exit signal
            if (amount == -1) {
                System.out.println("\nStopping tracker early...");
                break; // Breaks out of the while loop immediately
            }

            // Validation: Prevent entering negative numbers that aren't the exit code
            if (amount < 0) {
                System.out.println("❌ Invalid amount. Please enter a positive number.");
                continue; // Skips the rest of the loop and starts the next iteration
            }

            // Update the running total
            currentTotal += amount;

            // Show current progress
            System.out.println("📊 Progress: " + currentTotal + "ml / " + GOAL + "ml");
        }

        // --- Final Summary Section ---
        System.out.println("\n=======================================");
        if (currentTotal >= GOAL) {
            System.out.println("🎉 Congratulations! You reached your goal.");
            System.out.println("Total consumed: " + currentTotal + "ml (" + (currentTotal - GOAL) + "ml over goal!)");
        } else {
            int missingAmount = GOAL - currentTotal;
            System.out.println("Keep trying! You finished today at: " + currentTotal + "ml");
            System.out.println("⚠️ You were " + missingAmount + "ml short of your goal.");
        }
        System.out.println("=======================================");

        scanner.close();
    }
}