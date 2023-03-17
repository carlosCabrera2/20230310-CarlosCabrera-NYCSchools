package com.example.a20230310_carloscabrera_nycschools.DI

import com.example.a20230310_carloscabrera_nycschools.Rest.NYSchoolsRepository
import com.example.a20230310_carloscabrera_nycschools.Rest.NYSchoolsRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun NYSchoolsRepository(
        nySchoolsRepositoryImp: NYSchoolsRepositoryImp
    ):NYSchoolsRepository

}