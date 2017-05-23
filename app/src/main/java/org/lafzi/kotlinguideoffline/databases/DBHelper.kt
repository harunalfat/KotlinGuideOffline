package org.lafzi.kotlinguideoffline.databases

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

/**
 * Created by alfat on 20/05/17.
 */

class DBHelper(context: Context) : SQLiteAssetHelper(context, DB_NAME, null, VERSION) {
    companion object {
        const val DB_NAME = "kotlin_guide_offline.db"
        const val VERSION = 1
    }

    init {
        setForcedUpgrade()
    }
}