package com.example.a20230310_carloscabrera_nycschools.View

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a20230310_carloscabrera_nycschools.ViewModel.NYSchoolViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment: Fragment() {

    protected val nySchoolViewModel: NYSchoolViewModel by lazy {
        ViewModelProvider(requireActivity())[NYSchoolViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun showError(message: String, action:()-> Unit){
        AlertDialog.Builder(requireActivity())
            .setTitle("Error Occured")
            .setMessage(message)
            .setPositiveButton(
                "RETRY"){
                    dialog, _->
                action()
                dialog.dismiss()
            }
            .setNegativeButton(
                "DISMISS"){
                    dialog, _ -> action()
                dialog.dismiss()
            }
            .create()
            .show()
    }

}