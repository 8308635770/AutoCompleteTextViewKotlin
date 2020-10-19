package com.example.autocompletetextviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var tv_autocomplete : AutoCompleteTextView;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryList=ArrayList<CountryItem>()
        val item = CountryItem(R.drawable.ic_flag_of_india,"india")
        countryList.add(item)
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india"))
        countryList.add(CountryItem(R.drawable.ic_flag_of_india,"india LAST"))


        tv_autocomplete=autocomplete_tv
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,
            colors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        var adapter1=AutoCompleteCountryAdapter(this,countryList)
        tv_autocomplete.threshold=1
        tv_autocomplete.setAdapter(adapter)
}

companion object{
    val colors = arrayOf<String>("red","blue","green","white","brown","black","violet","orange");
}
}
