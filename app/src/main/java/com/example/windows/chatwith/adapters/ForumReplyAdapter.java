package com.example.windows.chatwith.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.windows.chatwith.R;
import com.example.windows.chatwith.beans.ForumCommentBean;
import com.example.windows.chatwith.utils.DateFormatUtil;

import java.util.ArrayList;

/**
 * Created by Windows on 2018/6/29.
 * 回复布局的adapter
 */

public class ForumReplyAdapter extends RecyclerView.Adapter implements AdapterView.OnItemClickListener {
    private final int mResId;
    private final ArrayList<Object> mReplyList;
    private ViewHolder mViewHolder;
    private Context mCtx;
    private ForumAdapter.OnItemClickListener mOnItemClickListener;

    public ForumReplyAdapter(int resId, ArrayList<Object> list) {
        mResId = resId;
        mReplyList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mCtx = parent.getContext();
        LayoutInflater from = LayoutInflater.from(mCtx);
        View inflate = from.inflate(mResId, null);
        mViewHolder = new ViewHolder(inflate);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ForumCommentBean forumComment = (ForumCommentBean) mReplyList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        View itemView = viewHolder.itemView;

        viewHolder.reviewerHp = itemView.findViewById(R.id.iv_headPortrait);
        viewHolder.reviewerName = itemView.findViewById(R.id.tv_niceName);
        viewHolder.reviewContent = itemView.findViewById(R.id.tv_replyContent);
        viewHolder.reviewTime = itemView.findViewById(R.id.tv_replyTime);
        viewHolder.replyName = itemView.findViewById(R.id.tv_replyName);

        Glide.with(mViewHolder.reviewerHp.getContext())
                .load(forumComment.getReviewerHp())
                .apply(new RequestOptions().centerCrop())
                .into(mViewHolder.reviewerHp);

        viewHolder.reviewerName.setText(forumComment.getReviewerName());
        viewHolder.reviewTime.setText(DateFormatUtil.getDate(forumComment.getReviewTime()));
        viewHolder.reviewContent.setText(forumComment.getReviewContent());

        String replyName = forumComment.getReplyName();
        if(replyName.equals("")){
            viewHolder.replyName.setVisibility(View.GONE);
        }else{
            viewHolder.replyName.setVisibility(View.VISIBLE);
            viewHolder.replyName.setText("回复 "+replyName);
        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mReplyList.size();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mCtx, position + ":" + id, Toast.LENGTH_SHORT).show();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView reviewerHp;
        TextView reviewerName;
        TextView reviewTime;
        TextView reviewContent;
        TextView replyName;

        ViewHolder(View itemView) {
            super(itemView);
        }
    }

    interface OnItemClickListener{
        void onClick(int position);
    }

    public void setOnItemClickListener(ForumAdapter.OnItemClickListener listener){
        mOnItemClickListener=listener;
    }
}
