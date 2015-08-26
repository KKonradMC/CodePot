package com.konradkrakowiak.codepot.di;


import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

//TODO create module
public class ImageLoadingModule {

    private interface Metadata {

        int ONE_MB = 1024 * 1024;
        int MEMORY_CACHE_SIZE = 2 * ONE_MB;
        int DISK_CACHE_SIZE = 50 * ONE_MB;
        int DISK_CACHE_FILE_COUNT = 100;
    }

    private Context context;

    public ImageLoadingModule(Context context) {
        this.context = context;
    }

    //TODO provider
    DisplayImageOptions.Builder provideDefaultDisplayImageOptionsBuilder() {
        return null; //TODO set cacheInMemory and cacheOnDisk
    }

    //TODO provider and singleton
    DisplayImageOptions provideDefaultDisplayImageOptions(DisplayImageOptions.Builder builder) {
        return builder.build();
    }

    //TODO provider
    MemoryCache provideMemoryCache() {
        return null; //TODO return MemoryCache - it can be LruMemoryCache;
    }

    //TODO provider
    DiskCache provideDiskCache() {
        return null; //TODO return DiskCache - it can be UnlimitedDiskCache;
    }

    //TODO provider and singleton
    ImageLoaderConfiguration provideImageLoaderConfigurationWithMemory(DisplayImageOptions displayImageOptions, MemoryCache memoryCache, DiskCache diskCache) {
    /* TODO create ImageLoaderConfiguration via builder
                set defaultDisplayImageOptions
                set memoryCache
                set memoryCacheSize
                set diskCache
                set diskCacheSize
                set diskCacheFileCount
         set writeDebugLogs for debug */

        return null;
    }

    //TODO provider and singleton
    ImageLoader provideImageLoader(ImageLoaderConfiguration imageLoaderConfiguration) {
        //TODO create and init ImageLoader
        return null;
    }
}
