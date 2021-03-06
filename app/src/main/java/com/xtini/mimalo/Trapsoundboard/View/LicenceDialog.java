package com.xtini.mimalo.Trapsoundboard.View;


import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xtini.mimalo.Trapsoundboard.R;

/**
 * Created by matteoma on 3/28/2018.
 */

public class LicenceDialog extends DialogFragment {
    private Context context;
    private TextView licence;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.dialog_licence, container);
        licence = v1.findViewById(R.id.licence);
        context = v1.getContext();
        getDialog().setTitle("Termini e Licenze");
        return v1;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        licence.setText(Html.fromHtml(getString(R.string.licence)));
    }

}