package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
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
        if (quantity == 100) {
            // Show an error message as a toast
            Toast.makeText(getApplicationContext(), "You cannot order more than 100 Coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return ;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when - button is clicked
     */
    public void decrement(View view) {
        if (quantity == 1) {
            // Show an error message as a toast
            Toast.makeText(getApplicationContext(), "You cannot order less than 1 Coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return ;
        }
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
        int price = calculatePrice(quantity, 5, hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, nameTextInput);

        String subject = nameTextInput + " - Coffee Order";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
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
     * This method calculates the price of total coffee purchased.
     *
     * @param quantity of coffee
     * @return int price
     */
    private int calculatePrice(int quantity, int pricePerCup, boolean hasWhippedCream, boolean hasChocolate) {
        int basePrice;
        int rate = 5;
        if (hasWhippedCream)
            rate += 1;
        if (hasChocolate)
            rate += 2;
        basePrice = quantity * rate;
        return basePrice;
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
        String priceMessage = getString(R.string.order_summary_name, name);
        priceMessage += "\n" + getString(R.string.order_summary_add_whipped_cream, addWhippedCream);
        priceMessage += "\n" + getString(R.string.order_summary_add_chocolate, addChocolate);
        priceMessage += "\n" + getString(R.string.quantity) + ": " + quantity;
        priceMessage += "\n" + getString(R.string.price) + ": $" + price;
        priceMessage += "\n" + getString(R.string.thank_you);
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