/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.justjava
 * If you get an error when copying this code into Android studio, update it to match the package name found
 * in the project's AndroidManifest.xml file.
 */

package com.example.justjava;

import java.text.NumberFormat;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the plus and minus buttons are clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    public void decrement(View view) {
        if (quantity>0) {
            quantity--;
            displayQuantity(quantity);
        }
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       // Get text from the EditText XML
       EditText nameField = (EditText) findViewById(R.id.name_field);
       String name = nameField.getText().toString();
       Log.v("MainActivity", "Name: " + name);

       // Figure out if user wants whipped cream
       CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
       boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
       Log.v("MainActivity", "Has Whipped Cream: " + hasWhippedCream);

       // Figure out if user wants chocolate
       CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
       boolean hasChocolate = chocolateCheckBox.isChecked();
        Log.v("MainActivity", "Has Chocolate: " + hasChocolate);

       // Calculate Price
       int price = calculatePrice();

       // Display the order summary on the screen
       String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
       displayMessage(priceMessage);
    }
    /**
     * Calculate the price of the order.
     *
     * @return  total price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * Create a summary of the order
     *
     * @param name of the customer
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants Whipped Cream Toppings
     * @param addWhippedCream is whether or not the user wants Whipped Cream Toppings
     * @return
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nThank you for ordering " + quantity + " coffees!";
        priceMessage += "\nHas Whipped Cream? " + addWhippedCream;
        priceMessage += "\nHas Chocolate? " + addChocolate;
        priceMessage += "\nAmount Due: $" + price;
        priceMessage += "\n\nYour order will be right up!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     * @param pricePerCup tell us the price per cup of coffee
     */
    private void calculatePrice(int quantity, int pricePerCup) {
        int price = quantity * pricePerCup;
    }
}

