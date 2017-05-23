package org.lafzi.kotlinguideoffline.domains

import android.provider.BaseColumns

/**
 * Created by alfat on 20/05/17.
 */
class Pages(title: String, content: String){
    companion object {
        const val TABLE_NAME = "pages"
        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_CONTENT = "content"
    }

    private var title: String = ""
    private var content: String = ""

    init {
        this.title = title
        this.content = content
    }

    fun getTitle(): String {
        return title
    }

    fun getContent(): String {
        return content
    }
}