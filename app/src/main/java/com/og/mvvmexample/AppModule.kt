package com.og.mvvmexample

import dagger.Module
import dagger.Provides

@Module
class AppModule {
    //dont try to provide while thinking about polymorph

    @Provides
    fun provideExampleModel(): ExampleModel {
        return ExampleModel()
    }

    @Provides
    fun provideExampleRepository(exampleModel: ExampleModel): ExampleRepository {
        return ExampleRepository(exampleModel)
    }

    @Provides
    fun provideExampleViewModel(exampleRepository: ExampleRepository): ExampleViewModel {
        return ExampleViewModel(exampleRepository)
    }

}