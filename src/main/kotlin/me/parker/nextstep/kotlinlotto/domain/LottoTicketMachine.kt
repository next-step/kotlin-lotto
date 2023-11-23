package me.parker.nextstep.kotlinlotto.domain

object LottoTicketMachine {

    fun purchase(
        amountOfPurchase: Int,
        manualLottoNumbers: List<List<Int>>
    ): List<LottoTicket> {
        val sizeOfManual = manualLottoNumbers.size
        val sizeOfPurchase = amountOfPurchase / LottoTicket.PRICE
        require(sizeOfPurchase >= sizeOfManual) { "구매할 수 있는 로또 개수보다 많은 수동 로또 번호를 입력할 수 없습니다." }

        val manualLottoTickets = manualLottoNumbers.map { LottoTicket.manual(it) }

        return manualLottoTickets + List(sizeOfPurchase - sizeOfManual) { LottoTicket.automatic() }
    }
}
