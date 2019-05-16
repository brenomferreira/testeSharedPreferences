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

        this.mViewHolder.entradaF = (EditText) findViewById(R.id.editText_inFloat);
        this.mViewHolder.entradaF.setOnEditorActionListener(this);
        this.mViewHolder.saidaF = (TextView) findViewById(R.id.textview_outFloat);


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

        if (id == R.id.editText_inFloat) {

            String text = this.mViewHolder.entradaF.getText().toString();
            float valorF = Float.parseFloat(text);
            float text2  = this.mSecurityPreferences.getStoredFloat("testeF");
            this.mViewHolder.saidaF.setText("testado " + text + "anterior" + text2);
            this.mSecurityPreferences.storeFloat("testeF", valorF);

        }


        return false;
    }


    private static class ViewHolder {
        EditText entrada;
        TextView saida;

        EditText entradaF;
        TextView saidaF;
    }


}// fim main activity
