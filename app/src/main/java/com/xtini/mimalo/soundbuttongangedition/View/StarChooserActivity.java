package com.xtini.mimalo.soundbuttongangedition.View;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.xtini.mimalo.soundbuttongangedition.Control.MyAdapter;
import com.xtini.mimalo.soundbuttongangedition.R;

import java.util.ArrayList;
import java.util.List;


public class StarChooserActivity extends AppCompatActivity {
    private ImageButton sfera;
    List<Integer> lstImages = new ArrayList<>();
    List<String> lstNomi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_chooser);
        initData();
        HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);
        MyAdapter adapter = new MyAdapter(lstImages,lstNomi,getBaseContext());
        pager.setAdapter(adapter);

    }

    private void initData() {
        lstImages.add(R.drawable.sfera_ebbasta);
        lstImages.add(R.drawable.tony_effe);
        lstImages.add(R.drawable.wayne);
        lstNomi.add("Sfera Ebbasta");
        lstNomi.add("Tony Effe");
        lstNomi.add("Dark Wayne");
    }
}
