package me.parker.nextstep.kotlinlotto.domain

class LottoTicketMachine(
    private val amountOfPurchase: Int,
    private val manualLottoNumbers: List<List<Int>>
) {

    init {
        val sizeOfPurchase = amountOfPurchase / LottoTicket.PRICE
        require(sizeOfPurchase >= manualLottoNumbers.size) { "구매할 수 있는 로또 개수보다 많은 수동 로또 번호를 입력할 수 없습니다." }
    }

    fun purchase(): List<LottoTicket> {
        val sizeOfManual = manualLottoNumbers.size
        val sizeOfPurchase = amountOfPurchase / LottoTicket.PRICE
        val manualLottoTickets = manualLottoNumbers.map { LottoTicket.manual(it) }

        return manualLottoTickets + List(sizeOfPurchase - sizeOfManual) { LottoTicket.automatic() }
    }
}
