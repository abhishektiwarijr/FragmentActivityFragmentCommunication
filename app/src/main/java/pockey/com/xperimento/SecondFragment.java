package pockey.com.xperimento;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pockey.com.xperimento.databinding.FragmentSecondBinding;

/**
 * Created by abhishek.tiwari on 6/8/17.
 **/

public class SecondFragment extends Fragment implements View.OnClickListener,FragmentSecondCommunicator {
    private static final String KEY1 ="NewKey" ;
    private FragmentSecondBinding binding;
    private ListenOnClick mCallback;
    private CommunicatorSecond communicatorSecond;
    private Context mContext;
    private Toast mToast;


    public interface CommunicatorSecond {
        void onSecondButtonClick(String data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext=context;

        //communicator=((MainActivity)context).getCommunicator();
        ((MainActivity)context).communicator2 = this;
        // communicator=this;

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try{
            mCallback = (ListenOnClick) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement ListenOnClick");
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
            outState.putString(KEY1,binding.tvShowIi.getText().toString());
    }

    @Override
    public void onResume() {
        super.onResume();
        // EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        // EventBus.getDefault().unregister(this);
        super.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second,container,false);
        binding= DataBindingUtil.bind(view);
        binding.bSendIi.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b_send_ii:
                if(binding.etEnterDataIi.getText().toString().length()!=0) {
                    mCallback.onButtonClicked(binding.etEnterDataIi.getText().toString(),2);
                    //EventBus.getDefault().post(new MessageEventSecond(binding.etEnterDataIi.getText().toString()));
                    // mCallback.onButtonClicked(binding.etEnterDataIi.getText().toString(),1);
                } else {

                    if(mToast!=null) {
                        mToast.cancel();
                    }
                    mToast=Toast.makeText(mContext,"No Data To Transfer",Toast.LENGTH_SHORT);
                    mToast.show();
                }
                break;
        }
    }

    @Override
    public void passDataToSecondFragment(String someValue, int flag) {
        binding.tvShowIi.setText(someValue);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState!=null) {
            binding.tvShowIi.setText(savedInstanceState.getString(KEY1));
        }
    }
    /*@Subscribe
    public void onMessageEvent(MessageEvent event) {
        if(event!=null)
        binding.tvShowIi.setText(event.getData());
    }*/
}