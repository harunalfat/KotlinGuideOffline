package org.lafzi.kotlinguideoffline.activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.ExpandableListView
import br.tiagohm.markdownview.MarkdownView
import org.lafzi.kotlinguideoffline.R
import org.lafzi.kotlinguideoffline.adapters.SitemapAdapter
import org.lafzi.kotlinguideoffline.constants.MenuItemToTitle
import org.lafzi.kotlinguideoffline.listDatas.SitemapListData
import org.lafzi.kotlinguideoffline.markdownStyles.GithubStyleExtended
import org.lafzi.kotlinguideoffline.tasks.RenderMarkdownTask

class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var markdownView: MarkdownView? = null
    private var expandableListView: ExpandableListView? = null
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(R.string.app_name)

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        markdownView = findViewById(R.id.content_markdown_view) as MarkdownView
        markdownView!!.addStyleSheet(GithubStyleExtended())

        val navView = findViewById(R.id.nav_view) as NavigationView
        val sitemap = SitemapListData(navView.menu)
        val sitemapId = sitemap.getId()
        val sitemapList = sitemap.getSitemapList()
        val titleList = arrayListOf<String>()
        titleList.addAll(sitemapList.keys)
        expandableListView = findViewById(R.id.expandable_list) as ExpandableListView
        expandableListView!!.setAdapter(SitemapAdapter(this, titleList, sitemapList))
        expandableListView!!.setOnChildClickListener({ _, _, groupPos, childPos, _ -> run {
            openPage(sitemapId[groupPos][childPos], sitemapList[titleList[groupPos]]!![childPos])
            true
        } })
    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            if (expandableListView!!.visibility == View.VISIBLE)
                super.onBackPressed()
            else {
                markdownView!!.visibility = View.GONE
                expandableListView!!.visibility = View.VISIBLE
                supportActionBar!!.setTitle(R.string.app_name)
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId
        openPage(id, item.title)
        return true
    }

    private fun openPage(id: Int, title: CharSequence) {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        supportActionBar!!.title = title

        renderContent(MenuItemToTitle.map[id])
    }

    private fun renderContent(title: String?) {
        RenderMarkdownTask(markdownView, expandableListView, title!!).execute()
    }

}
