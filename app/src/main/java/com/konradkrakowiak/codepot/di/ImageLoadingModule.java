package com.konradkrakowiak.codepot.di;


import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
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

    @Provides
    DisplayImageOptions.Builder provideDefaultDisplayImageOptionsBuilder() {
        return null; //TODO set cacheInMemory and cacheOnDisk
    }

    @Provides
    @Singleton
    DisplayImageOptions provideDefaultDisplayImageOptions(DisplayImageOptions.Builder builder) {
        return builder.build();
    }

    @Provides
    MemoryCache provideMemoryCache() {
        return null; //TODO return MemoryCache - it can be LruMemoryCache;
    }

   @Provides
    DiskCache provideDiskCache() {
        return null; //TODO return DiskCache - it can be UnlimitedDiskCache;
    }

    @Provides
    @Singleton
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

    @Provides
    @Singleton
    ImageLoader provideImageLoader(ImageLoaderConfiguration imageLoaderConfiguration) {
        //TODO create and init ImageLoader
        return null;
    }
}
