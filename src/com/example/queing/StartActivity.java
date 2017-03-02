package com.example.queing;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class StartActivity extends Activity {
	 ArrayList al =null;
	 EditText enter=null;
	 Float entry=null;
	 int bb=0;
	 Bundle   getBundle=null;
	 Integer mserver=null;
	 Float pi0=null;
	 Float us=null;
	 Float uq=null;
	 Float ts=null;
	 Float tq=null;
	 Float utilization=null;
	 Float avgserver=null;
	 protected void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.startactivity);
	       System.out.println("inside onCreate");
	    
	       Button button2 =(Button) findViewById(R.id.button2);
	       getBundle = this.getIntent().getExtras();
           utilization = getBundle.getFloat("serverutil");
           avgserver =getBundle.getFloat("busy server");
           bb = getBundle.getInt("boolean");
           System.out.println("check"+bb);
           enter = (EditText)findViewById(R.id.probedittext);
           Button button1 = (Button)findViewById(R.id.button1);
           button1.setOnClickListener(new OnClickListener() {
        	  
		      		@Override
		      		
		      		 public void onClick(View view) {
		      		 System.out.println("inside to start main");
		      	 
		      		if(bb==1)
		      		{
		      			
		      			 Float probcustomer=null;
		      			 probcustomer = 1-utilization;
		      			((TextView)findViewById(R.id.prob)).setText("");
		      			 if(enter.getText().toString().trim().length() ==0)
		      			 {
		      				enter.setHint("*enter no. here"); 
		      				((TextView)findViewById(R.id.prob)).setText("");
		      				
		      			 }
		      			 else
		      			 {
		      				//((TextView)findViewById(R.id.prob)).setText("");
		      				entry = Float.parseFloat(enter.getText().toString());
		      				if(entry==0)
			      			{
		      					
			      				 ((TextView)findViewById(R.id.prob)).setText(probcustomer.toString());
			      				 
			      				
			      			}
			      			else
			      			{
			      				
			      				Float probab = (power(utilization,Integer.parseInt(enter.getText().toString())) *probcustomer);
			      				((TextView)findViewById(R.id.prob)).setText(probab.toString());	
			      				}
		      			 }
		      			
		      			
		      			
		      			
		      		}
		      		else if(bb==2)
		      		{
		      			((TextView)findViewById(R.id.prob)).setText("");
		      			Float probcustomer=null;
		      			 probcustomer = 1-utilization;
		      			 
		      			mserver = getBundle.getInt("mserver");
		      			pi0 = getBundle.getFloat("pi0");
		      			System.out.println("pi0**"+pi0);
		      			float probab =0;
		      			 if(enter.getText().toString().trim().length() ==0)
		      			 {
		      				enter.setHint("*enter no. here");
		      				((TextView)findViewById(R.id.prob)).setText("");
		      			 }else
		      			 {
		      				entry = Float.parseFloat(enter.getText().toString());
		      				if(entry==0)
			      			{
			      				
			      				System.out.println("entry"+entry);
			      				probab=pi0;
			      				System.out.println("probab*0*"+probab);
			      				
			      				((TextView)findViewById(R.id.prob)).setText(""+probab);
			      				
			      			}
			      			
			      			else
			      			{
			      				
			      				System.out.println("else condition");
			      				System.out.println("else"+Integer.parseInt(enter.getText().toString()));
			      				System.out.println("else server"+mserver);
			      				int iii = Integer.parseInt(""+mserver);
			      				System.out.println("else"+iii);
			      				if(Integer.parseInt(enter.getText().toString())<Integer.parseInt(mserver.toString()))
				      			{
				      				System.out.println("entry"+entry);
				      				probab = (power(avgserver,Integer.parseInt(enter.getText().toString())))*pi0/fac(Integer.parseInt(enter.getText().toString()));
				      				((TextView)findViewById(R.id.prob)).setText(""+probab);
				      			}
				      			else if(mserver<=Integer.parseInt(enter.getText().toString()))
				      			{
				      				System.out.println("entry"+entry);
				      				int diffrence = Integer.parseInt(enter.getText().toString())-mserver;
				      				float dem = fac(mserver)*power(mserver,diffrence);
				      				probab = (power(avgserver,Integer.parseInt(enter.getText().toString()))*pi0)/dem;

					      			((TextView)findViewById(R.id.prob)).setText(""+probab);
				      			}
			      			}
		      			 }
		      			
		      		}
		      		if(bb==3)
		      		{
		      			 if(enter.getText().toString().trim().length() ==0)
		      			 {
		      				enter.setHint("*enter no. here");
		      				((TextView)findViewById(R.id.prob)).setText("");
		      			 }
		      			 else
		      			 {
		      				System.out.println("enter value"+enter);
			      			al = new ArrayList();
			      			
			      			 al = getBundle.getStringArrayList("pik");
			                System.out.println("size"+al.size());
			              
			                if(Integer.parseInt(enter.getText().toString())<al.size())
			                		{
			                	((TextView)findViewById(R.id.prob)).setText(al.get(Integer.parseInt(enter.getText().toString())).toString());	
					              
			                		}
			                else
			                {
			                	System.out.println("inside else");
			                	((TextView)findViewById(R.id.prob)).setText("0");	
					             }
		      				 
		      			 }
		      			
	            	
		      		}
		      		
		      		}
		      		private int fac(int n) {
		      			 if(n>1)
		      		        {
		      		        n=n*fac(n-1);
		      		       
		      		        }
		      		        if(n<=1)
		      		        {
		      		        	
		      		        return 1;
		      		        }
		      		        return n;
		      		        
		      		}
		      		private float power(float x, int y) {
		      			
		      			float temp;
		      		    if( y == 0)
		      		       return 1;
		      		    temp = power(x, y/2);       
		      		    if (y%2 == 0)
		      		        return temp*temp;
		      		    else
		      		    {
		      		        if(y > 0)
		      		            return x*temp*temp;
		      		        else
		      		            return (temp*temp)/x;
		      		    }
		      		}});   
           button2.setOnClickListener(new OnClickListener() {
	      		@Override
	      		
	      		 public void onClick(View view) {
	      		 System.out.println("inside button2");
	      		 Bundle bundledisplay = new Bundle();
	           us = getBundle.getFloat("unit in System");
	           uq = getBundle.getFloat("unit in Queue");
	           ts = getBundle.getFloat("time in system");
	           tq = getBundle.getFloat("time in queue");
	             utilization = getBundle.getFloat("serverutil");
	             avgserver =getBundle.getFloat("busy server");
	      		bundledisplay.putFloat("unit in System",us);
	      		bundledisplay.putFloat("unit in Queue",uq);
	      		bundledisplay.putFloat("time in system",ts);
	      		bundledisplay.putFloat("time in queue",tq);
	      		bundledisplay.putFloat("busy server",avgserver);
	      		bundledisplay.putFloat("serverutil",utilization);
	      		 Intent display = new Intent(StartActivity.this,DisplayActivity.class);
	      		display.putExtras(bundledisplay);
	      		 		 startActivity(display);
	      		finish();
	      		 
	      		}
	      	});
       	  
	 
	 
	 }
	
}
