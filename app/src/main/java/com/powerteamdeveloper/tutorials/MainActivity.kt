package com.powerteamdeveloper.tutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.OsConstants
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addContcatDialog =AlertDialog.Builder(this)
                .setTitle("Add  Contact")
            .setMessage("Do you want to add Ahmad to your contact")
            .setIcon(R.drawable.ic_add_content_background)
            .setPositiveButton("yes"){
                _,_ -> Toast.makeText(this,"ou added Ahmad to contact list",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){
                _,_ -> Toast.makeText(this,"you cancel adding ahmad",Toast.LENGTH_SHORT).show()
            }.create()
        btnDialog1.setOnClickListener {
            addContcatDialog.show()
        }
        val options = arrayOf("First Item","Second Item","third Item")
        val singelChoiceDialoge = AlertDialog.Builder(this)
            .setTitle("Chose one of these Options")
            .setSingleChoiceItems(options,0){
                _,i -> Toast.makeText(this,"you click on${options[i]}",Toast.LENGTH_SHORT).show()
            }.setPositiveButton("Accept"){
                    _,_ -> Toast.makeText(this,"you accept the singleChoiceDialog",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("decline"){
                    _,_ -> Toast.makeText(this,"you decline the singleChoiceDialog",Toast.LENGTH_SHORT).show()
            }.create()

        btnDialog2.setOnClickListener {
            singelChoiceDialoge.show()
        }
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Chose one of these Options")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)) { _, i, isChecked ->
              if(isChecked){  Toast.makeText(this,"you check ${options[i]}",Toast.LENGTH_SHORT).show() }}
            .setPositiveButton("Accept"){
                    _,_ -> Toast.makeText(this,"you accept the singleChoiceDialog",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("decline"){
                    _,_ -> Toast.makeText(this,"you decline the singleChoiceDialog",Toast.LENGTH_SHORT).show()
            }.create()
btnDialog3.setOnClickListener {
    multiChoiceDialog.show()
}
        val customList = listOf("First Item","Second Item","third Item")
        val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,customList)
        spMonths.adapter =adapter

        spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity,"You select ${adapterView?.getItemAtPosition(position).toString() }",Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        btNextMain.setOnClickListener {
            Intent(this,NewMain::class.java).also {
                startActivity(it)
            }
        }
        btToFrag.setOnClickListener {
            Intent(this,MainFragment::class.java).also {
                startActivity(it)
            }
        }
        btToBottom.setOnClickListener {
            Intent(this,BottomNavigation::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAddContact -> Toast.makeText(this,"You click on Add Contect",Toast.LENGTH_SHORT).show()
            R.id.mifavorite -> Toast.makeText(this,"You click on favorite",Toast.LENGTH_SHORT).show()
            R.id.miSetting -> Toast.makeText(this,"You click on Settingt",Toast.LENGTH_SHORT).show()
            R.id.miFeedback -> Toast.makeText(this,"You click on Feedback",Toast.LENGTH_SHORT).show()
            R.id.miLogout -> finish()
        }
        return true
    }
}