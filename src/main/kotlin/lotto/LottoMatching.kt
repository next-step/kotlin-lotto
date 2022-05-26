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

        lottoTickets = LottoTickets(
            (1..lottoTicketCount).toList().map {
                LottoTicket(numbers)
            }
        )
    }

    fun checkResult(winningLottoTicket: LottoTicket, bonusLottoNumber: LottoNumber) {
        winningPrizes = WinningPrizes(
            lottoTickets.lottery.map {
                val matchCount = winningLottoTicket.checkMatching(it).size
                val matchBonus = matchCount == 5 && it.hasBonusNumber(bonusLottoNumber)

                LottoResult().check(
                    matchCount = matchCount,
                    matchBonus = matchBonus,
                ).prize
            }
        )
    }

    private fun LottoTicket.hasBonusNumber(bonusLottoNumber: LottoNumber): Boolean = bonusLottoNumber in this.numbers

    private fun LottoTicket.checkMatching(lottoTicket: LottoTicket) = this.numbers.intersect(lottoTicket.numbers.toSet())

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
