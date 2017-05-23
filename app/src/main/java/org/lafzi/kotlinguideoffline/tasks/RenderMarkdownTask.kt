package org.lafzi.kotlinguideoffline.tasks

import android.os.AsyncTask
import android.webkit.WebView
import com.vladsch.flexmark.ast.Node
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import org.lafzi.kotlinguideoffline.daos.PagesDao
import org.lafzi.kotlinguideoffline.databases.DBHelper
import org.lafzi.kotlinguideoffline.domains.Pages

/**
 * Created by alfat on 23/05/17.
 */

class RenderMarkdownTask(private val webView: WebView?, private val title: String) : AsyncTask<Void, Void, String>() {

    override fun doInBackground(vararg params: Void?): String {
        val page: Pages? = PagesDao
                .getInstance(DBHelper.instance.readableDatabase)
                .getPage(title)

        val node: Node = Parser.builder().build().parse(page!!.getContent())
        return HtmlRenderer.builder().build().render(node)
    }

    override fun onPostExecute(result: String) {
        webView!!.loadData(result, "text/html", "UTF-8")
    }

}