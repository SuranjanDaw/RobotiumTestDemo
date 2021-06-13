package com.example.android.calculator;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;
import com.robotium.solo.Solo;


public class CalculatorTestCase extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;
    private MainActivity mActivity;
    private TextView mView;
    String resourceString;
    public CalculatorTestCase () {
        // TODO Auto-generated constructor stub
        super("com.example.android.calculator",MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        // TODO Auto-generated method stub
        //	super.setUp();

        mActivity = this.getActivity();
        solo = new Solo(getInstrumentation(),getActivity());
        mView = (TextView) mActivity.findViewById(R.id.ExpText);
        resourceString = mActivity.getString(R.string.hello_world);

    }

    @Override
    protected void tearDown() throws Exception {
        // TODO Auto-generated method stub
        //super.tearDown();
        solo.finishOpenedActivities();
    }

    public void testAddNum(){
        //Log.d("exp111111111","in");
        solo.waitForActivity("MainActivity", 2000);
        solo.clickOnButton("5");
        solo.clickOnButton("+");
        solo.clickOnButton("6");
        solo.clickOnButton("=");
        TextView t = (TextView) solo.getView(R.id.ExpText);
        assertEquals(t.getText(),"11");

    }
    public void testSubNum(){
        //Log.d("exp111111111","in");
        solo.waitForActivity("MainActivity", 2000);
        solo.clickOnButton("4");
        solo.clickOnButton("0");
        solo.clickOnButton("-");
        solo.clickOnButton("5");
        solo.clickOnButton("5");
        solo.clickOnButton("=");
        TextView t = (TextView) solo.getView(R.id.ExpText);
        assertEquals(t.getText(),"-15");

    }
    public void testMulNum(){
        //Log.d("exp111111111","in");
        Button dot = (Button) solo.getView(R.id.dot);
        solo.waitForActivity("MainActivity", 2000);
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("2");
        solo.clickOnView(dot);
        solo.clickOnButton("5");
        solo.clickOnButton("x");
        solo.clickOnButton("8");
        solo.clickOnButton("9");
        solo.clickOnView(dot);
        solo.clickOnButton("3");
        solo.clickOnButton("3");
        solo.clickOnButton("=");
        solo.takeScreenshot();
        TextView t = (TextView) solo.getView(R.id.ExpText);
        assertEquals(t.getText(),"9156.33");

    }
    public void testDivNum(){
        //Log.d("exp111111111","in");
        solo.waitForActivity("MainActivity", 2000);
        solo.clickOnButton("5");
        solo.clickOnButton("8");
        solo.clickOnButton("/");
        solo.clickOnButton("6");
        solo.clickOnButton("9");
        solo.clickOnButton("=");
        TextView t = (TextView) solo.getView(R.id.ExpText);
        assertEquals(t.getText(),"0.84");

    }

}
