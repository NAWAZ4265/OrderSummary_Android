package com.nawazsharif4265.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 *
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
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price  = calculatePrice();
        displayMessage( createOrderSummary(price));
    }

    private String createOrderSummary(int price) {
        String priceMessage = "Name : Kunal";
        priceMessage = priceMessage +"\nQuantity :" + quantity;
        priceMessage = priceMessage +"\nTotal price : $"+ price;
        priceMessage = priceMessage +" wahooo";
        priceMessage = priceMessage +"\nThankyou";
        return priceMessage;
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice( ) {
        return quantity * 5;
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view)  {

            quantity = quantity + 1;
         displayQuantity(quantity);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void decrement(View view)  {
        if(quantity > 0) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        OrderSummaryTextView.setText(message);
    }

}