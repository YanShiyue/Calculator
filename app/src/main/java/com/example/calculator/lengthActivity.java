package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class lengthActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length_layout);


        //返回conversionActivity(显式Intent)
/*        Button Back=(Button) findViewById(R.id.bt_no);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(lengthActivity.this,conversionActivity.class);
                startActivity(intent);
            }
        });*/
        Button bt_0=(Button)findViewById(R.id.bt_0);
        bt_0.setOnClickListener(this);
        Button bt_1=(Button)findViewById(R.id.bt_1);
        bt_1.setOnClickListener(this);
        Button bt_2=(Button)findViewById(R.id.bt_2);
        bt_2.setOnClickListener(this);
        Button bt_3=(Button)findViewById(R.id.bt_3);
        bt_3.setOnClickListener(this);
        Button bt_4=(Button)findViewById(R.id.bt_4);
        bt_4.setOnClickListener(this);
        Button bt_5=(Button)findViewById(R.id.bt_5);
        bt_5.setOnClickListener(this);
        Button bt_6=(Button)findViewById(R.id.bt_6);
        bt_6.setOnClickListener(this);
        Button bt_7=(Button)findViewById(R.id.bt_7);
        bt_7.setOnClickListener(this);
        Button bt_8=(Button)findViewById(R.id.bt_8);
        bt_8.setOnClickListener(this);
        Button bt_9=(Button)findViewById(R.id.bt_9);
        bt_9.setOnClickListener(this);
        Button bt_point=(Button)findViewById(R.id.bt_point);
        bt_point.setOnClickListener(this);
        Button bt_AC=(Button)findViewById(R.id.bt_AC);
        bt_AC.setOnClickListener(this);
        Button bt_CE=(Button)findViewById(R.id.bt_CE);
        bt_CE.setOnClickListener(this);

        //Spinner
        Spinner f_id= findViewById(R.id.f_length);
        f_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView f_op2=(TextView)findViewById(R.id.f_op2);
                String[] f_len=getResources().getStringArray(R.array.length);
                f_op2.setText(f_len[position].substring(f_len[position].length()-2));
                Len();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner t_id= findViewById(R.id.t_length);
        t_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView t_op2=(TextView)findViewById(R.id.t_op2);
                String[] t_len=getResources().getStringArray(R.array.length);
                t_op2.setText(t_len[position].substring(t_len[position].length()-2));
                Len();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
    public void Len(){//换算求结果
        TextView f_op1=(TextView)findViewById(R.id.f_op1);
        TextView t_op1=(TextView)findViewById(R.id.t_op1);
        TextView f_op2=(TextView)findViewById(R.id.f_op2);
        TextView t_op2=(TextView)findViewById(R.id.t_op2);
        Double op=Double.parseDouble(f_op1.getText().toString());//text→String→Double
        if(f_op2.getText().toString().equals("km"))op*=Math.pow(10,3);
        if(f_op2.getText().toString().equals("dm"))op*=Math.pow(10,-1);
        if(f_op2.getText().toString().equals("cm"))op*=Math.pow(10,-2);
        if(f_op2.getText().toString().equals("mm"))op*=Math.pow(10,-3);
        if(f_op2.getText().toString().equals("um"))op*=Math.pow(10,-6);
        if(f_op2.getText().toString().equals("nm"))op*=Math.pow(10,-9);

        if(t_op2.getText().toString().equals("km"))op*=Math.pow(10,-3);
        if(t_op2.getText().toString().equals("dm"))op*=Math.pow(10,1);
        if(t_op2.getText().toString().equals("cm"))op*=Math.pow(10,2);
        if(t_op2.getText().toString().equals("mm"))op*=Math.pow(10,3);
        if(t_op2.getText().toString().equals("um"))op*=Math.pow(10,6);
        if(t_op2.getText().toString().equals("nm"))op*=Math.pow(10,9);
        t_op1.setText(String.valueOf(op));
    }
    @Override
    public void onClick(View v) {
        TextView f_op1=(TextView)findViewById(R.id.f_op1);
        TextView t_op1=(TextView)findViewById(R.id.t_op1);
        switch (v.getId()) {
            case R.id.bt_0: if(f_op1.getText().toString().equals("0"))f_op1.setText("");f_op1.append("0");Len();break;
            case R.id.bt_1: if(f_op1.getText().toString().equals("0"))f_op1.setText("");f_op1.append("1");Len();break;
            case R.id.bt_2: if(f_op1.getText().toString().equals("0"))f_op1.setText("");f_op1.append("2");Len();break;
            case R.id.bt_3: if(f_op1.getText().toString().equals("0"))f_op1.setText("");f_op1.append("3");Len();break;
            case R.id.bt_4: if(f_op1.getText().toString().equals("0"))f_op1.setText("");f_op1.append("4");Len();break;
            case R.id.bt_5: if(f_op1.getText().toString().equals("0"))f_op1.setText("");f_op1.append("5");Len();break;
            case R.id.bt_6: if(f_op1.getText().toString().equals("0"))f_op1.setText("");f_op1.append("6");Len();break;
            case R.id.bt_7: if(f_op1.getText().toString().equals("0"))f_op1.setText("");f_op1.append("7");Len();break;
            case R.id.bt_8: if(f_op1.getText().toString().equals("0"))f_op1.setText("");f_op1.append("8");Len();break;
            case R.id.bt_9: if(f_op1.getText().toString().equals("0"))f_op1.setText("");f_op1.append("9");Len();break;
            case R.id.bt_point:f_op1.append(".");Len();break;
            case R.id.bt_AC:f_op1.setText("0");t_op1.setText("0");break;
            case R.id.bt_CE:
                if(f_op1.getText().toString().length()!=0){
                    f_op1.setText(f_op1.getText().toString().substring(0,f_op1.getText().toString().length()-1));
                    if(f_op1.getText().toString().length()==0)f_op1.setText("0");
                    Len();
                }
                break;
        }
    }








}
