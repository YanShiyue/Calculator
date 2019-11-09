package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class radixActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radix_layout);

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
        Button bt_A=(Button)findViewById(R.id.bt_A);
        bt_A.setOnClickListener(this);
        Button bt_B=(Button)findViewById(R.id.bt_B);
        bt_B.setOnClickListener(this);
        Button bt_C=(Button)findViewById(R.id.bt_C);
        bt_C.setOnClickListener(this);
        Button bt_D=(Button)findViewById(R.id.bt_D);
        bt_D.setOnClickListener(this);
        Button bt_E=(Button)findViewById(R.id.bt_E);
        bt_E.setOnClickListener(this);
        Button bt_F=(Button)findViewById(R.id.bt_F);
        bt_F.setOnClickListener(this);
        Button bt_AC=(Button)findViewById(R.id.bt_AC);
        bt_AC.setOnClickListener(this);
        Button bt_CE=(Button)findViewById(R.id.bt_CE);
        bt_CE.setOnClickListener(this);

        //Spinner
        Spinner f_id= findViewById(R.id.f_radix);
        f_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView f_op2=(TextView)findViewById(R.id.f_op2);
                String[] f_vol=getResources().getStringArray(R.array.radix);
                //获取单位，用于换算
                int len=f_vol[position].length();
                f_op2.setText(f_vol[position].substring(len-1));
                radix();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner t_id= findViewById(R.id.t_radix);
        t_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView t_op2=(TextView)findViewById(R.id.t_op2);
                String[] t_vol=getResources().getStringArray(R.array.radix);
                int len=t_vol[position].length();
                t_op2.setText(t_vol[position].substring(len-1));
                radix();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }

    //接口
    @Override
    public void onClick(View v) {
        EditText f_op1=(EditText) findViewById(R.id.f_op1);
        switch (v.getId()) {
            case R.id.bt_0: f_op1.append("0");radix();break;
            case R.id.bt_1: f_op1.append("1");radix();break;
            case R.id.bt_2: f_op1.append("2");radix();break;
            case R.id.bt_3: f_op1.append("3");radix();break;
            case R.id.bt_4: f_op1.append("4");radix();break;
            case R.id.bt_5: f_op1.append("5");radix();break;
            case R.id.bt_6: f_op1.append("6");radix();break;
            case R.id.bt_7: f_op1.append("7");radix();break;
            case R.id.bt_8: f_op1.append("8");radix();break;
            case R.id.bt_9: f_op1.append("9");radix();break;
            case R.id.bt_A: f_op1.append("A");radix();break;
            case R.id.bt_B: f_op1.append("B");radix();break;
            case R.id.bt_C: f_op1.append("C");radix();break;
            case R.id.bt_D: f_op1.append("D");radix();break;
            case R.id.bt_E: f_op1.append("E");radix();break;
            case R.id.bt_F: f_op1.append("F");radix();break;
            case R.id.bt_point:if(f_op1.length()==0)f_op1.append("0");f_op1.append(".");break;
            case R.id.bt_AC:f_op1.setText("");radix();break;
            case R.id.bt_CE:
                if(f_op1.length()!=0){
                    f_op1.setText(f_op1.getText().toString().substring(0,f_op1.getText().toString().length()-1));
                }
                radix();
                break;
        }
    }

    //实时换算体积
    public void radix(){
        EditText f_op1=(EditText) findViewById(R.id.f_op1);
        EditText t_op1=(EditText) findViewById(R.id.t_op1);
        TextView f_op2=(TextView)findViewById(R.id.f_op2);
        TextView t_op2=(TextView)findViewById(R.id.t_op2);
        if(f_op1.length()==0){t_op1.setText("0");return;}
        String f=new String(f_op1.getText().toString());
        if(f_op2.getText().toString().equals("B")) {//十进制D作为标准
            int i = 0;
            for (i = 0; i < f.length(); i++) {
                if ((f.charAt(i) != '0') && f.charAt(i) != '1'){
                    t_op1.setText("error");
                    return;
                }
            }
            //Integer.valueOf(f_op1.getText().toString(),2).toString();//十进制的字符串
            t_op1.setText(Integer.valueOf(f_op1.getText().toString(),2).toString());
        }
        if(f_op2.getText().toString().equals("O")){
            int i = 0;
            for (i = 0; i < f.length(); i++) {
                if ((f.charAt(i) > '7') || f.charAt(i) < '0'){
                    t_op1.setText("error");
                    return;
                }
            }
            t_op1.setText(Integer.valueOf(f_op1.getText().toString(),8).toString());
        }
        if(f_op2.getText().toString().equals("D")){
            int i = 0;
            for (i = 0; i < f.length(); i++) {
                if ((f.charAt(i) > '9') || f.charAt(i) < '0'){
                    t_op1.setText("error");
                    return;
                }
            }
            t_op1.setText(f_op1.getText().toString());
        }
        if(f_op2.getText().toString().equals("H")){
            int i = 0;
            for (i = 0; i < f.length(); i++) {
                if (!((f.charAt(i)<='9'&&f.charAt(i)>='0')||f.charAt(i)<='F'&&f.charAt(i)>='A')){
                    t_op1.setText("error");
                    return;
                }
            }
            t_op1.setText(Integer.valueOf(f_op1.getText().toString(),16).toString());
        }

        String t=new String(t_op2.getText().toString());
        int n=Integer.parseInt(t_op1.getText().toString());//
        if(t.equals("B")){//
            t_op1.setText(Integer.toBinaryString(n));
        }
        if(t.equals("O")){
            t_op1.setText(Integer.toOctalString(n));
        }
        if(t.equals("H")){
            t_op1.setText(Integer.toHexString(n));
        }
    }
}
