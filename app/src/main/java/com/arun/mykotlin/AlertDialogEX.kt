package com.arun.mykotlin

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.arun.mykotlin.databinding.ActivityAlertDialogExBinding

class AlertDialogEX : AppCompatActivity() {

    lateinit var binding: ActivityAlertDialogExBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertDialogExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Mr roy to your contact list")
            .setIcon(R.drawable.ic_fav)
            .setPositiveButton("Yes", DialogInterface.OnClickListener(){
                _, _ ->  Toast.makeText(this,"you added mr roy to contact list",Toast.LENGTH_LONG).show()
            })

            .setNegativeButton("No", DialogInterface.OnClickListener(){
                    _, _ ->  Toast.makeText(this,"you didn't added mr roy to contact list",Toast.LENGTH_LONG).show()
            }).create()

        binding.btnDialog1.setOnClickListener {
            addContactDialog.show()
        }


        val options = arrayOf("First Item","Second Item","Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these option")
            .setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "you clicked on ${options[i]}", Toast.LENGTH_LONG).show()

            })
            .setPositiveButton("Accept", DialogInterface.OnClickListener(){
                    _, _ ->  Toast.makeText(this,"you accepted",Toast.LENGTH_LONG).show()
            })

            .setNegativeButton("Decline", DialogInterface.OnClickListener(){
                    _, _ ->  Toast.makeText(this,"you declined",Toast.LENGTH_LONG).show()
            }).create()

        binding.btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }


        //val options = arrayOf("First Item","Second Item","Third Item")
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these option")
            .setMultiChoiceItems(options, booleanArrayOf(false,true,false),DialogInterface.OnMultiChoiceClickListener { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "you Checked ${options[i]}", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "you unchecked ${options[i]}", Toast.LENGTH_LONG).show()

                }
            })
            .setPositiveButton("Accept", DialogInterface.OnClickListener(){
                    _, _ ->  Toast.makeText(this,"you accepted",Toast.LENGTH_LONG).show()
            })

            .setNegativeButton("Decline", DialogInterface.OnClickListener(){
                    _, _ ->  Toast.makeText(this,"you declined",Toast.LENGTH_LONG).show()
            }).create()

        binding.btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }





    }
}