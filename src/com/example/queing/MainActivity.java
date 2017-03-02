package com.example.queing;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	ArrayList pikList =null;
	int bflag = 3;
	EditText m =null;
	 EditText R1=null;
	 EditText N=null;
	 EditText l=null;
	 EditText u=null;
	 int model = 0;
	 float m1=0;
	 float R2=0;
	 float N1=0;
	 float l1=0;
	 float u1=0;
	 public static   int flag = 0; 
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       System.out.println("inside onCreate");
       Button button =(Button) findViewById(R.id.button);
       if (flag == 1)
  	 {
  		 flag=0;
  		finish(); 
  	 }

   	button.setOnClickListener(new OnClickListener() {
   		@Override
   		
   		 public void onClick(View view) {
   		 System.out.println("inside onclick");
   		EditText  m = (EditText) findViewById(R.id.server);
   		EditText  R1 = (EditText) findViewById(R.id.capacity);
   	   	EditText  N = (EditText) findViewById(R.id.population);
   	   	EditText  l = (EditText) findViewById(R.id.arrival);
   	   	EditText  u = (EditText) findViewById(R.id.departure);
   	   
   	   		
   	   	
   	
  if(m.getText().toString().trim().length() ==0 
		  ||R1.getText().toString().trim().length() ==0 
		  ||N.getText().toString().trim().length() ==0 
		  ||l.getText().toString().trim().length() ==0
		  ||u.getText().toString().trim().length() ==0)
  {
	  if(m.getText().toString().trim().length() ==0 )
	  {
	
	  m.setHint("*enter no. of server");
	  
	  }
	  if(R1.getText().toString().trim().length() ==0)
	  {
		  
		  R1.setHint("*enter capacity");
		 
	  }
	  
	  if(N.getText().toString().trim().length() ==0)
	  {
		  N.setHint("*enter population");
	  }
	  
	  if(l.getText().toString().trim().length() ==0)
	  {
		 l.setHint("*enter arrival rate");   
	  
	  }
	  
	  if(u.getText().toString().trim().length() ==0)
	  {
		  u.setHint("*enter Service Rate");   
	  
	  }  
  }
  else
  {
   	   	 m1 = Float.parseFloat(m.getText().toString());
   	   	 R2 = Float.parseFloat(R1.getText().toString());
   	   	 N1 = Float.parseFloat(N.getText().toString());
   	     l1 = Float.parseFloat(l.getText().toString());
   	   	 u1 = Float.parseFloat(u.getText().toString());
   	   	 float valid = l1/(u1*m1);
   	   	 System.out.println("valid***"+valid);
   	   	System.out.println("after float");
   		if(valid<1)
   	   	{
   	 	int M1= Integer.parseInt(m.getText().toString());
   	 	int N11 = Integer.parseInt(N.getText().toString());
   	 System.out.println("after parse int");
   		if(m1==1&&R2==0&&N1==0)
   	   	{   
   			model=1;
   			System.out.println("*model1*");
   			
   	   	}
   	   	else if(m1!=1&&R2==0&&N1==0)
   	   	{
   	   	model=2;
   	   		System.out.println("*model2*");
   	   		
   	   	}
   	   	else if(m1==1&&R2!=0&&N1==0)
   	   	{
   	   	 System.out.println("*model3*");
   	   		model=3;
   	   	}
   	   	else if(m1!=1&&R2!=0&&N1==0)
   	   	{
   	   	 System.out.println("*model4*");
   	   		model=4;
   	   	}
   	   	else if(m1!=0&&R2!=0&&N1!=0)
   	   	{
   	   	 System.out.println("*model5*");
   	   		model=5;
   	   	}
   	   	else
   	   	{
   	   	   System.out.println("Invalid Model");
   	   	  Toast.makeText(getApplicationContext(),"Invalid Model", Toast.LENGTH_LONG).show();
   	   	}
   	   	System.out.println("switch defi");
   	   	switch(model)
   	    {
   	    case 1:
   	         {
   	        	Toast.makeText(getApplicationContext(),"Model  M/M/1:GD/infinity/infinity", Toast.LENGTH_LONG).show();
   	        	 System.out.println("Model  M/M/1:GD/infinity/infinity");
   	        	 bflag= 1; 	                 
   	                 
   	int k;
   	float po,pk,L,Q,w,d,s;
    s=l1/u1;
   	po=1-s;
   	L=s/(1-s);
   	Q=(s*s)/(1-s);
   	w=L/l1;
   	d=Q/l1;
   	System.out.println("Avg no of unit in the system   ="+L);
   	System.out.println("Avg no of unit in the queue  ="+Q);
   	System.out.println("Avg time spent in the system   ="+w);
   	System.out.println("Avg time spent in the queue   ="+d);
   	System.out.println("Server Utilization    ="+s);
   	float diff = L-Q;
   	Bundle bundle = new Bundle();
   	bundle.putFloat("unit in System", L);
   	bundle.putFloat("unit in Queue", Q);
   	bundle.putFloat("time in system",w);
   	bundle.putFloat("time in queue", d);
   	bundle.putFloat("busy server", diff);
   	bundle.putFloat("serverutil", s);
   	bundle.putInt("boolean", bflag);
  
   	Intent intent = new Intent(MainActivity.this,StartActivity.class);
   	intent.putExtras(bundle);
   	startActivity(intent);
   	k=5;
   
   	pk = power (s, k);
   	System.out.println("probablity that there are"+k+"customer in the system is ="+pk);
   


   	                 
   	finish();   
   	                 break;
   	                 
   	         } 
   	         
 	   case 2:
           
       {
    	   Toast.makeText(getApplicationContext(),"Model M/M/m:GD/infinity/infinity", Toast.LENGTH_LONG).show();
	        	       System.out.println("Model  M/M/m:GD/infinity/infinity");
          bflag =2;
float L,w,Q,B,d;


float x;
float a=0,b=0,c;
float j;
float p0;
float a1,a2;

float s;
s=l1/u1;
a2=m1*s;

for(int i=0;i<M1;i++)

{

a1=power(a2,i);
a1=a1/(float)fac(i);
a=a+a1;
}
b=(power(M1*s,M1)/(float)fac(M1));
b=b/(1-s);
p0=1/(a+b);
System.out.println("p0=%f"+p0);
x=((power(M1*s,M1+1)*p0/M1)/fac(M1))/power(1-s,2);
L=M1*s+x;
Q=x;
w=L/l1;
d=Q/l1;
B=s/m1;

Bundle bundle = new Bundle();
float diff = L-Q;
System.out.println("\nB=%f"+diff);
	bundle.putFloat("unit in System", L);
	bundle.putFloat("unit in Queue", Q);
	bundle.putFloat("time in system",w);
	bundle.putFloat("time in queue", d);
	bundle.putFloat("busy server", diff);
	bundle.putFloat("serverutil", B);
	bundle.putInt("boolean", bflag);
	bundle.putInt("mserver", M1);
	bundle.putFloat("pi0", p0);
	
	Intent intent = new Intent(MainActivity.this,StartActivity.class);
	intent.putExtras(bundle);
	startActivity(intent);

	finish();
break;
   }
 	  case 3:
          
      {  
    	  Bundle bundle =new Bundle();
    	  pikList = new ArrayList();
    	  Toast.makeText(getApplicationContext(),"Model M/M/1:GD/R/infinity", Toast.LENGTH_LONG).show();
	       
    	  
            System.out.println("Model \t M/M/1:GD/R/infinity");
            float d=0,e=0,pi0,t,a;
            float pik =0;
a=(l1/u1);

for(int k=0;k<=(M1-1);k++)
{
                    
 
d=d+(power(a,k))/fac(k);


}

for(int k=M1;k<=R2;k++)
{
                
        
e=e+((power(M1,M1))*(power((a/M1),k)))/fac(M1);

}

pi0=1/(d+e);
System.out.println("\nthe probability of zero unit in the system %f"+pi0);
//calculating Pi(k)
//calculating L

float L=0;
int g;

for(g=0;g<=R2;g++)
{
   if(g<M1)
{
     
      pik=(power(a,g)*pi0)/fac(g);
     
      
}
if(g>=M1)
{
       
      pik=(power(M1,M1)*power((a/M1),g)*pi0)/fac(M1);
      
      
} 
pikList.add(pik);
System.out.println("pi    "+g+"=  "+pik);
 L=L+g*pik;
   
    
    
}

System.out.println("L=  "+L);

float Q=0;
for(int k=M1;k<=R2;k++)
{
                pik=(power(M1,M1)*power((a/M1),k)*pi0)/fac(M1);
                Q=Q+(k-M1)*pik;
                
} 
bflag=3;
System.out.println("\nQ=%f"+Q);
float diff = L-Q;
System.out.println("\nB=%f"+diff);
float div=L/l1;
System.out.println("\nW=%f"+div);
float Ql1 = Q/l1;
System.out.println("\nD=%f"+Ql1);
float am1 = a/m1;
System.out.println("\nU=%f"+am1);
bundle = new Bundle();
bundle.putFloat("unit in System", L);
bundle.putFloat("unit in Queue", Q);
bundle.putFloat("time in system",div);
bundle.putFloat("time in queue", Ql1);
bundle.putFloat("busy server", diff);
bundle.putFloat("serverutil", am1);
bundle.putStringArrayList("pik",pikList);
bundle.putInt("boolean", bflag);

Intent intent = new Intent(MainActivity.this,StartActivity.class);
intent.putExtras(bundle);
startActivity(intent);




finish();  
break;
   

            
      }       
 	 case 4:
     {
    	bflag=3;
    	 Toast.makeText(getApplicationContext(),"Model M/M/m:GD/R/infinity", Toast.LENGTH_LONG).show();
         System.out.println("Model \t M/M/m:GD/R/infinity");
         pikList = new ArrayList();
         float d=0,e=0,pi0,t,a;
    	 float pik=0;
a=(l1/u1);
for(int k=0;k<=(M1-1);k++)
{
	d=d+(power(a,k))/fac(k);
}

for(int k=M1;k<=R2;k++)
{
                
e=e+((power(M1,M1))*(power((a/M1),k)))/fac(M1);

}

pi0=1/(d+e);
System.out.println("\nthe probability of zero unit in the system %f"+pi0);
//calculating Pi(k)
int q;
//calculating L

float L=0;
int g;

for(g=0;g<=R2;g++)
{
 if(g<M1)
{
   
    pik=(power(a,g)*pi0)/fac(g);
   
    
}
if(g>=M1)
{
     
    pik=(power(M1,M1)*power((a/M1),g)*pi0)/fac(M1);
    
    
} 
System.out.println("pi"+g+"=   "+ +pik);
pikList.add(pik);
L=L+g*pik;
}

System.out.println("\nL=%f"+L);
//calculating Q
float Q=0;
for(int k=M1;k<=R2;k++)
{
              pik=(power(M1,M1)*power((a/M1),k)*pi0)/fac(M1);
              Q=Q+(k-M1)*pik;
              
} 
System.out.println("\nQ=%f"+Q);
float diff = L-Q;
System.out.println("\nB=%f"+diff);
float div=L/l1;
System.out.println("\nW=%f"+div);
float Ql1 = Q/l1;
System.out.println("\nD=%f"+Ql1);
float am1 = a/m1;
System.out.println("\nU=%f"+am1);
Bundle bundle = new Bundle();
bundle.putFloat("unit in System", L);
bundle.putFloat("unit in Queue", Q);
bundle.putFloat("time in system",div);
bundle.putFloat("time in queue", Ql1);
bundle.putFloat("busy server", diff);
bundle.putFloat("serverutil", am1);
bundle.putStringArrayList("pik",pikList);
bundle.putInt("boolean", bflag);
Intent intent = new Intent(MainActivity.this,StartActivity.class);
intent.putExtras(bundle);
startActivity(intent);
finish();
break; 
      } 	         
 	case 5:
        
    {
        bflag=3;
    	Toast.makeText(getApplicationContext(),"Model M/M/m:GD/R/N", Toast.LENGTH_LONG).show(); 
    	
    	 pikList = new ArrayList();
         float d=0,e=0,lamdak,pi0,t,a;
         float pik =0;
int s=0;
if(s<R2)
{
    lamdak=(N1-s)*l1;
   
}

a=(l1/u1);

for(int k=0;k<=(m1-1);k++)
{
                  

d=d+((power(a,k))*(fac(N11)))/((fac(k))*(fac(N11-k)));
}

for(int k=M1;k<=R2;k++)
{
                   
e=e+((power(a,k))*(fac(N11)))/((fac(M1))*(fac(N11-k))*(power(M1,k-M1)));

}

pi0=1/(d+e);
System.out.println("\nthe probability of zero unit in the system %f"+pi0);


//calculating L

float L=0;
int g;

for(g=0;g<=R2;g++)
{
 if(g<M1)
{
   
    pik=(power(a,g)*pi0)*fac(N11)/(fac(g)*fac(N11-g));
  
}
if(g>=M1)
{
     
    pik=((power(a,g))*(fac(N11)))/((fac(M1))*(fac(N11-g))*(power(M1,g-M1)))*pi0;
  
} 
System.out.println("\npi(%d) %f"+g+"="+pik);
pikList.add(pik);
L=L+g*pik;
}
System.out.println("\nL=%f"+L);
float Q=0;
for(int k=M1+1;k<=R2;k++)
{
              pik=((power(a,k))*(fac(N11)))/((fac(M1))*(fac(N11-k))*(power(M1,k-M1)))*pi0;
              Q=Q+(k-M1)*pik;
              
} 
System.out.println("\nQ=%f"+Q);
float diff = L-Q;
System.out.println("\nB=%f"+diff);
float div=L/l1;
System.out.println("\nW=%f"+div);
float Ql1 = Q/l1;
System.out.println("\nD=%f"+Ql1);
float am1 = (L-Q)/m1;
System.out.println("\nU=%f"+am1);
Bundle bundle = new Bundle();
bundle.putFloat("unit in System", L);
bundle.putFloat("unit in Queue", Q);
bundle.putFloat("time in system",div);
bundle.putFloat("time in queue", Ql1);
bundle.putFloat("busy server", diff);
bundle.putFloat("serverutil", am1);
bundle.putStringArrayList("pik",pikList);
bundle.putInt("boolean", bflag);
Intent intent = new Intent(MainActivity.this,StartActivity.class);
intent.putExtras(bundle);
startActivity(intent);
finish();  
         break;
         
    }  
   
   	    }
   	
  }
   	 else
     {
   		Toast.makeText(getApplicationContext(),"Value of [arrival rate/(service rate*no of server)] should be less than 1) ", Toast.LENGTH_LONG).show();
     }
  }	
   		}
		public int fac(int n) {
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

		public float power(float x, int y) {
			
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
		}
   		});
   	}
  
   
    
}