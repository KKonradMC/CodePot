package com.konradkrakowiak.codepot.di;


import android.content.Context;
import com.konradkrakowiak.codepot.BuildConfig;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
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
        return new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true);
    }

    @Provides
    @Singleton
    DisplayImageOptions provideDefaultDisplayImageOptions(DisplayImageOptions.Builder builder) {
        return builder.build();
    }

    @Provides
    MemoryCache provideMemoryCache() {
        return new LruMemoryCache(Metadata.MEMORY_CACHE_SIZE);
    }

    @Provides
    DiskCache provideDiskCache() {
        return new UnlimitedDiskCache(context.getCacheDir());
    }

    @Provides
    @Singleton
    ImageLoaderConfiguration provideImageLoaderConfigurationWithMemory(DisplayImageOptions displayImageOptions, MemoryCache memoryCache, DiskCache diskCache) {
        final ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(displayImageOptions)
                .memoryCache(memoryCache)
                .memoryCacheSize(Metadata.MEMORY_CACHE_SIZE)
                .diskCache(diskCache)
                .diskCacheSize(Metadata.DISK_CACHE_SIZE)
                .diskCacheFileCount(Metadata.DISK_CACHE_FILE_COUNT);
        if (BuildConfig.DEBUG) {
            builder.writeDebugLogs();
        }
        return builder.build();
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(ImageLoaderConfiguration imageLoaderConfiguration) {
        final ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(imageLoaderConfiguration);
        return imageLoader;
    }
}
