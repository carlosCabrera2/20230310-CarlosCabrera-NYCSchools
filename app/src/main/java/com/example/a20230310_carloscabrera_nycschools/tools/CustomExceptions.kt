package com.example.a20230310_carloscabrera_nycschools.tools

class NullSchoolException(message: String= "School Response is null"): Exception(message)
class NullSatException(message: String= "SAT Response is null"): Exception(message)
class FailureResponseException(message: String?): Exception(message)