package com.example.android.coffee;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**

 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    private Object View;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**

     This method is called when the order button is clicked.
     */
    boolean cream=false;
    boolean chocolate=false;
    int quantity=0;
    public void submitOrder(View view) {
        int price=quantity*10;
        String message = createsummary(price,cream,chocolate);
      displayMessage(message);
     }
    public void increment(View view) {
        if(quantity==100)
        {
            quantity=100;
            Context context= getApplicationContext();
            CharSequence text="You can not order more than 100 quantities";
            int duration=Toast.LENGTH_SHORT;
            Toast.makeText(context,text,duration).show();
        }
        else
        quantity++;
        display(quantity);}

    public void decrement(View view) {
       if(quantity==0)
       {
           quantity=0;
           Context context= getApplicationContext();
           CharSequence text="You can not order less than 100 quantities";
           int duration=Toast.LENGTH_SHORT;
           Toast toast = Toast.makeText(context,text,duration);
           toast.show();
       }
       else
           quantity--;
        display(quantity);}


    /**

     This method displays the given quantity value on the screen.*/

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /** this method displays the given quantity value on the screen*/
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /** this method displays the given text on the screen */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    private String displayname(View view)
    {
        EditText name= (EditText) findViewById(R.id.name);
        String gotit=name.getText().toString();
        return gotit;
    }

    private String createsummary(int price, boolean cream, boolean chocolate )
    {
        String  message=displayname((android.view.View) View);
        if(cream== true)
        message+="\nAdd whipped cream? :" + "Yes";
        else
            message+="\nAdd whipped cream? :" + "No";
        if(chocolate ==true)
        message+="\nAdd chocolate? :" + "Yes";
        else
            message+="\nAdd chocolate? :" + "No";
        message += "\nQuantity:"+ quantity;
        message+="\nTotal Price: \u20B9"+ quantity*10;
        message+="\nThank You!";
        return message;

    }
    /**public void composeEmail(String[] addresses, String subject, Uri attachment)
    {
        Intent intent = new Intent (Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, addresses);
        intent.putExtra(Intent.EXTRA_STREAM, addresses);
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
    }*/
    public void checkbox(View view) {
        boolean checked=((CheckBox)view).isChecked();
        switch(view.getId())
        {
            case R.id.creamcheck:
                if(checked)
                    cream=true;
                break;
            case R.id.chocolatecheck:
                if(checked)
                    chocolate=true;
                break;
        }

    }
}