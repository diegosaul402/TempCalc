package com.diegosaul402.tempcalc.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.diegosaul402.tempcalc.DetailedActivity;
import com.diegosaul402.tempcalc.R;
import com.diegosaul402.tempcalc.adapters.OnItemClickListener;
import com.diegosaul402.tempcalc.adapters.TempAdapter;
import com.diegosaul402.tempcalc.temps.TempEntity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment implements DetailsFragmentListener, OnItemClickListener{
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    TempAdapter tempAdapter;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(tempAdapter);
    }

    private void initAdapter() {
        if (tempAdapter == null) {
            tempAdapter = new TempAdapter(getActivity().getApplicationContext(), this);
        }
    }

    @Override
    public void initList() {
        tempAdapter.init();

    }

    @Override
    public void addToList(TempEntity tempEntity) {
        tempAdapter.add(tempEntity);
    }

    @Override
    public void clearList() {
        tempAdapter.clear();
    }

    @Override
    public void onItemClick(TempEntity tempEntity) {
        Toast.makeText(getActivity().getApplicationContext(), tempEntity.getStrOutput(),Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity().getApplicationContext(), DetailedActivity.class);
        intent.putExtra("text", tempEntity.getStrOutput());
        startActivity(intent);

    }
}
