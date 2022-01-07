package com.fuadi.myuas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.fuadi.myuas.adapter.Adapter
import com.fuadi.myuas.api.ApiRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JerseyActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var jerseyAdapter: Adapter
    private lateinit var lisNote : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jersey)
        setupList()

    }

    private fun setupList(){
        lisNote = findViewById(R.id.list_film)
        jerseyAdapter = Adapter(arrayListOf())
        lisNote.adapter = jerseyAdapter
    }

    override fun onStart() {
        super.onStart()
        getNote()
    }

    private fun getNote(){
        api.data().enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.fwapparel
                    jerseyAdapter.setData( listData )
                }
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("hadir",t.toString())
            }

        })
    }
}