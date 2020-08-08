package com.hfad.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {



    String stroka="";
    ArrayList<Character> zznaki = new ArrayList<>();
    float m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zznaki.add('+');
        zznaki.add('-');
        zznaki.add('/');
        zznaki.add('*');

        String[][] massiv = {{"mc", "m+", "m-", "mr"},
                {"c", "/", "*", "del"},
                {"7", "8", "9", "-"},
                {"4", "5", "6", "+"},
                {"1", "2", "3", "="},
                {"%", "0", ".", "ex"}};
        ArrayList<Button> buttons = new ArrayList<Button>();

        final EditText numb = (EditText) findViewById(R.id.numb);
        final TextView otvet = (TextView) findViewById(R.id.otvet);
        final TextView mmm = (TextView) findViewById(R.id.mmm);
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tablayot);

        for (int i = 0; i < 6; i++) {

            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

            for (int j = 0; j < 4; j++) {
                Button button = new Button(this);
                button.setText(massiv[i][j]);
                tableRow.addView(button, j);
                buttons.add(button);
            }
            tableLayout.addView(tableRow, i);
        }


        buttons.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stroka = stroka + 7;
                numb.setText(stroka);
            }
        });


        buttons.get(9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stroka = stroka + 8;
                numb.setText(stroka);

            }
        });

        buttons.get(10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stroka = stroka + 9;
                numb.setText(stroka);
            }
        });

        buttons.get(12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stroka = stroka + 4;
                numb.setText(stroka);
            }
        });


        buttons.get(13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stroka = stroka + 5;
                numb.setText(stroka);

            }
        });

        buttons.get(14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stroka = stroka + 6;
                numb.setText(stroka);
            }
        });

        buttons.get(16).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stroka = stroka + 1;
                numb.setText(stroka);
            }
        });


        buttons.get(17).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stroka = stroka + 2;
                numb.setText(stroka);

            }
        });

        buttons.get(18).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stroka = stroka + 3;
                numb.setText(stroka);
            }
        });

        buttons.get(20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stroka.length()>0 && !zznaki.contains(stroka.charAt(stroka.length()-1)) && stroka.charAt(stroka.length()-1)!='%') {stroka = stroka + "%";};
                numb.setText(stroka);
            }
        });


        buttons.get(21).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stroka = stroka + "0";
                numb.setText(stroka);

            }
        });

        buttons.get(22).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stroka.length()>0 &&  stroka.charAt(stroka.length()-1)!='.' && !zznaki.contains(stroka.charAt(stroka.length()-1))) {stroka = stroka + '.';
                numb.setText(stroka);}
            }
        });

        buttons.get(4).setOnClickListener(new View.OnClickListener() { //ochistit
            @Override
            public void onClick(View view) {                     //clear
                stroka = "";
                numb.setText(stroka);
                otvet.setText(stroka);
            }
        });

        buttons.get(7).setOnClickListener(new View.OnClickListener() { //del poslednyy
            @Override
            public void onClick(View view) {
                if (!stroka.equals("")) stroka = stroka.substring(0, stroka.length() - 1);
                numb.setText(stroka);
            }
        });

        buttons.get(15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {           //+

                if (stroka.length()>0 &&  !zznaki.contains(stroka.charAt(stroka.length()-1))) stroka = stroka + '+';
                numb.setText(stroka);
            }
        });

        buttons.get(11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {           //-
                if (stroka.length()==0){ stroka = stroka + '-';
                    numb.setText(stroka);} else{
                if (stroka.length()>0 &&!zznaki.contains(stroka.charAt(stroka.length()-1))){ stroka = stroka + '-';
                numb.setText(stroka);}}
            }
        });

        buttons.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {           //
                if (stroka.length()>0 && !zznaki.contains(stroka.charAt(stroka.length()-1))) {stroka = stroka + '/';
                numb.setText(stroka);}
            }
        });

        buttons.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {           //*
                if (stroka.length()>0 && !zznaki.contains(stroka.charAt(stroka.length()-1))) {stroka = stroka + '*';
                numb.setText(stroka);}
            }
        });


        buttons.get(19).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//=

                if (zznaki.contains(stroka.charAt(stroka.length() - 1))|| (stroka.contains("/0") && !stroka.contains("/0.")) || (stroka.contains("/") && stroka.contains("%"))) {  otvet.setText("ОШИБКА");
                } else {
                    if (stroka.contains("%")) stroka=procent(stroka);
                    if (stroka.charAt(0) == '-') stroka = "0" + stroka;
                    float a = prom_otv(stroka);

                    if (a == (int) a) {
                        otvet.setText(Integer.toString((int) a));
                    } else {
                        otvet.setText(Float.toString(a));
                    }
                    ;
                }
            }
        });

        buttons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {           // MC (Memory Clear) - кнопка означает стереть данные из ячейки памяти.
               m=0;
               mmm.setText("");
            }
        });

        buttons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {           //M+ - прибавить к числу из памяти число, отображенное на дисплее и результат записать в память вместо предыдущего.
                m=m+prom_otv(stroka);
                mmm.setText("M");
            }
        });

        buttons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {           //M- - вычесть из числа в памяти число, отображенное на дисплее калькулятора и результат записать в память.
                m=m-prom_otv(stroka);
                mmm.setText("M");
            }
        });


        buttons.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {           //MR (Memory Read) - кнопка означает считать число из ячейки памяти и вывести его на дисплей.
                if (m == (int) m) {
                    otvet.setText(Integer.toString((int) m));
                } else {
                    otvet.setText(Float.toString(m));
                }

            }
        });


    }

    String procent(String stroka1){           //Если надо узнать сколько будет N% от числа X, то надо набрать X х N%
                                              //если надо прибавить к числу X N%, то X плюс N%
        int aa,bb,cc;
        String a=stroka1.substring(0,stroka1.indexOf('%'));
        if (a.contains("+") ) {aa=a.lastIndexOf('+');} else {aa=0;}
        if (a.contains("*")) {bb=a.lastIndexOf('*');} else {bb=0;}
        if (a.contains("-")) {cc=a.lastIndexOf('-');} else {cc=0;}

        if (Math.max(aa, Math.max(bb,cc))==0) {stroka1=stroka1.replace("%", "/100");} else {
            float proc=1;
            if (aa==Math.max(aa, Math.max(bb,cc))){proc=prom_otv(a.substring(0,aa)); proc=proc/100*Float.parseFloat(a.substring(aa+1))+proc ;};
            if (bb==Math.max(aa, Math.max(bb,cc))){proc=prom_otv(a.substring(0,bb)); proc=proc/100*Float.parseFloat(a.substring(bb+1));};
            if (cc==Math.max(aa, Math.max(bb,cc))){proc=prom_otv(a.substring(0,cc)); proc=proc-(proc/100*Float.parseFloat(a.substring(cc+1))) ;};

            a=a+'%';stroka1=stroka1.replace(a,Float.toString(proc));
        }


        return stroka1;
    }



    float prom_otv(String stroka1){    //poryadok deistvii

       // stroka1="2+3*5/4-2*6";
        ArrayList<Character> znaki = new ArrayList<>();
        ArrayList<Float> chisla = new ArrayList<>();
        int j=0;
        for (int i=0;i<stroka1.length();i++){
            if (zznaki.contains(stroka1.charAt(i))){
                String aa=stroka1.substring(j,i); chisla.add(Float.parseFloat(aa));
                znaki.add(stroka1.charAt(i));
                j=i+1;
            }
        }
        chisla.add(Float.parseFloat(stroka1.substring(j)));

        int k;
        int d;

        while (znaki.size()>0 && (znaki.contains('*') || znaki.contains('/'))) {
            k=znaki.size();
            d=znaki.size();

            if (znaki.contains('*')) k = znaki.indexOf('*');
            if (znaki.contains('/')) d = znaki.indexOf('/');
            if (k<d) {
                chisla.set(k, chisla.get(k) * chisla.get(k + 1));
                chisla.remove(k + 1);
                znaki.remove(k);

            } else {
                chisla.set(d, chisla.get(d) / chisla.get(d + 1));
                chisla.remove(d + 1);
                znaki.remove(d);
            }

        }

        while (znaki.size()>0) {
            k=znaki.size();
            d=znaki.size();

            if (znaki.contains('+')) k = znaki.indexOf('+');
            if (znaki.contains('-')) d = znaki.indexOf('-');
            if (k<d) {
                chisla.set(k, chisla.get(k) + chisla.get(k + 1));
                chisla.remove(k + 1);
                znaki.remove(k);

            } else {
                chisla.set(d, chisla.get(d) - chisla.get(d + 1));
                chisla.remove(d + 1);
                znaki.remove(d);
            }

        }
        return chisla.get(0);
        //otvet.setText(chisla.get(0).toString());
    }




}

