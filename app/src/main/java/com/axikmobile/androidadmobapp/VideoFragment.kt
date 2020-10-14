package com.axikmobile.androidadmobapp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kotlinx.android.synthetic.main.fragment_video.*


class VideoFragment: Fragment()  {

    private lateinit var rewardedAd: RewardedAd

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater!!.inflate(R.layout.fragment_video, null)
        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        MobileAds.initialize(this.context) {}

       // Se carga la función del anuncio
        loadAd()


     /*   rewardedAd = RewardedAd(this.context, "ca-app-pub-3940256099942544/5224354917")

        val adLoadCallback = object: RewardedAdLoadCallback(){
            override fun onRewardedAdLoaded() {
                //ad successfully loaded
                ToastHelper.showToast(context, "Ad successfully loaded")
            }

            override fun onRewardedAdFailedToLoad(errorCode: Int) {
                //ad failed to load
                ToastHelper.showToast(context, "Ad failed to load")
            }
        }
        rewardedAd.loadAd(AdRequest.Builder().build(), adLoadCallback) */



        btn_showVideo.setOnClickListener{

            // fragmentContext
            if (rewardedAd.isLoaded) {
               val fragmentContext: VideoFragment = this@VideoFragment
               val adCallback = object: RewardedAdCallback() {
                   override fun onRewardedAdOpened() {
                       // ad opened
                   }

                   override fun onRewardedAdClosed() {
                      loadAd()
                       // btn_showVideo.isEnabled = false
                       // ad closed
                   }

                   override fun onUserEarnedReward(@NonNull reward: RewardItem) {
                       // user earned reward
                       loadAd()
                   }

                   override fun onRewardedAdFailedToShow(errorCode: Int) {
                       // ad failed to display
                   }
               }
                rewardedAd.show(fragmentContext.activity, adCallback)

            } else {

                ToastHelper.showToast(context, "The reward ad wasn't loaded yet")

            }
        }
    }

    fun loadAd(){
        rewardedAd = RewardedAd(this.context, "ca-app-pub-3940256099942544/5224354917")

        val adLoadCallback = object: RewardedAdLoadCallback(){
            override fun onRewardedAdLoaded() {
                //ad successfully loaded
                ToastHelper.showToast(context, "Ad successfully loaded")
            }

            override fun onRewardedAdFailedToLoad(errorCode: Int) {
                //ad failed to load
                ToastHelper.showToast(context, "Ad failed to load")
            }
        }
        rewardedAd.loadAd(AdRequest.Builder().build(), adLoadCallback)

    }
}





