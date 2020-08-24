package lotto.domain

const val PRICE_OF_LOTTO = 1000

class LottoGame(val lottoList: List<Lotto>) {
    val lottoPrizeStatics = LottoPrizeStatics()

    constructor(gameMoney: String) : this(
        LottoGenerator.createAutoLottoList(gameMoney)
    )

    fun execute(prizeNumber: String, bonusNumber: String) {
        val winningLotto = WinningLotto(prizeNumber, bonusNumber)
        checkMatch(winningLotto)
    }

    private fun checkMatch(winningLotto: WinningLotto) {
        lottoPrizeStatics.calculateResult(winningLotto, lottoList)
    }

}
