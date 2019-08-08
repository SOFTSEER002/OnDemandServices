package com.example.ondemandapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ondemandapp.R;
import com.example.ondemandapp.adapter.WomenAdapter;
import com.example.ondemandapp.modelclass.Womenmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ApplianceRepairFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ApplianceRepairFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApplianceRepairFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView rv_appliance;
    List<Womenmodel> womenlist=new ArrayList<>();
    WomenAdapter womenAdapter;
    private OnFragmentInteractionListener mListener;

    public ApplianceRepairFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ApplianceRepairFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ApplianceRepairFragment newInstance(String param1, String param2) {
        ApplianceRepairFragment fragment = new ApplianceRepairFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_appliance_repair, container, false);

        rv_appliance=v.findViewById(R.id.rv_appliance);

        womenlist.clear();

        womenlist.add(new Womenmodel("RO or Water Purifier Repair",R.drawable.water_purifier,"14"));
        womenlist.add(new Womenmodel("Refrigerator Repair",R.drawable.refrigerator_repair,"15"));
        womenlist.add(new Womenmodel("Washing Machine Repair",R.drawable.wahing_repair,"16"));
        womenlist.add(new Womenmodel("Microwave Repair",R.drawable.microwave_repair,"17"));
        womenlist.add(new Womenmodel("Television Repair \u0026 Installation",R.drawable.tv_repair,"18"));
        womenlist.add(new Womenmodel("Geyser / Water Heater Repair",R.drawable.geyser_repair,"19"));
        womenlist.add(new Womenmodel("AC Service and Repair",R.drawable.ac_service,"20"));
        womenlist.add(new Womenmodel("Chimney Cleaning \u0026 Repair",R.drawable.chimney,"21"));
        womenlist.add(new Womenmodel("Laptop Repair",R.drawable.laptop_repair,"22"));
        womenlist.add(new Womenmodel("iPad,Mac Repair",R.drawable.imac_repairr,"23"));
        womenlist.add(new Womenmodel("Mobile Screen Repair",R.drawable.mobile_repair,"24"));
        womenlist.add(new Womenmodel("Computer Repair",R.drawable.computer_repair,"25"));
        womenlist.add(new Womenmodel("Mixer \u0026 Grinder Repair",R.drawable.mixer_repair,"26"));

        rv_appliance.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        womenAdapter=new WomenAdapter(getActivity(),womenlist);
        rv_appliance.setAdapter(womenAdapter);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
