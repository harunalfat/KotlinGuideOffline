package org.lafzi.kotlinguideoffline.tasks

import android.os.AsyncTask
import android.view.View
import android.widget.ExpandableListView
import br.tiagohm.markdownview.MarkdownView
import org.lafzi.kotlinguideoffline.daos.PagesDao
import org.lafzi.kotlinguideoffline.databases.DBHelper
import org.lafzi.kotlinguideoffline.domains.Pages

/**
 * Created by alfat on 23/05/17.
 */

class RenderMarkdownTask(private val markdownView: MarkdownView?,
                         private val expandableListView: ExpandableListView?,
                         private val title: String) : AsyncTask<Void, Void, String>() {

    override fun doInBackground(vararg params: Void?): String {
        val page: Pages? = PagesDao
                .getInstance(DBHelper.instance.readableDatabase)
                .getPage(title)

        return page!!.getContent()
    }

    override fun onPostExecute(result: String) {
        markdownView!!.loadMarkdown(result)
        expandableListView!!.visibility = View.GONE
        markdownView.visibility = View.VISIBLE
    }

}