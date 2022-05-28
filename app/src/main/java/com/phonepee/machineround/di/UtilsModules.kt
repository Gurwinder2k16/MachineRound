package com.phonepee.machineround.di

import com.phonepee.machineround.utils.dialog.ProgressBarDialog
import com.phonepee.machineround.utils.imageutils.ImageUtilsModules
import dagger.Module
import dagger.Provides

@Module
class UtilsModules {

    @Provides
    fun contributeToDialogFragmentModule(): ProgressBarDialog {
        return ProgressBarDialog.newInstance()
    }

    @Provides
    fun contributeToImageUtilsModules(): ImageUtilsModules {
        return ImageUtilsModules.newInstance()
    }

}