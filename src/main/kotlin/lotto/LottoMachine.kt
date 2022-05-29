package lotto

class LottoMachine {

    var lottoTickets = LottoTickets()
        private set

    var winningPrizes = WinningPrizes()
        private set

    fun purchase(purchaseMoney: PurchaseMoney, randomNumberFunc: () -> List<LottoNumber>) {
        val lottoTicketCount = purchaseMoney.money / LOTTO_PRICE

        lottoTickets = LottoTickets(
            (1..lottoTicketCount).toList().map {
                LottoTicket(randomNumberFunc())
            }
        )
    }

    fun checkResult(winningLottoTicket: LottoTicket, bonusLottoNumber: LottoNumber) {
        winningPrizes = WinningPrizes(
            lottoTickets.lottery.map {
                val matchCount = winningLottoTicket.numbers.intersect(it.numbers.toSet()).size
                val matchBonus = matchCount == BONUS_LOTTO_NUMBER_COUNT && it.hasBonusNumber(bonusLottoNumber)

                LottoResult().check(
                    matchCount = matchCount,
                    matchBonus = matchBonus,
                ).prize
            }
        )
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val BONUS_LOTTO_NUMBER_COUNT = 5
    }
}
