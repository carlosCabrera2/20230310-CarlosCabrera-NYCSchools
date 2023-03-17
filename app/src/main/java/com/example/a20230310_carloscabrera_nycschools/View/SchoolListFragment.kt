package com.example.a20230310_carloscabrera_nycschools.View

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a20230310_carloscabrera_nycschools.R
import com.example.a20230310_carloscabrera_nycschools.View.Adapter.SchoolAdapter
import com.example.a20230310_carloscabrera_nycschools.databinding.SchoolListRecyclerViewBinding
import com.example.a20230310_carloscabrera_nycschools.tools.ResponseState

class SchoolListFragment: BaseFragment() {

    private val binding by lazy {
        SchoolListRecyclerViewBinding.inflate(layoutInflater)
    }

    private val schoolAdapter by lazy {
        SchoolAdapter{
            nySchoolViewModel.selectedSchool = it
            nySchoolViewModel.myDbn = it.dbn ?: ""
            findNavController().navigate(R.id.action_nav_school_list_fragment_to_nav_school_details_fragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = getString(R.string.toolbar_title)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.rvSchoolList.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            getSchools()
            adapter = schoolAdapter
        }
        nySchoolViewModel.getSchoolList()
        nySchoolViewModel.getSatResult()
        return binding.root
    }



    private fun getSchools() {
        nySchoolViewModel.schoolList.observe(viewLifecycleOwner){state->
            when(state){
                is ResponseState.LOADING ->{}
                is ResponseState.SUCCESS ->{
                    state.response.let {
                        schoolAdapter.updateItems(it)
                    }
                }
                is ResponseState.ERROR ->{
                    AlertDialog.Builder(requireActivity())
                        .setTitle("Error occured")
                        .setMessage(state.error.localizedMessage)
                        .setPositiveButton("Retry"){dialog,_ ->
                            nySchoolViewModel.getSchoolList()
                            dialog.dismiss()
                        }
                        .setNegativeButton("Dismiss"){dialog,_ ->
                            dialog.dismiss()
                        }
                }
            }
        }
    }
}