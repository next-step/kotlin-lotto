package lotto

class LottoMachine {
    var lottoTicketCount = 0
        private set

    var lottoTickets = LottoTickets()
        private set

    var winningPrizes = WinningPrizes()
        private set

    fun purchase(purchaseMoney: PurchaseMoney) {
        lottoTicketCount = purchaseMoney.money / LOTTO_PRICE

        lottoTickets = LottoTickets((1..lottoTicketCount).toList().map {
            Lotto(Extractor.getAutoNumbers())
        })
    }

    fun checkResult(winningLotto: Lotto) {
        winningPrizes = WinningPrizes(lottoTickets.lottery.map {
            LottoResult().check { winningLotto.numbers.intersect(it.numbers.toSet()) }
                .prize
        })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
