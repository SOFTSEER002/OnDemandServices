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
 * {@link CleaningFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CleaningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CleaningFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView rv_cleaning;
    List<Womenmodel> womenlist=new ArrayList<>();
    WomenAdapter womenAdapter;
    private OnFragmentInteractionListener mListener;

    public CleaningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CleaningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CleaningFragment newInstance(String param1, String param2) {
        CleaningFragment fragment = new CleaningFragment();
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
        View v= inflater.inflate(R.layout.fragment_cleaning, container, false);

        rv_cleaning=v.findViewById(R.id.rv_cleaning);

        womenlist.clear();
        womenlist.add(new Womenmodel("Maid Cleaning Services",R.drawable.maid_cleaning,"4"));
        womenlist.add(new Womenmodel("Bathroom Deep Cleaning",R.drawable.bathroom_cleaning,"5"));
        womenlist.add(new Womenmodel("Kitchen Deep Cleaning",R.drawable.kitchen_cleaning,"6"));
        womenlist.add(new Womenmodel("Sofa Cleaning",R.drawable.sofa_cleaning,"7"));
        womenlist.add(new Womenmodel("Home Deep Cleaning",R.drawable.home_deep_cleaning,"8"));
        womenlist.add(new Womenmodel("Car Cleaning",R.drawable.car_cleaning,"9"));
        womenlist.add(new Womenmodel("Carpet Cleaning",R.drawable.carpet_cleaning,"10"));

        rv_cleaning.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        womenAdapter=new WomenAdapter(getActivity(),womenlist);
        rv_cleaning.setAdapter(womenAdapter);
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
