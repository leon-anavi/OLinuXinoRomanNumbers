package com.anavi.olinuxinoromannumbers;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {


	private EditText m_editAmount;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		//remove title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//fullscreen
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
									WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_main);
        
        m_editAmount = (EditText)findViewById(R.id.inputAmount);
        
        Button buttonCalc = (Button)findViewById(R.id.buttonCalc);
        buttonCalc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) 
            {
            	convert();
            }
        });
    }
    //------------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    //------------------------------------------------------------------------------

    /**
     * Convert decimal value to Roman number and show it on the screen
     * 
     * @return nothing
     * @throws nothing
     */
    private void convert()
    {    	
    	String sRomanNum = "";
    	try
    	{
    		int nVal = getAmount();
    		sRomanNum = RomanConverter.toRoman(nVal);
    	}
    	catch (NumberFormatException ex)
    	{
    		//stop the execution of the method
    		return;
    	}
    	catch (Exception e) 
    	{
    		sRomanNum = e.getMessage();
		}
    	finally
    	{
    		TextView labelResult = (TextView)findViewById(R.id.labelResult);
    		labelResult.setText(sRomanNum);
    	
    		hideKeyboard();
    	}
    }
    //------------------------------------------------------------------------------

    /**
     * Hide virtual keyboard
     * 
     * @return nothing
     * @throws nothing
     */
    private void hideKeyboard()
    {
    	InputMethodManager mgr = 
    		(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    	if (null != mgr)
    	{
    		mgr.hideSoftInputFromWindow(m_editAmount.getWindowToken(), 0);
    	}
    }
    //------------------------------------------------------------------------------
   
    /**
     * get decimal value filled by the user
     * 
     * @return int
     */
    private int getAmount()
    {
    	return Integer.parseInt(m_editAmount.getText().toString());
    }
    //------------------------------------------------------------------------------
   
}
