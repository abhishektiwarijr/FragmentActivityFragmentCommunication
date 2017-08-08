package pockey.com.xperimento


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.EventBus
import java.util.*


/**
 * A simple [Fragment] subclass.
 */

class BlankFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_blank, container, false)
        //binding = DataBindingUtil.bind(view)
        //binding!!.bSend.setOnClickListener(View.OnClickListener {
           // mCallback!!.onButtonClicked(binding!!.etEnterData.text.toString())
        //})
        return view
    }

    class BlankFragment()
}