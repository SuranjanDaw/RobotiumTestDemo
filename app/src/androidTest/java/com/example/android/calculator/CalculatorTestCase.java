package com.example.android.calculator;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
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

        solo.finishOpenedActivities();
    }

    public void testAddNum(){

        solo.waitForActivity("MainActivity", 2000);
        solo.clickOnButton("5");
        solo.clickOnButton("+");
        solo.clickOnButton("6");
        solo.clickOnButton("=");
        TextView t = (TextView) solo.getView(R.id.ExpText);
        solo.takeScreenshot("AD");
        assertEquals(t.getText(),"11");

    }
    public void testSubNum(){

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
    public void testAdvanced() throws InterruptedException {
        // CalCulator
        Button btn = (Button) solo.getView(R.id.note_btn);
        solo.clickOnView(btn);
        solo.waitForActivity("NotesTaking",1000);
        solo.assertCurrentActivity("Correct Notes Activity","NotesTaking");


        //Notes
        Button btn1 = (Button) solo.getView(R.id.save_btn);
        Button btn2 = (Button) solo.getView(R.id.cal_btn);
        EditText e = (EditText) solo.getView(R.id.note_text);
        solo.hideSoftKeyboard();
        solo.enterText(e,"Mangoes = 5 x 10 = ");
        solo.sleep(1000);
        solo.clickOnView(btn1);
        solo.clickOnView(btn2);



        //Calculator
        solo.waitForActivity("MainActivity", 2000);
        solo.assertCurrentActivity("Correct MainActivity","MainActivity");
        solo.clickOnButton("5");
        solo.clickOnButton("x");
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("=");
        TextView t = (TextView) solo.getView(R.id.ExpText);
        assertEquals(t.getText(),"50");
        btn = (Button) solo.getView(R.id.note_btn);
        solo.clickOnView(btn);



        // Notes
        solo.waitForActivity("NotesTaking",1000);
        solo.assertCurrentActivity("Correct Notes Activity","NotesTaking");
        btn1 = (Button) solo.getView(R.id.save_btn);
        btn2 = (Button) solo.getView(R.id.cal_btn);
        e = (EditText) solo.getView(R.id.note_text);
        solo.enterText(e,"50");
        solo.sleep(1000);
        solo.enterText(e,"\nBananas = 10 x 5 = ");
        solo.sleep(1000);
        solo.clickOnView(btn1);
        solo.clickOnView(btn2);


        //Calculator
        solo.waitForActivity("MainActivity", 2000);
        solo.assertCurrentActivity("Correct MainActivity","MainActivity");
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("x");
        solo.clickOnButton("5");
        solo.clickOnButton("=");
        t = (TextView) solo.getView(R.id.ExpText);
        assertEquals(t.getText(),"50");
        btn = (Button) solo.getView(R.id.note_btn);
        solo.clickOnView(btn);

        // Notes
        solo.waitForActivity("NotesTaking",1000);
        solo.assertCurrentActivity("Correct Notes Activity","NotesTaking");
        btn1 = (Button) solo.getView(R.id.save_btn);
        btn2 = (Button) solo.getView(R.id.cal_btn);
        e = (EditText) solo.getView(R.id.note_text);
        solo.enterText(e,"50");
        solo.sleep(1000);
        solo.enterText(e, "\n");
        solo.enterText(e,"Watermelons = 20 x 50 = ");
        solo.sleep(1000);
        solo.clickOnView(btn1);
        solo.clickOnView(btn2);

        //Calculator
        solo.waitForActivity("MainActivity", 2000);
        solo.assertCurrentActivity("Correct MainActivity","MainActivity");
        solo.clickOnButton("2");
        solo.clickOnButton("0");
        solo.clickOnButton("x");
        solo.clickOnButton("5");
        solo.clickOnButton("0");
        solo.clickOnButton("=");
        t = (TextView) solo.getView(R.id.ExpText);
        assertEquals(t.getText(),"1000");
        btn = (Button) solo.getView(R.id.note_btn);
        solo.clickOnView(btn);

        // Notes
        solo.waitForActivity("NotesTaking",1000);
        solo.assertCurrentActivity("Correct Notes Activity","NotesTaking");
        btn1 = (Button) solo.getView(R.id.save_btn);
        btn2 = (Button) solo.getView(R.id.cal_btn);
        e = (EditText) solo.getView(R.id.note_text);
        solo.enterText(e,"1000");
        solo.sleep(1000);
        solo.enterText(e, "\n");
        solo.enterText(e,"Sum =  ");
        solo.sleep(1000);
        solo.clickOnView(btn1);
        solo.clickOnView(btn2);


        //Calculator
        solo.waitForActivity("MainActivity", 2000);
        solo.assertCurrentActivity("Correct MainActivity","MainActivity");
        solo.clickOnButton("5");
        solo.clickOnButton("0");
        solo.clickOnButton("+");
        solo.clickOnButton("5");
        solo.clickOnButton("0");
        solo.clickOnButton("+");
        solo.clickOnButton("1");
        solo.clickOnButton("0");
        solo.clickOnButton("0");
        solo.clickOnButton("0");
        solo.clickOnButton("=");
        t = (TextView) solo.getView(R.id.ExpText);
        assertEquals(t.getText(),"1100");
        btn = (Button) solo.getView(R.id.note_btn);
        solo.clickOnView(btn);



        // Notes
        solo.waitForActivity("NotesTaking",1000);
        solo.assertCurrentActivity("Correct Notes Activity","NotesTaking");
        btn1 = (Button) solo.getView(R.id.save_btn);
        btn2 = (Button) solo.getView(R.id.cal_btn);
        e = (EditText) solo.getView(R.id.note_text);
        solo.enterText(e,"1100");
        solo.sleep(1000);
        solo.clickOnView(btn1);
        String s = String.valueOf(e.getText());
        String s1 = s.substring(s.length()-4);
        Button bill = (Button) solo.getView(R.id.bill);
        solo.clickOnView(bill);
        solo.scrollDown();
        solo.scrollDown();
        solo.sleep(5000);
        assertEquals(s1,"1100");

    }

}
