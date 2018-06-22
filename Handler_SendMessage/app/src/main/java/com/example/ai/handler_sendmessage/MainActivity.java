package com.example.ai.handler_sendmessage;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //textView.setText(msg.arg1+""+"-"+msg.arg2);
            textView.setText("\n"+msg.obj);

        }
    };

    class Person{
        public int age;
        public String name;

        @Override
        public String toString() {
            return "name="+name+":age="+age;
        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Thread.sleep(2000);
                    //Message message=new Message();
                    //message.arg1=88;
                    //message.arg2=100;
                    Message message=handler.obtainMessage();

                    Person person=new Person();
                    person.age=21;
                    person.name="AI";

                    message.obj=person;
                    message.sendToTarget();
                    //handler.sendMessage(message);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
