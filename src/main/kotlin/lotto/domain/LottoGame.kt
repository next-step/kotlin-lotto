package lotto.domain

const val PRICE_OF_LOTTO = 1000

class LottoGame(val lottoList: List<Lotto>) {
    val lottoPrizeStatics = LottoPrizeStatics()

    constructor(gameMoney: String) : this(
        LottoGenerator.createAutoLottoList(gameMoney)
    )

    fun execute(prizeNumbers: String, bonusNumberInput: String): LottoGameResult {
        val prizeLotto = Lotto.from(prizeNumbers) ?: return LottoGameResult.InvalidPrizeLotto
        if (!LOTTO_NUMBER_REGULAR_EXPRESSION.matches(bonusNumberInput)) return LottoGameResult.InvalidBonusNumber
        val bonusNumber: LottoNumber = LottoNumber.from(bonusNumberInput)
        if (prizeLotto.isContainNumber(bonusNumber)) return LottoGameResult.IsContainBonusNumber
        val winningLotto = WinningLotto(prizeLotto, bonusNumber)
        checkMatch(winningLotto)
        return LottoGameResult.Success(prizeNumbers, bonusNumber)
    }

    private fun checkMatch(winningLotto: WinningLotto) {
        lottoPrizeStatics.calculateResult(winningLotto, lottoList)
    }

    companion object {

        fun of(gameMoney: String, manualLottos: List<Lotto>): LottoGame =
            LottoGame(manualLottos.plus(LottoGenerator.createAutoLottoList(gameMoney)))
    }
}
