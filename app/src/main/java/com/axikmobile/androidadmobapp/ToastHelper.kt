package com.axikmobile.androidadmobapp

import android.content.Context
import android.view.Gravity
import android.widget.Toast

class ToastHelper{

    companion object{
      fun showToast(context: Context?, nombre :String){
          val toast:Toast = Toast.makeText(context, nombre, Toast.LENGTH_SHORT)
          toast.setGravity(Gravity.CENTER, 0,0)
          toast.show()
      }

    }



}