package com.lans.instagram_clone.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.lans.instagram_clone.data.interactor.CreateUserInteractor
import com.lans.instagram_clone.data.interactor.IsAuthenticatedInteractor
import com.lans.instagram_clone.data.interactor.LoginWithEmailInteractor
import com.lans.instagram_clone.data.interactor.RegisterInteractor
import com.lans.instagram_clone.data.interactor.validator.ValidateEmailInteractor
import com.lans.instagram_clone.data.interactor.validator.ValidateFullnameInteractor
import com.lans.instagram_clone.data.interactor.validator.ValidatePasswordInteractor
import com.lans.instagram_clone.data.interactor.validator.ValidateUsernameInteractor
import com.lans.instagram_clone.data.interactor.validator.ValidatorInteractor
import com.lans.instagram_clone.data.repository.AuthRepository
import com.lans.instagram_clone.data.repository.DataStoreRepository
import com.lans.instagram_clone.data.repository.UserRepository
import com.lans.instagram_clone.data.source.local.DataStoreManager
import com.lans.instagram_clone.domain.repository.IAuthRepository
import com.lans.instagram_clone.domain.repository.IDataStoreRepository
import com.lans.instagram_clone.domain.repository.IUserRepository
import com.lans.instagram_clone.domain.usecase.CreateUserUseCase
import com.lans.instagram_clone.domain.usecase.IsAuthenticatedUseCase
import com.lans.instagram_clone.domain.usecase.LoginWithEmailUseCase
import com.lans.instagram_clone.domain.usecase.RegisterUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidateEmailUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidateFullnameUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidatePasswordUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidateUsernameUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidatorUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStoreManager {
        return DataStoreManager(context)
    }

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        dataStoreManager: DataStoreManager
    ): IDataStoreRepository {
        return DataStoreRepository(
            dataStoreManager
        )
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth
    ): IAuthRepository {
        return AuthRepository(
            firebaseAuth
        )
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        firebaseFirestore: FirebaseFirestore
    ): IUserRepository {
        return UserRepository(
            firebaseFirestore
        )
    }

    @Provides
    @Singleton
    fun provideIsAuthenticatedUseCase(
        authRepository: IAuthRepository
    ): IsAuthenticatedUseCase {
        return IsAuthenticatedInteractor(
            authRepository
        )
    }

    @Provides
    @Singleton
    fun provideLoginWithEmailUseCase(
        authRepository: IAuthRepository
    ): LoginWithEmailUseCase {
        return LoginWithEmailInteractor(
            authRepository
        )
    }

    @Provides
    @Singleton
    fun provideRegisterUseCase(
        authRepository: IAuthRepository
    ): RegisterUseCase {
        return RegisterInteractor(
            authRepository
        )
    }

    @Provides
    @Singleton
    fun provideCreateUserUseCase(
        userRepository: IUserRepository
    ): CreateUserUseCase {
        return CreateUserInteractor(
            userRepository
        )
    }

    @Provides
    @Singleton
    fun provideValidatorUseCase(
        validateEmailUseCase: ValidateEmailUseCase,
        validateFullnameUseCase: ValidateFullnameUseCase,
        validateUsernameUseCase: ValidateUsernameUseCase,
        validatePasswordUseCase: ValidatePasswordUseCase,
    ): ValidatorUseCase {
        return ValidatorInteractor(
            validateEmailUseCase,
            validateFullnameUseCase,
            validateUsernameUseCase,
            validatePasswordUseCase
        )
    }

    @Provides
    @Singleton
    fun provideValidateEmailUseCase(): ValidateEmailUseCase {
        return ValidateEmailInteractor()
    }

    @Provides
    @Singleton
    fun provideValidateFullnameUseCase(): ValidateFullnameUseCase {
        return ValidateFullnameInteractor()
    }

    @Provides
    @Singleton
    fun provideValidateUsernameUseCase(): ValidateUsernameUseCase {
        return ValidateUsernameInteractor()
    }

    @Provides
    @Singleton
    fun provideValidatePasswordUseCase(): ValidatePasswordUseCase {
        return ValidatePasswordInteractor()
    }
}