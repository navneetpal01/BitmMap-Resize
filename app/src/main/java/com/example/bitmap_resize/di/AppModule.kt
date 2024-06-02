package com.example.bitmap_resize.di

import android.content.Context
import com.example.bitmap_resize.data.repository.BitmapRepositoryImpl
import com.example.bitmap_resize.domain.repository.BitmapRepository
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
    fun providesBitmapRepository(@ApplicationContext context : Context) : BitmapRepository{
        return BitmapRepositoryImpl(context)
    }





}