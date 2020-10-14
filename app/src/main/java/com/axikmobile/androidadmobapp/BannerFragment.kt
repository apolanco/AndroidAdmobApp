package com.axikmobile.androidadmobapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import kotlinx.android.synthetic.main.fragment_banner.*

class BannerFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_banner, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adRequest = AdRequest.Builder().build()

        adView.loadAd(adRequest)
        adView.adListener = object: AdListener() {

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
               // Toast.makeText(context, "onAdLoaded", Toast.LENGTH_SHORT).show()
               ToastHelper.showToast(context, "onAdLoaded")
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
                ToastHelper.showToast(context, "onAdFailedToLoad")
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                ToastHelper.showToast(context, "onAdOpened")
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                ToastHelper.showToast(context, "onAdClicked")
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                ToastHelper.showToast(context, "onAdLeftApplication")
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                ToastHelper.showToast(context, "onAdClosed")
            }
        }
    }
}