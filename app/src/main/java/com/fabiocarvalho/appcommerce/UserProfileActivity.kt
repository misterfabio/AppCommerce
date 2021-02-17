package com.fabiocarvalho.appcommerce

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.FileProvider
import androidx.preference.PreferenceManager
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class UserProfileActivity: AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var textTitle: TextView
    lateinit var imageProfile: ImageView
    lateinit var photoURI: Uri

    val REQUEST_TAKE_PHOTO = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.user_profile_title)

        imageProfile = findViewById(R.id.iv_profile_image)
        imageProfile.setOnClickListener {
            takePicture()
            Toast.makeText(this, "Clicou na foto", Toast.LENGTH_SHORT).show()
        }

        val profileImage = PreferenceManager.getDefaultSharedPreferences(this).
            getString(MediaStore.EXTRA_OUTPUT,null)
        if (profileImage!=null){
            photoURI = Uri.parse(profileImage)
            imageProfile.setImageURI(photoURI)
        }else{
            imageProfile.setImageResource(R.drawable.profile_image)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun takePicture() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{intent -> 
            intent.resolveActivity(packageManager)?.also { 
                val photoFile: File? = try{
                    createImageFile()
                }catch (ex: IOException){
                    null
                }
                photoFile?.also{
                    photoURI = FileProvider.getUriForFile(
                        this,"com.fabiocarvalho.appcommerce.fileprovider", it)
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(intent, REQUEST_TAKE_PHOTO)
                }

            }
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "PROFILE_${timeStamp}",
            ".jpg",
            storageDir
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        PreferenceManager.getDefaultSharedPreferences(this).apply {
            edit().putString(MediaStore.EXTRA_OUTPUT, photoURI.toString()).apply()
        }
        imageProfile.setImageURI(photoURI)
    }




//[ fim ]
}