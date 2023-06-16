package com.dicoding.md_herbalens.injection

import com.dicoding.md_herbalens.data.HerbalensRepository

object RepositoryInjection {
    fun provideRepository(): HerbalensRepository {
        return HerbalensRepository.getInstance()
    }
}