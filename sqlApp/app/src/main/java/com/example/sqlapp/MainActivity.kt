package com.example.sqlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        //widgets


        private EditText id_name, id_email, id_password;

        private Button add_button,show_button , up_button, del_button,showa_button , dela_button;

        id_name = findViewById(R.id.name);
        id_name  = findViewById(R.id.email);
        id_password = findViewById(R.id.password);

        add_button = findViewById(R.id.add_data);
        show_button = findViewById(R.id.show_data);
        up_button = findViewById(R.id.Up_data);
        del_button = findViewById(R.id.del_data);
        showa_button = findViewById(R.id.show_all_data);
        dela_button = findViewById(R.id.del_all_data);


    }

}