package org.lafzi.kotlinguideoffline.databases

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper
import org.lafzi.kotlinguideoffline.KotlinGuideApplication

/**
 * Created by alfat on 20/05/17.
 */

object DBHelper {
    val DB_NAME = "kotlin_guide_offline.db"
    val VERSION = 1
    val instance: SQLiteAssetHelper = SQLiteAssetHelper(
            KotlinGuideApplication.getKotlinGuideContext(),
            DB_NAME,
            null,
            VERSION)
}