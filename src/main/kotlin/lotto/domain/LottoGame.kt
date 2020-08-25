package lotto.domain

const val PRICE_OF_LOTTO = 1000

class LottoGame(val lottoList: List<Lotto>) {
    val lottoPrizeStatics = LottoPrizeStatics()

    constructor(gameMoney: String) : this(
        LottoGenerator.createAutoLottoList(gameMoney)
    )

    fun execute(prizeLotto: Lotto, bonusNumber: String) {
        val winningLotto = WinningLotto(prizeLotto, bonusNumber)
        checkMatch(winningLotto)
    }

    private fun checkMatch(winningLotto: WinningLotto) {
        lottoPrizeStatics.calculateResult(winningLotto, lottoList)
    }

    companion object {

        fun of(gameMoney: String, manualLottos: List<Lotto>): LottoGame =
            LottoGame(manualLottos.plus(LottoGenerator.createAutoLottoList(gameMoney)))
    }
}
