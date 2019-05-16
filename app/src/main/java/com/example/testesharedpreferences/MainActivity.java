package com.example.testesharedpreferences;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testesharedpreferences.util.SecurityPreferences;


public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.entrada = (EditText) findViewById(R.id.editText_in);
        this.mViewHolder.entrada.setOnEditorActionListener(this);
        this.mViewHolder.saida = (TextView) findViewById(R.id.textview_out);


    }

    @Override
    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
        int id = view.getId();

        if (id == R.id.editText_in) {

            String text = this.mViewHolder.entrada.getText().toString();
           String text2  = this.mSecurityPreferences.getStoredString("teste");
            this.mViewHolder.saida.setText("testado " + text + "anterior" + text2);
            this.mSecurityPreferences.storeString("teste", text);

        }


        return false;
    }


    private static class ViewHolder {
        EditText entrada;
        TextView saida;
    }


}// fim main activity
