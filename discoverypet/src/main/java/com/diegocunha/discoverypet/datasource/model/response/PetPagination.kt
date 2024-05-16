package com.diegocunha.discoverypet.datasource.model.response

data class PetPagination(
    val page: Long,
    val pageSize: Long,
    val pageCount: Long,
    val total: Long
)
