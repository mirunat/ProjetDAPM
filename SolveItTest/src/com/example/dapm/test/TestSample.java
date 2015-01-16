package com.example.dapm.test;

import com.example.dapm.MainActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import junit.framework.TestCase;

public class TestSample extends ActivityInstrumentationTestCase2<MainActivity> {


    public TestSample() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        
        // ensure a valid handle to the activity has been returned
       
    }
    
    public void test(){
    	final MainActivity a = getActivity();
    	 assertNotNull(a);
    }


}
