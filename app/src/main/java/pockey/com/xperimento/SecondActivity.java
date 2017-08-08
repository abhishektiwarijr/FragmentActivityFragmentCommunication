package pockey.com.xperimento;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by abhishek.tiwari on 6/8/17.
 **/

public class SecondActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame);
        setFragment(R.id.fl_container_i,new FirstFragment());
        setFragment(R.id.fl_container_ii,new SecondFragment());
    }

    private void setFragment(int fl_container,Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(fl_container,fragment).commit();
    }
}