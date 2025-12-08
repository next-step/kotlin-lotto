package com.example.mylotto.model

data class LottoTicketOrder(
    val manualTickets: List<LottoTicket>,
    val automaticCount: Int,
)
