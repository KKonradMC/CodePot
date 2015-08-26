package com.konradkrakowiak.codepot.ui.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.konradkrakowiak.codepot.BuildConfig;
import com.konradkrakowiak.codepot.R;
import com.konradkrakowiak.codepot.di.qualifier.ViewQualifier;
import com.konradkrakowiak.codepot.model.Links;
import com.konradkrakowiak.codepot.model.Mentor;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;
import javax.inject.Provider;


public class MentorsAdapter extends RecyclerView.Adapter<MentorsAdapter.ViewHolder> {

    //TODO inject this
    List<Mentor> mentors;

    //TODO inject this
    Provider<MentorsAdapter.ViewHolder> provider;

    //TODO inject and use annotation named
    UnsupportedOperationException unsupportedOperationException;

    OnLinkButtonClickListener onLinkButtonClickListener = OnLinkButtonClickListener.NULL;

    //TODO create provider and inject this
    MentorsAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final ViewHolder result = provider.get();
        for (View view : result.buttons) {
            view.setOnClickListener(v -> {
                final Mentor mentor = mentors.get(result.getAdapterPosition());
                switch (v.getId()) {
                    case R.id.mentor_item_stackoverflow:
                        onLinkButtonClickListener.onLinkButtonClick(Links.STACK_OVER_FLOW + mentor.getStackoverflowId());
                        return;
                    case R.id.mentor_item_twitter:
                        onLinkButtonClickListener.onLinkButtonClick(Links.TWITTER + mentor.getTwitterUsername());
                        return;
                    case R.id.mentor_item_linked_in:
                        onLinkButtonClickListener.onLinkButtonClick(mentor.getLinkedinProfileURL());
                        return;
                    case R.id.mentor_item_google_plus:
                        onLinkButtonClickListener.onLinkButtonClick(Links.GIT_HUB + mentor.getGithubUsername());
                        return;
                    case R.id.mentor_item_github:
                        onLinkButtonClickListener.onLinkButtonClick(Links.GOOGLE_PLUS + mentor.getGoogleplusHandler());
                        return;
                    default:
                        throw unsupportedOperationException;
                }
            });
        }
        return result;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(mentors.get(i));
    }

    @Override
    public int getItemCount() {
        return mentors.size();
    }

    public void setOnLinkButtonClickListener(OnLinkButtonClickListener onLinkButtonClickListener) {
        this.onLinkButtonClickListener = onLinkButtonClickListener == null ? OnLinkButtonClickListener.NULL : onLinkButtonClickListener;
    }

    public void clearData() {
        this.mentors.clear();
    }

    public void add(Mentor mentor) {
        this.mentors.add(mentor);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //TODO inject this object
        ImageLoader imageLoader;

        //TODO inject this object
        StringBuilder sb;

        //TODO bind this R.id.mentor_item_view)
        ImageView image;

        //TODO bind this (R.id.mentor_item_name)
        TextView name;

        //TODO bind this R.id.mentor_item_tag_lines)
        TextView tagLines;

        //TODO bind this R.mipmap.ic_launcher)
        Drawable codePot;

        /*TODO bind this
                R.id.mentor_item_stackoverflow,
                R.id.mentor_item_twitter,
                R.id.mentor_item_linked_in,
                R.id.mentor_item_google_plus,
                R.id.mentor_item_github,
        })*/
        ImageButton[] buttons;

        //TODO bind this R.id.mentor_item_bio)
        TextView bio;

        //TODO inject and create provider
        public ViewHolder(@ViewQualifier.MentorItemView View view) {
            super(view);
            //TODO bind this object
        }


        void bind(Mentor mentor) {
            sb.setLength(0);
            image.setImageDrawable(codePot);
            imageLoader.displayImage(BuildConfig.IMAGE_URL + mentor.getPictureURL(), image);
            name.setText(sb
                    .append(mentor.getFirstName())
                    .append(" ")
                    .append(mentor.getLastName())
                    .toString());
            tagLines.setText(mentor.getTagline());
            bio.setText(mentor.getBioInMd());
            buttons[0].setVisibility(mentor.getStackoverflowId() == null ? View.GONE : View.VISIBLE);
            buttons[1].setVisibility(mentor.getTwitterUsername() == null ? View.GONE : View.VISIBLE);
            buttons[2].setVisibility(mentor.getLinkedinProfileURL() == null ? View.GONE : View.VISIBLE);
            buttons[3].setVisibility(mentor.getGoogleplusHandler() == null ? View.GONE : View.VISIBLE);
            buttons[4].setVisibility(mentor.getGithubUsername() == null ? View.GONE : View.VISIBLE);
        }
    }

    public interface OnLinkButtonClickListener {

        OnLinkButtonClickListener NULL = link -> {/*do nothing*/};

        void onLinkButtonClick(String link);
    }
}
