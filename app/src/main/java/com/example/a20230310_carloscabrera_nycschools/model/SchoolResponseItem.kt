package com.example.a20230310_carloscabrera_nycschools.model


import com.google.gson.annotations.SerializedName

data class SchoolResponseItem(
    @SerializedName("academicopportunities1")
    val academicopportunities1: String? = null,
    @SerializedName("academicopportunities2")
    val academicopportunities2: String? = null,
    @SerializedName("academicopportunities3")
    val academicopportunities3: String? = null,
    @SerializedName("academicopportunities4")
    val academicopportunities4: String? = null,
    @SerializedName("academicopportunities5")
    val academicopportunities5: String? = null,
    @SerializedName("addtl_info1")
    val addtlInfo1: String? = null,
    @SerializedName("boro")
    val boro: String? = null,
    @SerializedName("borough")
    val borough: String? = null,
    @SerializedName("boys")
    val boys: String? = null,
    @SerializedName("building_code")
    val buildingCode: String? = null,
    @SerializedName("bus")
    val bus: String? = null,
    @SerializedName("campus_name")
    val campusName: String? = null,
    @SerializedName("census_tract")
    val censusTract: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("college_career_rate")
    val collegeCareerRate: String? = null,
    @SerializedName("community_board")
    val communityBoard: String? = null,
    @SerializedName("council_district")
    val councilDistrict: String? = null,
    @SerializedName("dbn")
    val dbn: String? = null,
    @SerializedName("diplomaendorsements")
    val diplomaendorsements: String? = null,
    @SerializedName("end_time")
    val endTime: String? = null,
    @SerializedName("extracurricular_activities")
    val extracurricularActivities: String? = null,
    @SerializedName("fax_number")
    val faxNumber: String? = null,
    @SerializedName("finalgrades")
    val finalgrades: String? = null,
    @SerializedName("geoeligibility")
    val geoeligibility: String? = null,
    @SerializedName("girls")
    val girls: String? = null,
    @SerializedName("graduation_rate")
    val graduationRate: String? = null,
    @SerializedName("interest1")
    val interest1: String? = null,
    @SerializedName("interest10")
    val interest10: String? = null,
    @SerializedName("interest2")
    val interest2: String? = null,
    @SerializedName("interest3")
    val interest3: String? = null,
    @SerializedName("overview_paragraph")
    val overviewParagraph: String? = null,
    @SerializedName("phone_number")
    val phoneNumber: String? = null,
    @SerializedName("primary_address_line_1")
    val primaryAddressLine1: String? = null,
    @SerializedName("psal_sports_boys")
    val psalSportsBoys: String? = null,
    @SerializedName("psal_sports_coed")
    val psalSportsCoed: String? = null,
    @SerializedName("psal_sports_girls")
    val psalSportsGirls: String? = null,
    @SerializedName("school_accessibility_description")
    val schoolAccessibilityDescription: String? = null,
    @SerializedName("school_email")
    val schoolEmail: String? = null,
    @SerializedName("school_name")
    val schoolName: String? = null,
    @SerializedName("school_sports")
    val schoolSports: String? = null,
    @SerializedName("start_time")
    val startTime: String? = null,
    @SerializedName("total_students")
    val totalStudents: String? = null,
    @SerializedName("transfer")
    val transfer: String? = null,
    @SerializedName("website")
    val website: String? = null,
    @SerializedName("zip")
    val zip: String? = null
)