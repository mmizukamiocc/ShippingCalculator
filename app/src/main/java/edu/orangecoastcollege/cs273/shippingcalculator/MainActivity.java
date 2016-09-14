package edu.orangecoastcollege.cs273.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    ShipItem currentShipping = new ShipItem();

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    private EditText weightEditText;
    private TextView baseAmountTextView;
    private TextView addedAmountTextView;
    private TextView totalAmountTextView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = (EditText) findViewById(R.id.weightEditText);
        baseAmountTextView = (TextView) findViewById(R.id.baseAmountTextView);
        addedAmountTextView = (TextView) findViewById(R.id.addedAmountTextView);
        totalAmountTextView = (TextView) findViewById(R.id.totalAmountTextView);

        weightEditText.addTextChangedListener(weightTextChangeListener);
    }

    private TextWatcher weightTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //Do nothing
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try{
                double amount = Double.parseDouble(charSequence.toString());
                currentShipping.setWeight(amount);

            }
            catch (NumberFormatException e)
            {
                weightEditText.setText("");
            }
            updateViews();

        }

        @Override
        public void afterTextChanged(Editable editable) {
            //Do nothing
        }
    };

    private void updateViews()
    {
        baseAmountTextView.setText(currency.format(currentShipping.getBASE_COST()));
        addedAmountTextView.setText(currency.format(currentShipping.getAddedCost()));
        totalAmountTextView.setText(currency.format(currentShipping.getTotalCost()));
    }

}
