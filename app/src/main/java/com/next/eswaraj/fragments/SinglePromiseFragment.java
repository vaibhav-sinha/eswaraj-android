package com.next.eswaraj.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.next.eswaraj.R;
import com.next.eswaraj.base.BaseFragment;
import com.next.eswaraj.config.TimelineType;
import com.next.eswaraj.models.PromiseDto;


public class SinglePromiseFragment extends BaseFragment {

    private PromiseDto promiseDto;
    private TextView spTitle;
    private TextView spDescription;
    private TimelineFragment timelineFragment;
    private View headerView;


    public SinglePromiseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Promise");
        promiseDto = (PromiseDto) getActivity().getIntent().getSerializableExtra("PROMISE");
        if(savedInstanceState == null) {
            timelineFragment = new TimelineFragment();
            getChildFragmentManager().beginTransaction().add(R.id.spTimeline, timelineFragment).commit();
        }
        timelineFragment.setTypeAndId(TimelineType.PROMISE, promiseDto.getId());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_single_promise, container, false);
        headerView = getActivity().getLayoutInflater().inflate(R.layout.header_single_promise, null);
        timelineFragment.setHeader(headerView);
        spTitle = (TextView) headerView.findViewById(R.id.spTitle);
        spDescription = (TextView) headerView.findViewById(R.id.spDescription);

        spTitle.setText(promiseDto.getTitle());
        spDescription.setText(promiseDto.getDescription());
        return rootView;
    }


}
