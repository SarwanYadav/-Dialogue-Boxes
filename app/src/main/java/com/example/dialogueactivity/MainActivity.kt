package com.example.dialogueactivity

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogueactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)

            builder1.setTitle("Are you sure")
            builder1.setMessage("Do you want to close the App? ")
            builder1.setIcon(R.drawable.exit)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                finish()

            })

            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->


            })

            builder1.show()


        }


        // second button click

        binding.btn2.setOnClickListener {
            val options = arrayOf("gulab jamun", "Rasha malai", "kaju katali")
            var checkedItem = 0 // Initialize with the default selection index

            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite sweet?")
            builder2.setSingleChoiceItems(options,
                checkedItem, // Set the initial selected item index
                DialogInterface.OnClickListener { dialog, which ->
                    checkedItem = which // Update the selected item index

                    Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT)
                        .show()

                })


            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->


            })

            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->
                // Handle "No" button click


            })

            builder2.show()
        }


        // button btn3

        binding.btn3.setOnClickListener {
            val options = arrayOf("gulab jamun", "Rasha malai", "kaju katali")
            var checkedItems =
                BooleanArray(options.size) { false } // Initialize with all items unchecked

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which are your favorite sweets?")
            builder.setMultiChoiceItems(options,
                checkedItems,
                DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                    // Update the checkedItems array based on user selection
                    checkedItems[which] = isChecked
                    // Show a Toast message when an item is clicked
                    Toast.makeText(
                        this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT
                    ).show()
                })

            builder.setPositiveButton("Submit") { dialog, which ->
                // Handle submit button click
                // Here you can process the selected items (checkedItems array)
                val selectedSweets = mutableListOf<String>()
                for (i in options.indices) {
                    if (checkedItems[i]) {
                        selectedSweets.add(options[i])
                    }
                }
                Toast.makeText(
                    this, "You selected: ${selectedSweets.joinToString()}", Toast.LENGTH_SHORT
                ).show()
            }

            builder.setNegativeButton("Decline") { dialog, which ->
                // Handle decline button click
                // Do nothing or perform any action as needed
            }

            builder.show()
        }

    }
}

