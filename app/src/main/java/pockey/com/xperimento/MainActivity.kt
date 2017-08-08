package pockey.com.xperimento

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity(),ListenOnClick{


    lateinit var communicator1: FragmentFirstCommunicator
    lateinit var communicator2: FragmentSecondCommunicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame)
        if(savedInstanceState==null) {
            setFragment(R.id.fl_container_i, FirstFragment());
            setFragment(R.id.fl_container_ii, SecondFragment());
        }
    }

    fun setFragment(fl_container: Int,fragment:Fragment?) {
        supportFragmentManager.beginTransaction()
                .replace(fl_container, fragment)
                .commit()
    }

    /* override fun onFirstButtonClick(data: String?) {
         communicator2.passDataToSecondFragment(data,1)
     }
     override fun onSecondButtonClick(data: String?) {
         communicator1.passDataToFirstFragment(data,0)
     }*/

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig!!.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();
        }
    }

    override fun onButtonClicked(data: String?, flag: Int) {
        if(flag==1) {
            communicator2.passDataToSecondFragment(data,flag)
        } else if(flag==2) {
            communicator1.passDataToFirstFragment(data,flag)
        }
    }
}