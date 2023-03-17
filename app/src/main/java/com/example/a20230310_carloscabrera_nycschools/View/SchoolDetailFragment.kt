package com.example.a20230310_carloscabrera_nycschools.View

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a20230310_carloscabrera_nycschools.databinding.FragmentSchoolDetailViewBinding
import com.example.a20230310_carloscabrera_nycschools.model.SatResponseItem
import com.example.a20230310_carloscabrera_nycschools.model.SchoolResponseItem
import com.example.a20230310_carloscabrera_nycschools.tools.ResponseState

class SchoolDetailFragment : BaseFragment() {

    private val binding by lazy {
        FragmentSchoolDetailViewBinding.inflate(layoutInflater)
    }

    private var selectedSchool = SchoolResponseItem()

    private var selectedSchoolSatInfo = SatResponseItem()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        selectedSchool = nySchoolViewModel.selectedSchool
        selectedSchoolSatInfo = nySchoolViewModel.selectedSchoolSatInfo

        nySchoolViewModel.getSatResult(nySchoolViewModel.myDbn)
        getSat()
        getSchoolDetails()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = "Schools Details"
    }

    private fun getSat() {
        nySchoolViewModel.satResult.observe(viewLifecycleOwner) { state ->

            when (state) {
                is ResponseState.LOADING -> {}
                is ResponseState.SUCCESS -> {
                    state.response.let {
                        it.forEach {
                            binding.tvMathScore.text = it.satMathAvgScore
                            binding.tvReadingScore.text = it.satCriticalReadingAvgScore
                            binding.tvWritingScore.text = it.satWritingAvgScore
                            binding.tvTakers.text = it.numOfSatTestTakers
                        }

                    }
                }
                is ResponseState.ERROR -> {}
            }

        }
    }

    private fun getSchoolDetails() {
        binding.tvSchoolName.text = selectedSchool.schoolName
        binding.tvSchoolWebsite.text = selectedSchool.website
        binding.tvSchoolEmail.text = selectedSchool.schoolEmail
        binding.tvSchoolPhoneNumber.text = selectedSchool.phoneNumber
        binding.tvSchoolFaxNumber.text = selectedSchool.faxNumber
        binding.tvSchoolAddress.text = selectedSchool.primaryAddressLine1
        binding.tvSchoolCity.text = selectedSchool.city
        binding.tvSchoolZipcode.text = selectedSchool.zip
        binding.tvSchoolStartTime.text = selectedSchool.startTime
        binding.tvSchoolEndTime.text = selectedSchool.endTime
        binding.tvOverviewParagraph.text = selectedSchool.overviewParagraph

    }
}