package com.furkanustabasi.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.furkanustabasi.kotlincountries.R
import com.furkanustabasi.kotlincountries.databinding.ItemCountryBinding
import com.furkanustabasi.kotlincountries.model.Country
import com.furkanustabasi.kotlincountries.util.downloadFromUrl
import com.furkanustabasi.kotlincountries.util.placeHolderProgressBar
import com.furkanustabasi.kotlincountries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.fragment_country.view.*
import kotlinx.android.synthetic.main.fragment_country.view.countryName
import kotlinx.android.synthetic.main.fragment_country.view.countryRegion
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(private val countryList: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),
    CountryClickListener {

    //DATA BINDING ICIN VIEW YERİNE ITEM COUNTRY BINDING kullanıyoruz
    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_country, parent, false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater, R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.country = countryList[position]
        holder.view.listener = this

/*
DATA BINDING OLMADAN YAZILAN KODLAR

 holder.itemView.countryName.text = countryList[position].countryName
        holder.itemView.countryRegion.text = countryList[position].countryRegion
        holder.view.imageView.downloadFromUrl(countryList[position].imageUrl, placeHolderProgressBar(holder.view.context))

        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment2(countryList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }
 */

    }


    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClick(v: View) {
        val uuid = v.countryUuidText.text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment2(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}