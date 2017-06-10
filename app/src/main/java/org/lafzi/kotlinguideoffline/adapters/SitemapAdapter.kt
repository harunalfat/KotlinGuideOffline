package org.lafzi.kotlinguideoffline.adapters

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

/**
 * Created by alfat on 28/05/17.
 */

class SitemapAdapter(private val context: Context,
                     private val expandableListTitle: List<String>,
                     private val expandableListDetail: Map<String, List<String>>) : BaseExpandableListAdapter() {

    override fun getGroup(groupPosition: Int): Any {
        return expandableListTitle[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val listTitle = getGroup(groupPosition) as String
        val retView: View

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            retView = inflater.inflate(android.R.layout.simple_list_item_1, null)
        } else {
            retView = convertView
        }

        val textView = retView.findViewById(android.R.id.text1) as TextView
        textView.setTypeface(null, Typeface.BOLD)
        textView.text = listTitle
        return retView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return expandableListDetail[expandableListTitle[groupPosition]]!!.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return expandableListDetail[expandableListTitle[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var retView: View
        val expandedListText = getChild(groupPosition, childPosition) as String

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            retView = inflater.inflate(android.R.layout.simple_list_item_1, null)
        } else {
            retView = convertView
        }

        val textView = retView.findViewById(android.R.id.text1) as TextView
        textView.setTypeface(null, Typeface.ITALIC)
        textView.text = expandedListText
        return retView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return expandableListTitle.size
    }

}