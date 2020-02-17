package com.samsung.itschool.whattobuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etProduct;
    Button button;
    ListView list;
    ArrayList<String> products = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etProduct = findViewById(R.id.product);
        button = findViewById(R.id.additem);
        list = findViewById(R.id.list);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String product = etProduct.getText().toString();
                // проверить, есть ли уже такая строка, дубликаты не добавлять
                products.add(product);
                Log.d("mytag", "list size = " + products.size());
                // создаём адаптер
                ArrayAdapter<String> adapter =
                        new ArrayAdapter<>(getApplicationContext(),
                                R.layout.item , products);
                list.setAdapter(adapter);
            }
        }  ;
        button.setOnClickListener(listener);

    }
}
