package com.lans.instagram_clone.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.lans.instagram_clone.common.CONSTANTS
import com.lans.instagram_clone.domain.model.User
import com.lans.instagram_clone.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore
): IUserRepository {
    override fun createUser(user: User): Task<Void> {
        return firebaseFirestore
            .collection(CONSTANTS.USER_COLLECTION)
            .document(user.id)
            .set(user)
    }

    override fun getUser(userId: String): Task<DocumentSnapshot> {
        return firebaseFirestore
            .document(userId)
            .get()
    }
}