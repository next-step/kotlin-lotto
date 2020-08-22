package lotto.domain

const val PRICE_OF_LOTTO = 1000

class LottoGame(val lottoList: List<Lotto>) {
    val lottoPrizeStatics = LottoPrizeStatics()

    constructor(gameMoneyString: String) : this(
        LottoGenerator.createAutoLottoList(gameMoneyString)
    )

    fun execute(prizeNumberString: String, bonusNumberString: String) {
        val winningLotto = WinningLotto(prizeNumberString, bonusNumberString)
        checkMatch(winningLotto)
    }

    private fun checkMatch(winningLotto: WinningLotto) {
        lottoPrizeStatics.calculateResult(winningLotto, lottoList)
    }
}
