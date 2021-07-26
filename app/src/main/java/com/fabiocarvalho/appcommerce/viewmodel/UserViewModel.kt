package com.fabiocarvalho.appcommerce.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.preference.PreferenceManager
import com.fabiocarvalho.appcommerce.models.User
import com.fabiocarvalho.appcommerce.models.UserAddress
import com.fabiocarvalho.appcommerce.models.UserWithAddresses
import com.fabiocarvalho.appcommerce.repository.UsersRespository

class UserViewModel (application: Application) : AndroidViewModel(application) {

    private val usersRepository = UsersRespository(getApplication())

    fun createUser(user: User) = usersRepository.createUser(user)

    fun update(userWithAddresses: UserWithAddresses) = usersRepository.update(userWithAddresses)

    fun login(email: String, password: String) : LiveData<User> = usersRepository.login(email, password)

    fun logout() = PreferenceManager.getDefaultSharedPreferences(getApplication()).let{
        it.edit().remove(USER_ID).apply()
    }

    //TODO colocado o toString abaixo
    fun isLogged(): LiveData<UserWithAddresses> = PreferenceManager.getDefaultSharedPreferences(getApplication()).let {
        val id = it.getString(USER_ID, null)
        if (id.isNullOrEmpty()){
            return MutableLiveData(null)
        }
        return usersRepository.load(id)
    }

    fun resetPassword(email: String) = usersRepository.resetPassword(email)

    companion object{
        val USER_ID = "USER_ID"

    }

}