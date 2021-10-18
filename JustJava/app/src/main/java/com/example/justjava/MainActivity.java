package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app display order summary for coffee ordered
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when + button is clicked
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when - button is clicked
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method hide the keyboard when order button is clicked
     */
    public void submitOrder(View view) {
        CheckBox whippedCream = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCream.isChecked();
        CheckBox chocolate = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolate.isChecked();
        EditText name = findViewById(R.id.name_text_input);
        String nameTextInput = name.getText().toString();
        closeKeyboard(view);
        int price = calculatePrice(quantity, 5);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, nameTextInput);
        displayMessage(priceMessage);
    }

    /**
     * This method close keyboard when order button is pressed
     */
    private void closeKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * This method displayQuantitys the given quantity value on the screen.
     *
     * @param numberOfCoffees ordered
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displayQuantitys the given text on the screen
     *
     * @param message, as no of quantity
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method calculates the price of total coffee purchased.
     *
     * @param quantity of coffee
     * @return int price
     */
    private int calculatePrice(int quantity, int pricePerCup) {
        int price = quantity * 5;
        return price;
    }

    /**
     * Creates summary of the order
     *
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @param name of the person
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream , boolean addChocolate, String name) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream ;
        priceMessage += "\nAdd chocolate? " + addChocolate ;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    /**
     * Creates a custom greeting message based on the name
     *
     * @param firstName
     * @param lastName
     * @return text greeting
     */
    private String createCustomGreeting(String firstName, String lastName) {
        return ("Welcome " + firstName + " " + lastName + "!");
    }
}