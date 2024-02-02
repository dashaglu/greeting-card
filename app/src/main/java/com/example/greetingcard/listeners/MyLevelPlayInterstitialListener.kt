package com.example.greetingcard.listeners

import android.util.Log
import com.ironsource.mediationsdk.IronSource
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo
import com.ironsource.mediationsdk.logger.IronSourceError
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener

class MyLevelPlayInterstitialListener: LevelPlayInterstitialListener {

    override fun onAdReady(p0: AdInfo?) {
        Log.i("MyApp", "Add is ready to be shown")
        IronSource.showInterstitial("DefaultInterstitial");
    }

    override fun onAdLoadFailed(p0: IronSourceError?) {
        if (p0 != null) {
            Log.e("MyApp", "some error occur on IS side")
            Log.e("MyApp", p0.errorMessage)
        }
    }

    override fun onAdOpened(p0: AdInfo?) {
        TODO("Not yet implemented")
    }

    override fun onAdShowSucceeded(p0: AdInfo?) {
        TODO("Not yet implemented")
    }

    override fun onAdShowFailed(p0: IronSourceError?, p1: AdInfo?) {
        TODO("Not yet implemented")
    }

    override fun onAdClicked(p0: AdInfo?) {
        TODO("Not yet implemented")
    }

    override fun onAdClosed(p0: AdInfo?) {
        TODO("Not yet implemented")
    }
}