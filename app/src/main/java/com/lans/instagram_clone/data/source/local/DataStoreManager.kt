package com.lans.instagram_clone.data.source.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManager @Inject constructor(private val context: Context) {
    companion object {
        val USER_ID = stringPreferencesKey("USER_ID")
        private const val DATASTORE = "igclone"
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE)

    suspend fun <T> storeData(key: Preferences.Key<T>, value: T) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun clear() {
        context.dataStore.edit { preferences ->
            preferences.remove(USER_ID)
        }
    }

    val userId: Flow<String>
        get() = context.dataStore.data.map { preferences ->
            preferences[USER_ID] ?: ""
        }
}