package com.quran.qradio.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quran.qradio.R;
import com.quran.qradio.data.entities.Mp3QuranEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PhucTV on 6/9/16.
 */
public class Mp3QuranAdapter extends RecyclerView.Adapter<Mp3QuranAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onUserItemClicked(Mp3QuranEntity userModel);
    }

    private List<Mp3QuranEntity> mMp3QuranEntityList;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    @Inject
    public Mp3QuranAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mMp3QuranEntityList = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return (this.mMp3QuranEntityList != null) ? this.mMp3QuranEntityList.size() : 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.item_mp3_quran, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Mp3QuranEntity userModel = this.mMp3QuranEntityList.get(position);
//        holder.textViewTitle.setText(userModel.getFullName());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View v) {
//                if (UsersAdapter.this.onItemClickListener != null) {
//                    UsersAdapter.this.onItemClickListener.onUserItemClicked(userModel);
//                }
//            }
//        });
    }

    public void setMp3QuranCollection(Collection<Mp3QuranEntity> mp3QuranCollection) {
        this.validateUsersCollection(mp3QuranCollection);
        this.mMp3QuranEntityList = (List<Mp3QuranEntity>) mp3QuranCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateUsersCollection(Collection<Mp3QuranEntity> usersCollection) {
        if (usersCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView textViewTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
