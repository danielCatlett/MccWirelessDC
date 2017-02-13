package com.daniel_catlett.mccwirelessdc;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    double budgetRate = 9.99;
    double standardRate = 19.99;
    double ultraRate = 29.99;
    double input;
    double output;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtField = (EditText)findViewById(R.id.txtField);
        final RadioButton radBudget = (RadioButton)findViewById(R.id.radBudget);
        final RadioButton radStandard = (RadioButton)findViewById(R.id.radStandard);
        final RadioButton radUltra = (RadioButton)findViewById(R.id.radUltra);
        final TextView txtCall = (TextView)findViewById(R.id.txtCall);
        final TextView txtData = (TextView)findViewById(R.id.txtData);
        final TextView txtResults = (TextView)findViewById(R.id.txtResults);
        Button button = (Button)findViewById(R.id.button);

        /*
        if(radBudget.isChecked())
            txtCall.setText(getString(R.string.txtCallText));
        else if(radStandard.isChecked())
        {
            txtCall.setText(getString(R.string.txtCallText));
            txtData.setText(getString(R.string.txt5GB));
        }
        else if(radUltra.isChecked())
        {
            txtCall.setText(getString(R.string.txtCallText));
            txtData.setText(getString(R.string.txtUnlimited));
        }
        */

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                DecimalFormat money = new DecimalFormat("###,###.##");

                input = Double.parseDouble(txtField.getText().toString());
                if(radBudget.isChecked())
                    output = input - budgetRate;
                else if(radStandard.isChecked())
                    output = input - standardRate;
                else if(radUltra.isChecked())
                    output = input - ultraRate;

                if(output > 0)
                    txtResults.setText("You will save $" + money.format(output) + " on that plan.");
                else
                    txtResults.setText(getString(R.string.txtDefeat));
            }
        });
    }
}
