package com.axikmobile.androidadmobapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.LoadAdError
import kotlinx.android.synthetic.main.fragment_banner.*
import kotlinx.android.synthetic.main.fragment_intersticial.*

class IntersticialFragment: Fragment(){
    private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_intersticial, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mInterstitialAd = InterstitialAd(this.context)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

         btn_showInterstitial.setOnClickListener {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            } else {
                ToastHelper.showToast(context, "El anuncio intersticial no ha sido cargado")
            }
        }

        mInterstitialAd.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                btn_showInterstitial.isEnabled=true
                ToastHelper.showToast(context, "onAdLoaded")
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
                ToastHelper.showToast(context, "onAdFailedToLoad")
            }

            override fun onAdOpened() {
                // Code to be executed when the user clicks on an ad.
                ToastHelper.showToast(context, "onAdOpened")
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                ToastHelper.showToast(context, "onAdLeftApplication")
            }

            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                btn_showInterstitial.isEnabled=false
                ToastHelper.showToast(context, "onAdClosed")
                mInterstitialAd.loadAd(AdRequest.Builder().build())
            }

            override fun onAdClicked(){
                super.onAdClicked()
                ToastHelper.showToast(context, "onAdClicked")
            }

            override fun onAdImpression(){
                super.onAdImpression()
                ToastHelper.showToast(context, "onAdImpression")
            }
        }

    }
}