package com.example.databaserecipe

import android.content.Intent
import android.icu.text.Transliterator
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.databaserecipe.databinding.FragmentRootBinding
import org.json.JSONObject
import java.util.zip.Inflater

class RootFragment:Fragment(R.layout.fragment_root) {
    private lateinit var binding: FragmentRootBinding
    private lateinit var rootInflate: LayoutInflater

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRootBinding.inflate(inflater)
        rootInflate = inflater
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonToRecipe.setOnClickListener{
            findNavController().navigate(R.id.action_rootFragment_to_listFragment)
        }

        binding.getWeather.setOnClickListener {
            var nameCity = binding.cityName.text.toString()
            getResultWeather(nameCity)
        }

        binding.buttonCallToSupport.setOnClickListener {
            val intentCallToSupport = Intent(Intent.ACTION_CALL)
            intentCallToSupport.data = Uri.parse("tel: +79051379058")
            startActivity(intentCallToSupport)
        }
    }

    private fun getResultWeather(name: String){
        var url = "https://api.weatherapi.com/v1/forecast.json?key=303813d68ec3442d8b6133529222811&q="+
                    name+"&days=1&aqi=no&alerts=no"
        val q = Volley.newRequestQueue(rootInflate.getContext())
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {
                response->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog", "Response: ${temp.getString("temp_c")}")
                binding.textPogoda.setText(temp.getString("temp_c"))
            },
            {
                Log.d("MyLog", "Volley error: $it")
            },
            )
        q.add(stringRequest)
    }
}