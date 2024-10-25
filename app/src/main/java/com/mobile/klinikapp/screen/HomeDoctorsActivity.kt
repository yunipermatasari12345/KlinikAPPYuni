package com.mobile.klinikapp.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.klinikapp.R
import com.mobile.klinikapp.adapter.ListDoctorAdapter
import com.mobile.klinikapp.model.ModelListDoctors

class HomeDoctorsActivity : AppCompatActivity() {

    private var rv_list: RecyclerView? = null
    private var homeDoctorsAdapter: ListDoctorAdapter? = null

    //array data doctor
    private var doctorList = mutableListOf<ModelListDoctors>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_doctors)

        rv_list = findViewById(R.id.rv_list)
        doctorList = ArrayList()
        homeDoctorsAdapter = ListDoctorAdapter(this,doctorList);
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,1)
        rv_list!!.layoutManager = layoutManager
        rv_list!!.adapter = homeDoctorsAdapter

        //create dummy data
        prepareDataDoctors()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun prepareDataDoctors(){
       var itemDoctors = ModelListDoctors(
            R.drawable.dokter1,
            "Yuni Permata Sari",
            "Dokter Ahli",
            "120",
            "5,0"
        )
        doctorList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter6,
            "Afifa SalsaBila ",
            "Dokter GiGi",
            "100",
            "5,0"
        )
        doctorList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter3,
            "Jeri Antomi",
            "Dokter Anak",
            "110",
            "5,0"
        )
        doctorList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter4,
            "Desvita Putri",
            "Dokter kandungan",
            "110",
            "5,0"
        )
        doctorList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter5,
            "Ladisa Arnelia Putri",
            "Dokter mata",
            "110",
            "5,0"
        )
        doctorList.add(itemDoctors)
        homeDoctorsAdapter!!.notifyDataSetChanged()
    }
}