package pockey.com.xperimento;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import pockey.com.xperimento.databinding.FragmentBlankBinding;

/**
 * Created by abhishek.tiwari on 6/8/17.
 **/

public class FirstFragment extends Fragment implements View.OnClickListener,FragmentFirstCommunicator {
    private FragmentBlankBinding binding;
    private ListenOnClick mCallback;
    private Context mContext;
    private Toast mToast;
    private static final String KEY="KEY";

    public FirstFragment() {

    }

    public interface CommunicatorFirst {
        void onFirstButtonClick(String data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;

        ((MainActivity)context).communicator1 = this;

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (ListenOnClick) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement ListenOnClick");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        //EventBus.getDefault().unregister(this);
        super.onPause();
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank,container,false);
        binding= DataBindingUtil.bind(view);
        //if(savedInstanceState!=null) binding.tvShow.setText(savedInstanceState.getString(MyConstants.KEY));
        binding.bSend.setOnClickListener(this);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY,binding.tvShow.getText().toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b_send:
                if(binding.etEnterData.getText().toString().length()!=0) {
                    mCallback.onButtonClicked(binding.etEnterData.getText().toString(),1);
                    //EventBus.getDefault().post(new MessageEvent(binding.etEnterData.getText().toString()));
                    //mCallback.onButtonClicked(binding.etEnterData.getText().toString(),0);
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
    public void passDataToFirstFragment(String someValue, int flag) {
        binding.tvShow.setText(someValue);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState!=null)  {
            binding.tvShow.setText(savedInstanceState.getString(KEY));
        }
    }

    /*  @Subscribe
        public void onMessegeReceive(MessageEventSecond event) {
            if(event!=null) binding.tvShow.setText(event.getMsg());
        }   */
}