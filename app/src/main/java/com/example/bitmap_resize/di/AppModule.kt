package com.example.bitmap_resize.di

import android.app.Application
import android.content.Context
import com.example.bitmap_resize.data.repository.CustomSizeRepositoryImpl
import com.example.bitmap_resize.data.repository.MediaStoreRepositoryImpl
import com.example.bitmap_resize.domain.repository.CustomSizeRepository
import com.example.bitmap_resize.domain.repository.MediaStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule{


    @Provides
    @Singleton
    fun providesBitmapRepository(@ApplicationContext context : Context) : CustomSizeRepository{
        return CustomSizeRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun providesMediaStoreRepository(application: Application) : MediaStoreRepository{
        return MediaStoreRepositoryImpl(application)
    }


}