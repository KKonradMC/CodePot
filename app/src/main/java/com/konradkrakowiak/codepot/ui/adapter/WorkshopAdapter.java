package com.konradkrakowiak.codepot.ui.adapter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.konradkrakowiak.codepot.R;
import com.konradkrakowiak.codepot.di.qualifier.ViewQualifier;
import com.konradkrakowiak.codepot.model.Mentor;
import com.konradkrakowiak.codepot.model.TimeSlots;
import com.konradkrakowiak.codepot.model.Workshop;
import com.konradkrakowiak.codepot.model.Workshops;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;


public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.ViewHolder> {

    private static final String WORKSHOPS = "WORKSHOPS";

    @Inject
    List<Workshop> workshops;

    OnWorkshopItemClickListener onWorkshopItemClickListener = OnWorkshopItemClickListener.NULL;

    @Inject
    Provider<WorkshopAdapter.ViewHolder> provider;

    @Inject
    WorkshopAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final ViewHolder result = provider.get();
        result.itemView.setOnClickListener(v -> onWorkshopItemClickListener.onWorkshopItemClick(workshops.get(result.getAdapterPosition())));
        return result;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(workshops.get(i));
    }

    @Override
    public int getItemCount() {
        return workshops.size();
    }

    public Workshop getItemAt(int position) {
        return workshops.get(position);
    }

    public void setOnWorkshopItemClickListener(OnWorkshopItemClickListener onWorkshopItemClickListener) {
        this.onWorkshopItemClickListener = onWorkshopItemClickListener != null ? onWorkshopItemClickListener : OnWorkshopItemClickListener.NULL;
    }

    public void setWorkshopsList(Workshops workshops) {
        this.workshops.clear();
        for (Workshop workshop : workshops) {
            this.workshops.add(workshop);
        }
        notifyDataSetChanged();
    }

    public void onSaveInstanceState(Bundle saveInstanceState) {
        //TODO put workshop list in bundle

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //TODO read workshop list from bundle
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.workshop_item_mentor)
        TextView mentor;

        //TODO Bind this object R.id.workshop_item_title
        TextView title;

        //TODO Bind this object  R.id.workshop_item_room)
        TextView room;

        //TODO Bind this object  R.id.workshop_free_set)
        TextView freeSet;


        //TODO Bind this string  R.string.room)
        String roomString;

        //TODO Bind this string R.string.free_spaces)
        String freeSpaces;

        @Inject
        Provider<StringBuilder> stringBuilderProvider;

        @Inject
        public ViewHolder(@ViewQualifier.WorkshopItemView View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        void bind(Workshop workshop) {
            mentor.setText(createMentorsText(workshop));
//            title.setText(workshop.getTitle());
//            room.setText(String.format(roomString, createRoomText(workshop)));
//            freeSet.setText(String.format(freeSpaces, workshop.getFreeSeats()));
        }

        String createMentorsText(Workshop workshop) {
            final StringBuilder stringBuilder = stringBuilderProvider.get();
            final int mentorCount = workshop.countMentors();
            for (int index = 0; index < mentorCount; index++) {
                final Mentor mentor = workshop.getMentorAt(index);
                stringBuilder.append(mentor.getFirstName()).append(" ").append(mentor.getLastName());
                if (index != mentorCount - 1) {
                    stringBuilder.append("\n");
                }
            }
            return stringBuilder.toString();
        }

        String createRoomText(Workshop workshop) {
            final StringBuilder stringBuilder = stringBuilderProvider.get();
            final int timeSlotsCount = workshop.countTimeSlots();
            for (int index = 0; index < timeSlotsCount; index++) {
                final TimeSlots timeSlot = workshop.getTimeSlotsAt(index);
                stringBuilder.append(timeSlot.getRoom());
                if (index != timeSlotsCount - 1) {
                    stringBuilder.append(", ");
                }
            }
            return stringBuilder.toString();
        }
    }

    public interface OnWorkshopItemClickListener {

        OnWorkshopItemClickListener NULL = workshop -> {/*Do nothing*/};

        void onWorkshopItemClick(Workshop workshop);
    }
}
