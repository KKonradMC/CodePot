package com.konradkrakowiak.codepote.model;


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

    String stackoverflowId;

    String linkedinProfileURL;

    String pictureURL;

    String lastName;

    String twitterUsername;

    String githubUsername;

    String firstName;

    String googleplusHandler;

    String tagline;

    String websiteURL;

    String bioInMd;

    String id;
}
