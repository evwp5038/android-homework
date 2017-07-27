package com.example.evwp5038.jaykitohomwwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Activitywork extends AppCompatActivity {

    //宣告全域變數
    ArrayList jaykito= new ArrayList(); //樂透亂數 陣列儲存
    ArrayList saveNumber = new ArrayList(); //陣列號碼儲存
    ArrayList function = new ArrayList();//中獎幾個儲存
    int openNumber[] = new int[7]; //開獎號碼儲存
    int nowNumber = 0 ; //樂透亂數陣列 第幾個的位子
    String numSave = ""; //顯示所儲存的號碼的全域變數字串
    String openopen = "";


    private View.OnClickListener btn_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            kito();//電腦選號按鈕

        }
    };
    private View.OnClickListener btndown_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Previous();

            //上一筆按鈕
        }
    };
    private View.OnClickListener btnup_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            next();
            //下一筆按鈕
        }
    };
    private View.OnClickListener btnsave_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            storage();
            //儲存號碼
        }
    };
    private View.OnClickListener btnopen_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            lottery();
            //開獎與對獎
        }
    };
    private View.OnClickListener btnopenNumber_click= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openLottery();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitywork);

        //TextView t = (TextView)findViewById(R.id.txtname);
        IniticalComponent();
    }

    private void IniticalComponent() {
  lbltext = (TextView)findViewById(R.id.lbltext) ;
    lblLotto = (TextView)findViewById(R.id.txtname);
        lblsave= (TextView)findViewById(R.id.txtsave);
       btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(btn_click);

        btndown = (Button)findViewById(R.id.btndown);
        btndown.setOnClickListener(btndown_click);
        btnup = (Button)findViewById(R.id.btnup);
        btnup.setOnClickListener(btnup_click);
        btnsave = (Button)findViewById(R.id.btnsave);
        btnsave.setOnClickListener(btnsave_click);
        btnopen = (Button)findViewById(R.id.btnopen);
        btnopen.setOnClickListener(btnopen_click);
        btnopenNumber = (Button)findViewById(R.id.btnopenNumber);
        btnopenNumber.setOnClickListener(btnopenNumber_click);
    }


    private  void kito(){
        int a [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
        21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,
        43,44,45,46,47,48,49}; //先填入陣列

        int i = 0;
        String p = "";
        int k [] = new int [6];

        //ArrayList<String> jaykito= new ArrayList<String>();

        i = (int) (Math.random() * 49+ 1);

        for (int o = 0 ; o<6 ; o ++)
        {

            i = (int) (Math.random() *  49 + 1);
            if(a[i-1] != 0 )
            {
                k[o] = a[i-1];    //把有亂數抓到的位子 值變成0 導致部會重複
                a[i-1] = 0;

            }else {

                o--;
                // 如果為0迴圈次數-1重跑一次
            }
        }

        Arrays.sort(k); //由小排到大
        jaykito.add(k); //將陣列加到集合裡

        for(int u=0;u<k.length;u++ ){

            p += k[u] + "  ";
        }//把陣列裡的值讀出來

        nowNumber = jaykito.size()-1 ; //在這裡使用時,Arraylist
        // 集合最後一個的數值 存在全域變數裡
        lblLotto.setText(p); //顯示陣列裡的值

    }
    private void Previous(){  //上一筆
        String rr = "";
        if (nowNumber>0){
        int [] a = (int[])jaykito.get(nowNumber-1);///重點！從陣列裡面抓陣列出來
        for(int u=0;u<a.length;u++ ){
            rr += a[u] + "  ";
        } //顯是出抓出來的陣列得值
            nowNumber = nowNumber - 1;
            //每按一次全域變數的值會-1 使得我去抓陣列可以抓到前一筆資料

        }else {
            int [] a = (int[])jaykito.get(nowNumber);

            for(int u=0;u<a.length;u++ ){

                rr += a[u] + "  ";
            }
        }
        lblLotto.setText(rr);//顯示
    }
    private void next(){  //下一筆
        String qq = "";
        if (nowNumber<jaykito.size()-1){
            int [] a = (int[])jaykito.get(nowNumber+1);///重點！從陣列裡面抓陣列出來
            for(int u=0;u<a.length;u++ ){

                qq += a[u] + "  ";
            }
            nowNumber = nowNumber + 1;
        }else {
            int [] a = (int[])jaykito.get(nowNumber);

            for(int u=0;u<a.length;u++ ){

                qq += a[u] + "  ";
            }

        }
        lblLotto.setText(qq);//顯示
    }

    private void storage() {  //號碼組 儲存

        String qq = "";

        boolean oo = false; //重要 為了判斷單一是否有重複
        if (jaykito.size()>0) {
            //saveNumber.add(nowNumber);

            for (int e = 0; e < saveNumber.size(); e++) {
                int ss = (int) saveNumber.get(e);
                if (ss == nowNumber) {
                    oo = true;
                } else {

                }
                /// 判斷是否有重複的數值了
            }
            if (oo == false) { //如果沒有重複就新增

                saveNumber.add(nowNumber);

                int[] a = (int[]) jaykito.get(nowNumber);

                for (int u = 0; u < a.length; u++) {

                    qq += (a[u]) + "  ";
                }
                numSave += qq + "\n";//這樣就是換行 //numSave 是字串全域變數
                lblsave.setText(numSave);
            } else {
             //沒動作
            }
        }else {
           //沒動作
        }
            }

            private  void openLottery(){
                //開獎

                int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                        21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                        43, 44, 45, 46, 47, 48, 49};

                int i = 0;
                String p = "";

                openopen = "";

                for (int o = 0; o < 7; o++) {

                    i = (int) (Math.random() * 49 + 1);
                    if (a[i - 1] != 0) {
                        openNumber[o] = a[i - 1];
                        a[i - 1] = 0;
                        openopen += openNumber[o]+"  ";
                    } else {
                        o--;
                    }
                }

                Arrays.sort(openNumber);

               lbltext.setText("開獎號碼："+openopen);
            }
    private void lottery(){

 //對獎

        //for(int u=0;u<k.length;u++ ){
         //   p += k[u] + "  ";
        //}
        int lottty  = 0;
        int o = 0;
        String sum = ""; //單組中獎
        String allSum= "";
        for (int l = 0 ; l<saveNumber.size();l ++){/// 抓陣列位子的值 //第幾組
            int arraylistnumber = (int)saveNumber.get(l); ///抓位子的值
            int h[] = (int[])jaykito.get(arraylistnumber); ///取得以儲存陣列位子的詳細陣列
            for (int j = 0 ; j<h.length;j++) { //取得詳細陣列的每一項值

                o=h[j];
              for (int w = 0 ; w<openNumber.length;w++)
              { //每一項值去跟開獎號碼比獎
                   while (o == openNumber[w]){
                      lottty ++;
                      w++;
                  }
              }
            }

            sum +="第"+(l+1)+"組中:"+lottty+"個";
           // function.add(sum);
        }

      sum = "開獎號碼:"+openopen + sum;
   lbltext.setText(sum);
    }
    //宣告按鈕介面類
    TextView lbltext;
    TextView lblLotto;
    TextView lblsave ;
    Button btndown;
    Button btn;
    Button btnup;
    Button btnsave;
    Button btnopen;
    Button btnopenNumber;
}
