package `in`.janitri.ekacareassignment.di

import android.app.Application
import androidx.room.Room
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import `in`.janitri.ekacareassignment.db.UserDao
import `in`.janitri.ekacareassignment.db.UserDataBase
import `in`.janitri.ekacareassignment.repository.Repository
import javax.inject.Singleton

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
    fun provideRepository(userDao: UserDao):Repository{
        return Repository(userDao)
    }
}