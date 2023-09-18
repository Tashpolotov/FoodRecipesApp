package com.example.foodrecipesapp.module

import android.app.Application
import android.content.Context
import com.example.data.FoodRepositoryMock
import com.example.domain.repository.FoodRepository
import com.example.domain.usecase.FoodUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application):Context{
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideRepository(context: Context):FoodRepository{
        return FoodRepositoryMock(context)
    }

    fun provideUseCase(repository: FoodRepository):FoodUseCase{
        return FoodUseCase(repository)
    }
}