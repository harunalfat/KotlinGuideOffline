package org.lafzi.kotlinguideoffline.listDatas

import android.view.Menu
import android.view.SubMenu

/**
 * Created by alfat on 28/05/17.
 */

class SitemapListData(private val menu: Menu) {

    fun getSitemapList(): Map<String, List<String>> {
        val map = mutableMapOf<String, List<String>>()
        var submenu: SubMenu = menu.getItem(0).subMenu

        val gettingStarted = arrayListOf<String>()
        (0..2).mapTo(gettingStarted) { submenu.getItem(it).title.toString() }
        map["GETTING STARTED"] = gettingStarted

        val basics = arrayListOf<String>()
        submenu = menu.getItem(1).subMenu
        (0..3).mapTo(basics) { submenu.getItem(it).title.toString() }
        map["BASICS"] = basics

        val classesAndObjects = arrayListOf<String>()
        submenu = menu.getItem(2).subMenu
        (0..12).mapTo(classesAndObjects) { submenu.getItem(it).title.toString() }
        map["CLASSES AND OBJECTS"] = classesAndObjects

        val functionAndLambdas = arrayListOf<String>()
        submenu = menu.getItem(3).subMenu
        (0..3).mapTo(functionAndLambdas) { submenu.getItem(it).title.toString() }
        map["FUNCTION AND LAMBDAS"] = functionAndLambdas

        val other = arrayListOf<String>()
        submenu = menu.getItem(4).subMenu
        (0..12).mapTo(other) { submenu.getItem(it).title.toString() }
        map["OTHER"] = other

        return map
    }

    fun getId(): List<List<Int>> {
        val idList = arrayListOf<ArrayList<Int>>()
        val size = menu.size()
        var i = 0
        while (i < size) {
            val sublist = arrayListOf<Int>()
            val submenu = menu.getItem(i).subMenu
            var j = 0
            val subSize = submenu.size()
            while (j < subSize) {
                sublist.add(submenu.getItem(j).itemId)
                j++
            }
            i++
            idList.add(sublist)
        }
        return idList
    }

}