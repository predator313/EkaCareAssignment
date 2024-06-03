package `in`.janitri.ekacareassignment.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.janitri.ekacareassignment.data.UserDao
import `in`.janitri.ekacareassignment.data.UserDataBase
import `in`.janitri.ekacareassignment.domain.repository.Repository
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)  //here SingletonComponent signify the life cycle (application)
object UserModule {

    @Singleton  //here Singleton represent the scope /instance
    @Provides
    fun provideUserDatabase(app:Application):UserDataBase{
        return Room.databaseBuilder(app,
            UserDataBase::class.java,"UserDatabase")
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(userDataBase: UserDataBase):UserDao{
        return userDataBase.userDao()
    }

    @Singleton
    @Provides
    fun provideRepository(userDao: UserDao): Repository {
        return Repository(userDao)
    }
}