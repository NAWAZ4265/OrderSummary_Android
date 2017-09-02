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
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String editTextName = editText.getText().toString();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox whippedChocolateCreamCheckBox = (CheckBox) findViewById(R.id.whipped_chocolate_cream_checkbox);
        boolean hasChocolateWhippedCream = whippedChocolateCreamCheckBox.isChecked();
        int price  = calculatePrice(hasWhippedCream, hasChocolateWhippedCream);
        displayMessage( createOrderSummary(price, hasWhippedCream, hasChocolateWhippedCream, editTextName));
    }

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolateCream, String edittextname) {
        String priceMessage = "Name : "+ edittextname;
        priceMessage += "\nAdd whipped cream ? " + addWhippedCream;
        priceMessage += "\nAdd chocolate cream ? " + addChocolateCream;
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
    private int calculatePrice(boolean cream_one, boolean cream_two) {
       int basePrice = 5;
        if(cream_one==true)  {
            basePrice = basePrice + 1;
            if(cream_two==true){
                basePrice = basePrice + 2;
            }
        }
        return quantity * 5;
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view)  {
           if(quantity < 100) {
               quantity = quantity + 1;
               displayQuantity(quantity);
           }
        else {
               Toast.makeText(this, "cannot buy more than 100", Toast.LENGTH_LONG).show();
           }
    }

    /**
     * This method is called when the increment button is clicked.
     *
     */
    public void decrement(View view)  {
        if(quantity > 0) {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
        else {
            Toast.makeText(this, "Less than 1 is not allow", Toast.LENGTH_SHORT).show();

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