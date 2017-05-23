package org.lafzi.kotlinguideoffline.daos

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import org.lafzi.kotlinguideoffline.domains.Pages

/**
 * Created by alfat on 20/05/17.
 */

class PagesDao private constructor(private var db: SQLiteDatabase)  {

    fun getPage(title: String): Pages? {
        val projection = arrayOf(
                Pages._ID,
                Pages.COLUMN_TITLE,
                Pages.COLUMN_CONTENT
        )

        val selection = "${Pages.COLUMN_TITLE} = ?"
        val selectionArgs = arrayOf(title)

        val cursor: Cursor = db.query(
                Pages.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        )

        if (cursor.moveToNext())
            cursor.use { cursor ->
                return readPageFromCursor(cursor)
            }

        return null
    }

    private fun readPageFromCursor(cursor: Cursor): Pages {
        val title = cursor
                .getString(cursor
                        .getColumnIndexOrThrow(Pages.COLUMN_TITLE))

        val content = cursor
                .getString(cursor
                        .getColumnIndexOrThrow(Pages.COLUMN_CONTENT))

        return Pages(title, content)
    }

    companion object {
        fun getInstance(db: SQLiteDatabase): PagesDao {
            return PagesDao(db)
        }
    }

}