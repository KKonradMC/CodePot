package com.konradkrakowiak.codepot.model;

import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class Workshops implements Iterable<Workshop> {

    private interface Metadata {

        String WORKSHOP = "workshops";
    }

    @SerializedName(Metadata.WORKSHOP)
    List<Workshop> workshopList;

    @Nullable
    public Workshop get(int index) {
        if (workshopList == null) {
            return null;
        }
        return workshopList.get(index);
    }

    @Override
    public Iterator<Workshop> iterator() {
        if (workshopList == null) {
            return Collections.emptyIterator();
        }
        return workshopList.iterator();
    }
}
