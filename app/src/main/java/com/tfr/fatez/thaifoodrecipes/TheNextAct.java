package com.tfr.fatez.thaifoodrecipes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class TheNextAct extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;
    final Uri imageUri = Uri.parse("res:///" + R.drawable.ic_arrow_left_white_36dp);

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    private AppBarLayout appbar;
    private CollapsingToolbarLayout collapsing;
    private ImageView coverImage;
    private FrameLayout framelayoutTitle;
    private LinearLayout linearlayoutTitle;
    private Toolbar toolbar;
    private TextView textviewTitle;
    private SimpleDraweeView avatar;
    private TextView textHead, textIngrediats, textHowTo, textHead2;
    private AdView mAdView;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-03-03 11:32:38 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        collapsing = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        coverImage = (ImageView) findViewById(R.id.imageview_placeholder);
        framelayoutTitle = (FrameLayout) findViewById(R.id.framelayout_title);
        linearlayoutTitle = (LinearLayout) findViewById(R.id.linearlayout_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        avatar = (SimpleDraweeView) findViewById(R.id.avatar);
        textviewTitle = (TextView) findViewById(R.id.textview_title);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.secondpage);
        findViews();

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        toolbar.setTitle("");
        appbar.addOnOffsetChangedListener(this);

        setSupportActionBar(toolbar);
        startAlphaAnimation(textviewTitle, 0, View.INVISIBLE);

        //set avatar and cover
        avatar.setImageURI(imageUri);
        coverImage.setImageResource(R.drawable.cover);

        textHead = (TextView) findViewById(R.id.textHead);
        textIngrediats = (TextView) findViewById(R.id.ingredients);
        textHowTo = (TextView) findViewById(R.id.text_how_to);
        textHead2 = (TextView) findViewById(R.id.textHead2);

        Bundle bundle = getIntent().getExtras();
        String mFood = bundle.getString("mFood");

       // Check value the pass form MainActivity the position of card view id.

        if (mFood.equals("GreenCurry")) {
            textHead.setText(getString(R.string.green_curry_title));
            textHead2.setText(getString(R.string.green_curry_title));
            textviewTitle.setText(getString(R.string.green_curry_title));
            coverImage.setImageResource(R.drawable.greencurry_cover);
            textIngrediats.setText(getString(R.string.green_curry_ingredients));
            textHowTo.setText(getString(R.string.green_curry_how_to));
        }
        if (mFood.equals("SweetPork")) {
            textHead.setText("หมูหวาน");
            textHead2.setText("หมูหวาน");
            textviewTitle.setText("หมูหวาน");
            coverImage.setImageResource(R.drawable.sweetpork);
            textIngrediats.setText(getString(R.string.sweet_pock_ingredients));
            textHowTo.setText(getString(R.string.sweet_pock_how_to));
        }
        if (mFood.equals("EggPalow")) {
            textHead.setText("ไข่พะโล้");
            textHead2.setText("ไข่พะโล้");
            textviewTitle.setText("ไข่พะโล้");
            coverImage.setImageResource(R.drawable.egg_pork);
            textIngrediats.setText(getString(R.string.egg_palow_ingredients));
            textHowTo.setText(getString(R.string.egg_palow_how_to));
        }
        if (mFood.equals("shrimp")) {
            textHead.setText("กุ้งมะนาว");
            textHead2.setText("กุ้งมะนาว");
            textviewTitle.setText("กุ้งมะนาว");
            coverImage.setImageResource(R.drawable.shrimp);
            textIngrediats.setText(getString(R.string.shrimp_lemon_ingredients));
            textHowTo.setText(getString(R.string.shrimp_lemon_how_to));
        }
        if (mFood.equals("taohoo")) {
            textHead.setText("เต้าหู้ทรงเครื่อง");
            textHead2.setText("เต้าหู้ทรงเครื่อง");
            textviewTitle.setText("เต้าหู้ทรงเครื่อง");
            coverImage.setImageResource(R.drawable.taohoo);
            textIngrediats.setText(getString(R.string.taohoo_ingredients));
            textHowTo.setText(getString(R.string.taohoo_ingredients));
        }
        if (mFood.equals("chicken_takai")) {
            textHead.setText("ไก่ทอดเกลือตะไคร้กรอบ");
            textHead2.setText("ไก่ทอดเกลือตะไคร้กรอบ");
            textviewTitle.setText("ไก่ทอดเกลือตะไคร้กรอบ");
            coverImage.setImageResource(R.drawable.chicken_takai);
            textIngrediats.setText(getString(R.string.chicken_takai_ingredients));
            textHowTo.setText(getString(R.string.chicken_takai_how_to));
        }
        if (mFood.equals("harapa")) {
            textHead.setText("เห็ดฟางผัดใบโหระพา");
            textHead2.setText("เห็ดฟางผัดใบโหระพา");
            textviewTitle.setText("เห็ดฟางผัดใบโหระพา");
            coverImage.setImageResource(R.drawable.harapa);
            textIngrediats.setText(getString(R.string.horapa_ingredients));
            textHowTo.setText(getString(R.string.horapa_how_to));
        }
        if (mFood.equals("lap")) {
            textHead.setText("ลาบหมู");
            textHead2.setText("ลาบหมู");
            textviewTitle.setText("ลาบหมู");
            coverImage.setImageResource(R.drawable.lap);
            textIngrediats.setText(getString(R.string.lap_pork_ingredients));
            textHowTo.setText(getString(R.string.lap_pork_how_to));
        }
        if (mFood.equals("hoi")) {
            textHead.setText("หอยทอด");
            textHead2.setText("หอยทอด");
            textviewTitle.setText("หอยทอด");
            coverImage.setImageResource(R.drawable.hoi);
            textIngrediats.setText(getString(R.string.hoi_ingredients));
            textHowTo.setText(getString(R.string.horapa_how_to));
        }
        if (mFood.equals("yumhoi")) {
            textHead.setText("ยำหอยแครง");
            textHead2.setText("ยำหอยแครง");
            textviewTitle.setText("ยำหอยแครง");
            coverImage.setImageResource(R.drawable.yumhoi);
            textIngrediats.setText(getString(R.string.yum_hoi_ingredients));
            textHowTo.setText(getString(R.string.yum_hoi_how_to));
        }


        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TheNextAct.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(textviewTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(textviewTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(linearlayoutTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(linearlayoutTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }


    // Back button on the user device
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TheNextAct.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
