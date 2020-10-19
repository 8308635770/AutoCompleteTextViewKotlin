package com.example.autocompletetextviewkotlin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import kotlinx.android.synthetic.main.country_autocomplete_item.view.*
import kotlinx.android.synthetic.main.custom_list_item.view.*
import kotlin.math.log

class AutoCompleteCountryAdapter(
    context: Context,
    countries: ArrayList<CountryItem>
) : ArrayAdapter<CountryItem>(context, 0, countries) {

         var countryListFull=ArrayList<CountryItem>(countries)


    override fun getFilter(): Filter {
        return getCountryFilter()

    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        Log.i("srt", "shivam get view")

        val convertView1 = LayoutInflater.from(context).inflate(R.layout.country_autocomplete_item, parent, false);
        val country: CountryItem? = getItem(position)
        Log.i("srt", country?.countryName)
        if (country != null) {
            convertView1.text_view_name.text = country.countryName
            convertView1.image_view_flag.setImageResource(country.imageResource)
        }


        return convertView1
    }


    fun getCountryFilter() = object : Filter() {

        override fun convertResultToString(resultValue: Any?): CharSequence {
            return (resultValue as CountryItem).countryName
        }

        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val suggestions = ArrayList<CountryItem>()

            if (constraint == null || constraint.length == 0) {
                suggestions.addAll(countryListFull)
            } else {
                val filterPattern = constraint.toString().trim()
                for (contry in countryListFull) {

                    if (contry.countryName.toString().contains(filterPattern)) {
                        suggestions.add(contry)
                    }

                }
            }

            val result = FilterResults()
            result.values = suggestions
            result.count = suggestions.size
            return result


        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            clear()
            addAll(results?.values as Collection<CountryItem>)
            notifyDataSetChanged()

        }

    }


}