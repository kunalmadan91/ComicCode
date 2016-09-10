package com.kunalmadan.android.comiclover;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ComicDetail extends AppCompatActivity {


    @Bind(R.id.detail_title)
    TextView titleView;

    @Bind(R.id.onsaledate)
    TextView onSaleDate;

    @Bind(R.id.diamondCode)
    TextView diamondCode;

    @Bind(R.id.issueNumber)
    TextView issueNumber;


    /*@Bind(R.id.detail_rating) TextView avg;*/

    @Bind(R.id.desc)
    TextView description;

    @Bind(R.id.img)
    ImageView mainImage;

    CollapsingToolbarLayout collapsingToolbarLayout;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);


        Intent intent = getIntent();

        Comic cmc = intent.getExtras().getParcelable("key");

        ButterKnife.bind(this);

        try {
            if (cmc.getOnSaleDate().equals("null") || cmc.getOnSaleDate() == "0") {
                onSaleDate.setText("NA");
            } else {
                String dateParse = dateParser(cmc.getOnSaleDate());
                onSaleDate.setText(dateParse);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        titleView.setText(cmc.getTitle());
        collapsingToolbarLayout.setTitle(cmc.getTitle());


        if (cmc.getDescription().equals("null") || cmc.getDescription() == "0") {

            description.setText("Oops!!..description not Available!!");
        } else {
            description.setText(cmc.getDescription());
        }


        if (cmc.getIssueNumber().equals("null") || cmc.getIssueNumber() == "0") {
            issueNumber.setText("NA");
        }

        else {
            issueNumber.setText(cmc.getIssueNumber());
        }

        issueNumber.setText(cmc.getIssueNumber());


        if(cmc.getDiamondCode().equals("null") || cmc.getDiamondCode().equals("")) {
            diamondCode.setText("NA");
        }
        else {
            diamondCode.setText(cmc.getDiamondCode());
        }


        String url = cmc.getImage();

        String img = url + "/landscape_xlarge.jpg";

        Picasso.with(this)
                .load(img).placeholder(R.drawable.icon)
                .error(R.drawable.icon)
                .into(mainImage);

        Toast.makeText(ComicDetail.this, "hey" + cmc.getDiamondCode(), Toast.LENGTH_SHORT).show();
    }

    public boolean isConnectingToInternet() {

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public String dateParser(String date) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date dateStr = formatter.parse(date);

        String formattedDate = formatter.format(dateStr);

        return formattedDate;
    }


}
