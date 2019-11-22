package com.student.student_order_2

import android.app.Application
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.firebase.client.Firebase
import android.content.pm.PackageInfo
import android.widget.Toast
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.util.Base64
import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class  MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FacebookSdk.sdkInitialize(getApplicationContext())
        AppEventsLogger.activateApp(this)
        Firebase.setAndroidContext(this)
        checkTime()
        try {
            val info: PackageInfo

            info = packageManager.getPackageInfo("com.student.student_order_2", PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md: MessageDigest
                md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val KeyResult = String(
                    Base64.encode(
                        md.digest(),
                        0
                    )
                )//String something = new String(Base64.encodeBytes(md.digest()));
                Log.d("hash key", KeyResult)
                Toast.makeText(this, "My FB Key is \n$KeyResult", Toast.LENGTH_LONG).show()
            }
        } catch (e1: NameNotFoundException) {
            Log.e("name not found", e1.toString())
        } catch (e: NoSuchAlgorithmException) {
            Log.e("no such an algorithm", e.toString())
        } catch (e: Exception) {
            Log.e("exception", e.toString())
        }


    }

    fun  checkTime(){
        if (MySharedPrefernces.getMyCardTime(getApplicationContext()).equals("")) {
            System.currentTimeMillis()
            MySharedPrefernces.saveMyCardTime(
                getApplicationContext(),
                System.currentTimeMillis().toString()
            )

        } else {

           var last: Long = (MySharedPrefernces.getMyCardTime(getApplicationContext())).toLong()
           var now : Long =System.currentTimeMillis()
            if(now-last>=24* 60 * 60 * 1000){
                MySharedPrefernces.saveMyCardTime(getApplicationContext(), "")

            }


        }


    }

}