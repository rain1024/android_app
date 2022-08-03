package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter (var context: Context, var data: ArrayList<Dish>): BaseAdapter() {
    class ViewHolder(row: View){
        var textviewdish: TextView
        var imageviewdish: ImageView

        init {
            textviewdish = row.findViewById(R.id.namedish) as TextView
            imageviewdish = row.findViewById(R.id.imageviewdish) as ImageView
        }
    }
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, convertview: View?, p2: ViewGroup?): View? {
        var view: View?
        var viewHolder: ViewHolder
        if(convertview == null){
            var layoutinflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.dish_item, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertview
            viewHolder = convertview.tag as ViewHolder
        }

        var dish: Dish = getItem(p0) as Dish
        viewHolder.textviewdish.text = dish.name
        viewHolder.imageviewdish.setImageResource(dish.image)
        return view
    }
}