package pl.triskelion.binomial_coefficient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private EditText nEditText;
    private EditText kEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.scoreTextView);
        nEditText = findViewById(R.id.nEditText);
        kEditText = findViewById(R.id.kEditText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            int nNumber = 1;
            int kNumber = 1;

            @Override
            public void onClick(View v) {
                nNumber = Integer.parseInt(nEditText.getText().toString());
                kNumber = Integer.parseInt(kEditText.getText().toString());

                scoreTextView.setText(String.valueOf(binomialCoefficient(nNumber, kNumber)));
            }
        });
    }

    private static BigInteger binomialCoefficient(int n, int k) {
        return (factorial(n)).divide((factorial(k).multiply(factorial(n - k))));
    }

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for(int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

}
