package com.kannan.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity{
	public String str ="";
	Character op = 'q';
	int i,num,numtemp=0;
	EditText showResult;
	Button calculate , cal ;
	TextView answer;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);

	showResult = (EditText)findViewById(R.id.result_id);
    initforfact();

	}
	public void initforfact(){
		answer = (TextView) findViewById(R.id.tvFact);
		calculate = (Button) findViewById(R.id.BtFact);
		cal = (Button) findViewById(R.id.BtArm);
		
	}
	private long calcFactorial() {

	    long factorial = 1;
	    try {
	        factorial = Long.parseLong(showResult.getText().toString());
	        for(int i= (int) (factorial-1); i>0; i--){
	            factorial = i * factorial;
	        }
	    } catch (NumberFormatException e) {
	        Toast.makeText(this, "Incorrect Input", Toast.LENGTH_LONG).show();
	    } finally {}

	    return factorial;
	}
	
	public void btnFactClicked(View V){
		answer.setText("The Factorial of " + showResult.getText().toString() + " is : " + calcFactorial());
		
	}
	
	public void btnArmClicked(View V){
		answer.setText("The number  " + showResult.getText().toString() + " is : " + calcArm());
		
	}
	
	public void btnPrimeClicked(View V){
		answer.setText("The number  " + showResult.getText().toString() + " is : " + calcPrime());
		
	}
	
	private String calcPrime()
	{
		int num;
		try{
		num = Integer.parseInt(showResult.getText().toString());
		boolean flag=true;
		for(int i=2;i<num;i++)
		{ 
			if(num%i==0) {
				
				flag = false;
				break;
				
			}
					
		}
		if(flag)
		{
			return "Prime Number";
		}
		else
		{
			return "Not a Prime Number";
			
		}
		}
		catch (NumberFormatException e) {
	        Toast.makeText(this, "Incorrect Input", Toast.LENGTH_LONG).show();
	    } finally {}
		
		return null;
		
}
	
	private String calcArm()
	{
		 int number, sum = 0, temp, remainder;
		 try{
		 number = Integer.parseInt(showResult.getText().toString());
		 
		 temp = number;

	        while (temp != 0) {
	            remainder = temp % 10;
	            sum = sum + remainder * remainder * remainder;
	            temp = temp / 10;
	        }
	        
	        if (number == sum) {
	            return "Armstrong";
	        } 
	        else {
	        	return "Not Armstrong";
	        }
		 }
		 catch (NumberFormatException e) {
		        Toast.makeText(this, "Incorrect Input", Toast.LENGTH_LONG).show();
		    } finally {}
			
			return null;
	}
	
	public void btn0Clicked(View v){
		insert(0);

		}
	public void btn1Clicked(View v){
	insert(1);

	}

	public void btn2Clicked(View v){
	insert(2);

	}
	public void btn3Clicked(View v){
	insert(3);

	}
	public void btn4Clicked(View v){
	insert(4);

	}
	public void btn5Clicked(View v){
	insert(5);

	}
	public void btn6Clicked(View v){
	insert(6);
	}
	public void btn7Clicked(View v){
	insert(7);

	}
	public void btn8Clicked(View v){
	insert(8);

	}
	public void btn9Clicked(View v){
	insert(9);

	}
	public void btnplusClicked(View v){
	answer.setText("Adding");
	
	/*showResult.setText(num+"+");
	Editable temp;
	temp = showResult.getText(); */
	perform();
	op = '+';

	}

	/*private void display() {
		// TODO Auto-generated method stub
		showResult.setText(num+"+");
		//Editable temp;
		//temp = showResult.getText(); 
	}*/
	public void btnminusClicked(View v){
	answer.setText("Subtracting");
	perform();
	op = '-';

	}
	public void btndivideClicked(View v){
	answer.setText("Dividing");
	perform();
	op = '/';

	}
	public void btnmultiClicked(View v){
	answer.setText("Multiplying");
	perform();
	op = '*';

	}
	public void btnequalClicked(View v){
	answer.setText("Equals");
	calculate();

	}

	public void btnclearClicked(View v){
	reset();
	}
	private void reset() {
	// TODO Auto-generated method stub
	str ="";
	op ='q';
	num = 0;
	numtemp = 0;
	answer.setText("");
	showResult.setText("");
	}
	private void insert(int j) {
	// TODO Auto-generated method stub
	
	str = str+Integer.toString(j);
	num = Integer.valueOf(str).intValue();
	showResult.setText(str);
	

	}
	
	private void perform() {
	// TODO Auto-generated method stub
	str = "";
	numtemp = num;
	}
	private void calculate() {
	// TODO Auto-generated method stub
	if(op == '+')
	num= numtemp+num;
	else if(op == '-')
	num = numtemp-num;
	else if(op == '/')
	num = numtemp/num;
	else if(op == '*')
	num = numtemp*num;
	showResult.setText(""+num);
	}

	

}

