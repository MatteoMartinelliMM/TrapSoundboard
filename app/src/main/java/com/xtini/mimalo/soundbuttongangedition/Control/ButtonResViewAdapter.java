package com.xtini.mimalo.soundbuttongangedition.Control;



import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import com.xtini.mimalo.soundbuttongangedition.Model.AudioFile;
import com.xtini.mimalo.soundbuttongangedition.R;


/**
 * Created by Teo on 03/02/2018.
 */

public class ButtonResViewAdapter extends RecyclerView.Adapter<ButtonResViewAdapter.ViewHolder> {
    private ArrayList<AudioFile> audioList;
    private Context context;



    public ButtonResViewAdapter(ArrayList<AudioFile> buttonNames, Context context) {
        this.audioList = buttonNames;
        this.context = context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView buttonElement;
        public TextView buttonLabel;
        public ImageButton codeineButton;

        public ViewHolder(View v) {
            super(v);
            buttonElement = itemView.findViewById(R.id.buttonElement);
            buttonLabel = v.findViewById(R.id.buttonLabel);
            codeineButton = v.findViewById(R.id.soundAction);

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        if (parent != null)
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_button_list, null);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String currentButtonName = audioList.get(position).getFileName();
        currentButtonName = currentButtonName.substring(0, currentButtonName.length() - 4);
        currentButtonName = currentButtonName.replace("_", " ");
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "futura-heavy-oblique.ttf");
        holder.buttonLabel.setTypeface(typeface);
        if (currentButtonName.contains(" ") && currentButtonName.length() > 10)
            holder.buttonLabel.setText(currentButtonName);
        else
            holder.buttonLabel.setText("  " + currentButtonName + "  ");
        holder.codeineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        holder.codeineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AssetFileDescriptor assetFileDescriptor = audioList.get(position).getSound();
                final MediaPlayer mp = new MediaPlayer();
                MediaPlayerRegistry.put(mp);

                try {
                    mp.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    mp.prepare();
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            MediaPlayerRegistry.releaseSinglePlayer(mediaPlayer.getAudioSessionId());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

    }

    @Override
    public int getItemCount() {
        return audioList.size();
    }


}
