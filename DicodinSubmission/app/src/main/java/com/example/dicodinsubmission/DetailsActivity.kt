package com.example.dicodinsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.dicodinsubmission.model.Mod
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    companion object{
        val MODS = "mod"
    }
    private lateinit var mods : Mod
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        mods = intent.getSerializableExtra(MODS) as Mod

        Glide.with(this).load(mods.background).into(imageView_background)
        textView_namedetails.text = mods.name
        textView_detailsdetails.text = mods.details
        textView_statusdetails.text = "${mods.status} ${mods.year} ${mods.genre}"

        imageView_actionBack.setOnClickListener { onBackPressed() }

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}