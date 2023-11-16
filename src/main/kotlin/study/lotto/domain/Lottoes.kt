package study.lotto.domain

class Lottoes(private val list: List<Lotto>) : List<Lotto> by list {
    fun getPrizes(winningLotto: Lotto, bonusNumber: LottoNumber) = list.map {
        it.getPrizeGrade(winningLotto, bonusNumber)
    }

    companion object {
        fun buyLottoes(purchaseAmount: Amount): Lottoes {
            val buyLottoesCount = purchaseAmount / Lotto.PRICE_PER_TICKET
            val lottoList = List(buyLottoesCount) { Lotto.generate() }
            return Lottoes(lottoList)
        }
    }
}
