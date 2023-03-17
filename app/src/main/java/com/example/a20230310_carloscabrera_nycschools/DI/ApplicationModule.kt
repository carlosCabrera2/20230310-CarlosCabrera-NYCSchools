package com.example.a20230310_carloscabrera_nycschools.DI

import android.app.Application
import com.example.a20230310_carloscabrera_nycschools.Rest.NYSchoolsRepository
import com.example.a20230310_carloscabrera_nycschools.Rest.NYSchoolsRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
class NySchoolsApp: Application()