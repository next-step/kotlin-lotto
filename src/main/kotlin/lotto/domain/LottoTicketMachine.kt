package lotto.domain

interface LottoTicketMachine {
    fun issue(nums: List<Int>): LottoTicket
}
