package com.example.goldenromance.Cards;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.goldenromance.R;

import java.util.List;

public class arrayAdapter extends ArrayAdapter<card> {

    Context context;

    public arrayAdapter(Context context, int resourceId, List<card> item) {
        super(context, resourceId, item);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        card card_item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.name);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        TextView budget = (TextView) convertView.findViewById(R.id.budget);
        ImageView mGiveImage = (ImageView) convertView.findViewById(R.id.needImage);

        name.setText(card_item.getName());
        budget.setText(card_item.getBudget());


        if (card_item.getNeed().equals("Netflix")) {
            mNeedImage.setImageDrawble(ContextCompat.getDrawable(getContext(), R.drawable.netflix));
        } else if (card_item.getNeed().equals("Amazon Prime"))
            mNeedImage.setImageDrawble(ContextCompat.getDrawable(getContext(), R.drawable.amazon));
        else if (card_item.getNeed().equals("Hulu"))
            mNeedImage.setImageDrawble(ContextCompat.getDrawable(getContext(), R.drawable.hulu));
        else if (card_item.getNeed().equals("HBO"))
            mNeedImage.setImageDrawble(ContextCompat.getDrawable(getContext(), R.drawable.hbo));
        else if (card_item.getNeed().equals("Youtube"))
            mNeedImage.setImageDrawble(ContextCompat.getDrawable(getContext(), R.drawable.youtube));
        else
            mNeedImage.setImageDrawble(ContextCompat.getDrawable(getContext(), R.drawable.none));

        if (card_item.getGive().equals("Netflix"))
            mGiveImage.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.netflix));
        else if (card_item.getGive().equals("Amazon Prime"))
            mGiveImage.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.amaazon));
        else if (card_item.getGive().equals("Hulu"))
            mGiveImage.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.hulu));
        else if (card_item.getGive().equals("Vudu"))
            mGiveImage.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.vudu));
        else if (card_item.getGive().equals("HBO"))
            mGiveImage.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.hbo));
        else if (card_item.getGive().equals("Youtube"))
            mGiveImage.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.youtube));
        else
            mGiveImage.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.none));


        switch (card_item.getProfileImageUrl()) {
            case "default"
                Glide.with(convertView.getContext()).load(R.drawable.profile).into(image);
            break;
            default:
                Glide.clear(image);
                Glide.with(convertView.getContext()).load(card_item.getProfileImageUrl()).into(image);
                break;
        }
        return convertView;
    }


}
