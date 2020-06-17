package ru.diitcenter.gooddeeds.data.prefs

import android.content.SharedPreferences
import android.graphics.Bitmap
import java.util.*

class PrefsHelper(private val sharedPrefs: SharedPreferences) {

    private val PREF_ALL_GOOD_DEEDS = "good deeds"
    private val PREF_GOOD_DEEDS_THIS_DAY = "good deeds d"
    private val PREF_BAD_DEEDS_THIS_DAY= "bad deeds d"
    private val PREF_DAY= "d"
    private val PREF_PHONE = "phone"
    private val PREF_TOKEN = "token"
    private val PREF_FIRST_ENTER = "first"
    private val PREF_NAME = "name"
    private val PREF_SURNAME = "surname"
    private val PREF_AUTORIZED = "autorized"
    private val PREF_DAY_TARGET = "target"
    private val PREF_USER_PHOTO = "photo"
    private val PREF_USER_LEVEL = "user_level"



    fun getTarget(): Int? = sharedPrefs.getInt(PREF_DAY_TARGET, 0)

    fun saveTarget(deedsCount: Int) = sharedPrefs.edit()
        .putInt(PREF_DAY_TARGET, deedsCount)
        .apply()

    fun clearTarget() = sharedPrefs.edit()
        .remove(PREF_DAY_TARGET)
        .apply()



    fun getUserLevel(): Int? = sharedPrefs.getInt(PREF_USER_LEVEL, 0)

    fun saveUserLevel(deedsCount: Int) = sharedPrefs.edit()
        .putInt(PREF_USER_LEVEL, deedsCount)
        .apply()

    fun clearUserLevel() = sharedPrefs.edit()
        .remove(PREF_USER_LEVEL)
        .apply()



    fun getPhoto(): String? = sharedPrefs.getString(PREF_USER_PHOTO, "dsg")

    fun savePhoto(photo: String?) = sharedPrefs.edit()
        .putString(PREF_USER_PHOTO, photo)
        .apply()

    fun clearPhoto() = sharedPrefs.edit()
        .remove(PREF_USER_PHOTO)
        .apply()


    fun getAllGoodDeeds(): Int? = sharedPrefs.getInt(PREF_ALL_GOOD_DEEDS, 0)

    fun saveAllGoodDeeds(deedsCount: Int) = sharedPrefs.edit()
        .putInt(PREF_ALL_GOOD_DEEDS, deedsCount)
        .apply()

    fun clearAllGoodDeeds() = sharedPrefs.edit()
        .remove(PREF_ALL_GOOD_DEEDS)
        .apply()

    fun getName(): String? = sharedPrefs.getString(PREF_NAME,"")

    fun saveName(name: String) = sharedPrefs.edit()
        .putString(PREF_NAME,name)
        .apply()

    fun clearName() = sharedPrefs.edit()
        .remove(PREF_NAME)
        .apply()


    fun getSurName(): String? = sharedPrefs.getString(PREF_SURNAME,"")

    fun saveSurName(name: String) = sharedPrefs.edit()
        .putString(PREF_SURNAME,name)
        .apply()

    fun clearSurName() = sharedPrefs.edit()
        .remove(PREF_SURNAME)
        .apply()


    fun getDay(): String? = sharedPrefs.getString(PREF_DAY, "")

    fun saveDay(deedsCount: String) = sharedPrefs.edit()
        .putString(PREF_DAY, deedsCount)
        .apply()

    fun clearDay() = sharedPrefs.edit()
        .remove(PREF_DAY)
        .apply()

    fun getGoodDeeds(): Int? = sharedPrefs.getInt(PREF_GOOD_DEEDS_THIS_DAY, 0)

    fun saveGoodDeeds(deedsCount: Int) = sharedPrefs.edit()
        .putInt(PREF_GOOD_DEEDS_THIS_DAY, deedsCount)
        .apply()

    fun clearGoodDeeds() = sharedPrefs.edit()
        .remove(PREF_GOOD_DEEDS_THIS_DAY)
        .apply()


    fun getBadDeeds(): Int? = sharedPrefs.getInt(PREF_BAD_DEEDS_THIS_DAY, 0)

    fun saveBadDeeds(deedsCount: Int) = sharedPrefs.edit()
        .putInt(PREF_BAD_DEEDS_THIS_DAY, deedsCount)
        .apply()

    fun clearBadDeeds() = sharedPrefs.edit()
        .remove(PREF_BAD_DEEDS_THIS_DAY)
        .apply()


    fun getToken(): String? = sharedPrefs.getString(PREF_TOKEN, null)

    fun saveToken(token: String) = sharedPrefs.edit()
        .putString(PREF_TOKEN, token)
        .apply()

    fun clearToken() = sharedPrefs.edit()
    .remove(PREF_TOKEN)
    .apply()


    fun getFirstEnter(): String? = sharedPrefs.getString(PREF_FIRST_ENTER, null)

    fun saveFirstEnter(token: String) = sharedPrefs.edit()
        .putString(PREF_FIRST_ENTER, token)
        .apply()

    fun clearFirstEnter() = sharedPrefs.edit()
        .remove(PREF_FIRST_ENTER)
        .apply()


    fun getAutorized(): Boolean? = sharedPrefs.getBoolean(PREF_AUTORIZED, false)

    fun saveAutorized(aut: Boolean) = sharedPrefs.edit()
        .putBoolean(PREF_AUTORIZED, aut)
        .apply()

    fun clearAutorized() = sharedPrefs.edit()
        .remove(PREF_AUTORIZED)
        .apply()
}