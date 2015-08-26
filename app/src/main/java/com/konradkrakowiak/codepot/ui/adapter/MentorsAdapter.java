package com.konradkrakowiak.codepot.ui.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.ButterKnife;
import com.konradkrakowiak.codepot.BuildConfig;
import com.konradkrakowiak.codepot.R;
import com.konradkrakowiak.codepot.di.qualifier.ExceptionType;
import com.konradkrakowiak.codepot.di.qualifier.ViewQualifier;
import com.konradkrakowiak.codepot.model.Links;
import com.konradkrakowiak.codepot.model.Mentor;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import lombok.Setter;


public class MentorsAdapter extends RecyclerView.Adapter<MentorsAdapter.ViewHolder> {

    @Inject
    List<Mentor> mentors;

    @Inject
    Provider<MentorsAdapter.ViewHolder> provider;

    @Named(ExceptionType.UNSUPPORTED_BUTTON_ACTION)
    @Inject
    UnsupportedOperationException unsupportedOperationException;

    @Setter
    OnLinkButtonClickListener onLinkButtonClickListener = OnLinkButtonClickListener.NULL;

    @Inject
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
                    case R.id.mentor_item_github:
                        onLinkButtonClickListener.onLinkButtonClick(Links.GIT_HUB + mentor.getGithubUsername());
                        return;
                    case R.id.mentor_item_google_plus:
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


    public void clearData() {
        this.mentors.clear();
    }

    public void add(Mentor mentor) {
        this.mentors.add(mentor);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Inject
        ImageLoader imageLoader;

        @Inject
        StringBuilder sb;

        @Bind(R.id.mentor_item_view)
        ImageView image;

        @Bind(R.id.mentor_item_name)
        TextView name;

        @Bind(R.id.mentor_item_tag_lines)
        TextView tagLines;

        @BindDrawable(R.mipmap.ic_launcher)
        Drawable codePot;

        @Bind({
                R.id.mentor_item_stackoverflow,
                R.id.mentor_item_twitter,
                R.id.mentor_item_linked_in,
                R.id.mentor_item_google_plus,
                R.id.mentor_item_github,
        })
        ImageButton[] buttons;

        @Bind(R.id.mentor_item_bio)
        TextView bio;

        @Inject
        public ViewHolder(@ViewQualifier.MentorItemView View view) {
            super(view);
            ButterKnife.bind(this, itemView);
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
