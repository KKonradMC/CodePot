package com.konradkrakowiak.codepot.model;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.parceler.Parcel;

@Parcel
public class Mentor {

    private interface Metadata {

        String STACKOVERFLOW_ID = "stackoverflowId";
        String LINKEDIN_PROFILE_URL = "linkedinProfileURL";
        String PICTURE_URL = "pictureURL";
        String LAST_NAME = "lastName";
        String TWITTER_USERNAME = "twitterUsername";
        String GITHUB_USERNAME = "githubUsername";
        String FIRST_NAME = "firstName";
        String GOOGLEPLUS_HANDLER = "googleplusHandler";
        String TAG_LINE = "tagline";
        String WEBSITE_URL = "websiteURL";
        String BIO_IN_MD = "bioInMd";
        String ID = "id";
    }

    @Getter
    @SerializedName(Metadata.STACKOVERFLOW_ID)
    String stackoverflowId;

    @Getter
    @SerializedName(Metadata.LINKEDIN_PROFILE_URL)
    String linkedinProfileURL;

    @Getter
    @SerializedName(Metadata.PICTURE_URL)
    String pictureURL;

    @Getter
    @SerializedName(Metadata.LAST_NAME)
    String lastName;

    @Getter
    @SerializedName(Metadata.TWITTER_USERNAME)
    String twitterUsername;

    @Getter
    @SerializedName(Metadata.GITHUB_USERNAME)
    String githubUsername;

    @Getter
    @SerializedName(Metadata.FIRST_NAME)
    String firstName;

    @Getter
    @SerializedName(Metadata.GOOGLEPLUS_HANDLER)
    String googleplusHandler;

    @Getter
    @SerializedName(Metadata.TAG_LINE)
    String tagline;

    @Getter
    @SerializedName(Metadata.WEBSITE_URL)
    String websiteURL;

    @Getter
    @SerializedName(Metadata.BIO_IN_MD)
    String bioInMd;

    @Getter
    @SerializedName(Metadata.ID)
    String id;
}
