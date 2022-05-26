package lotto

class LottoMatching {
    var lottoTicketCount = 0
        private set

    var lottoTickets = LottoTickets()
        private set

    var winningPrizes = WinningPrizes()
        private set

    fun purchase(purchaseMoney: PurchaseMoney, numbers: List<LottoNumber> = Extractor.getAutoNumbers()) {
        lottoTicketCount = purchaseMoney.money / LOTTO_PRICE

        lottoTickets = LottoTickets((1..lottoTicketCount).toList().map {
            LottoTicket(Extractor.getAutoNumbers())
        })
    }

    fun checkResult(winningLottoTicket: LottoTicket, bonusLottoNumber : LottoNumber) {
        winningPrizes = WinningPrizes(lottoTickets.lottery.map {
            LottoResult().check {
                winningLottoTicket.numbers.intersect(it.numbers.toSet())
            }.prize
        })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}

fun  LottoTicket.hasBonusNumber(bonusLottoNumber: LottoNumber): Boolean {
    return  bonusLottoNumber in this.numbers
}
