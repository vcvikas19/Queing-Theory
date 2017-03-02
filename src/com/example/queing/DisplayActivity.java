package com.example.queing;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends Activity {
			
		 protected void onCreate(Bundle savedInstanceState) {
		       super.onCreate(savedInstanceState);
		       setContentView(R.layout.display);
		       System.out.println("inside display onCreate");
		       Button tomain =(Button) findViewById(R.id.StartAgain);
		       Button exit =(Button) findViewById(R.id.Exit);
		       Bundle   getBundle = this.getIntent().getExtras();
	           Float us = getBundle.getFloat("unit in System");
	           Float uq = getBundle.getFloat("unit in Queue");
	           Float ts = getBundle.getFloat("time in system");
	           Float tq = getBundle.getFloat("time in queue");
	           Float utilization = getBundle.getFloat("serverutil");
	           Float avgserver =getBundle.getFloat("busy server");
	           System.out.println("value of us*******"+us);
		      	((TextView)findViewById(R.id.unitinsystem)).setText(us.toString());
		       ((TextView)findViewById(R.id.unitinqueue)).setText(uq.toString());
		       ((TextView)findViewById(R.id.timeinsystem)).setText(ts.toString());
		       ((TextView)findViewById(R.id.timeinqueue)).setText(tq.toString());
		       ((TextView)findViewById(R.id.busyserver)).setText(avgserver.toString());
		       ((TextView)findViewById(R.id.serverutilization)).setText(utilization.toString());
		       
		       
		      	tomain.setOnClickListener(new OnClickListener() {
		      		@Override
		      		
		      		 public void onClick(View view) {
		      		 System.out.println("inside to main");
		      		 Intent main = new Intent(DisplayActivity.this,MainActivity.class);
		      		 startActivity(main);
		      		 finish();
		      		}
		      	});
		       	exit.setOnClickListener(new OnClickListener() {
		      		@Override
		      		
		      		 public void onClick(View view) {
		      		System.out.println("inside exit");
		      		com.example.queing.MainActivity.flag = 1;
		      		Intent i=new Intent(DisplayActivity.this,MainActivity.class);
		      		startActivity(i);
		      		
		      		finish();
		      		
		      		
		      		
		           
		      		}
		      	}
		      	
		      			
		      			);
		 
		 
		 
		 
		 
		 }

}
