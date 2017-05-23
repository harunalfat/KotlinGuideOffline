package org.lafzi.kotlinguideoffline

import android.app.Application
import android.content.Context

/**
 * Created by alfat on 23/05/17.
 */
class KotlinGuideApplication : Application() {

    companion object {
        private var context: Context? = null

        fun getKotlinGuideContext(): Context? {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}