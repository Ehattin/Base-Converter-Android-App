package com.example.baseconverteractivity;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class BaseConverterActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_base);
        final TextView textView = findViewById(R.id.Result);
        final EditText numText = findViewById(R.id.numText);
        final EditText convertText = findViewById(R.id.convertText);
        final Button button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputNum = numText.getText().toString();
                String baseNum = convertText.getText().toString();
               if(inputNum.isEmpty() || baseNum.isEmpty()){
                   Toast.makeText(BaseConverterActivity.this, "Please enter numbers", Toast.LENGTH_SHORT).show();
                   return;
                 }
                boolean numeric = true;
                try {
                    Double input = Double.parseDouble(inputNum);
                } catch (NumberFormatException e) {
                    numeric = false;
                }
                if(!numeric){
                    Toast.makeText(BaseConverterActivity.this, "Please enter positive whole numbers", Toast.LENGTH_SHORT).show();
                    return;
                }

                int inputN = Integer.parseInt(inputNum);
                int baseN = Integer.parseInt(baseNum);
                if (baseN > 32 || baseN < 2 || inputN<=0) {
                    Toast.makeText(BaseConverterActivity.this, "Illegal Number", Toast.LENGTH_SHORT).show();
                    convertText.setText("");
                }
                else {
                    String converted = BaseConverter.convertFrom10(inputN, baseN);
                    textView.setText(String.valueOf(converted));
                }
            }
        });
    }

}
