package com.example.windows.chatwith.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windows.chatwith.R;
import com.example.windows.chatwith.adapters.ForumAdapter;
import com.example.windows.chatwith.utils.Data;

/**
 * Created by Windows on 2018/6/29.
 */

public class ForumFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_forum, null);
        initView(inflate);

        return inflate;
    }

    private void initView(View inflate) {
        mRecyclerView = inflate.findViewById(R.id.recyclerView);
        ForumAdapter mAdapter = new ForumAdapter(R.layout.item_forum, Data.getForumList(),getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter.setOnItemClickListener(new ForumAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                //Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
