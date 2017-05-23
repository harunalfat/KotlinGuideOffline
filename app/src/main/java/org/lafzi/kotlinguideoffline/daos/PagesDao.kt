package org.lafzi.kotlinguideoffline.daos

import android.content.Context
import org.lafzi.kotlinguideoffline.domains.Pages

/**
 * Created by alfat on 20/05/17.
 */

class PagesDao(context: Context) {

    private var context: Context? = null

    init {
        this.context = context
    }

    fun getPage(title: String): Pages {
        val projection = arrayOf(
                Pages.COLUMN_ID,
                Pages.COLUMN_TITLE,
                Pages.COLUMN_CONTENT
        )

        val selection = "${Pages.COLUMN_TITLE} = ?"
    }

    companion object {
        fun getInstance(context: Context): PagesDao {
            return PagesDao(context)
        }
    }

}