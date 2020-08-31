package lotto.domain

class LottoGame(val lottoList: List<Lotto>) {

    fun execute(prizeNumbers: String, bonusNumberInput: String): LottoGameResult {
        val prizeLotto = Lotto.from(prizeNumbers) ?: return LottoGameResult.InvalidPrizeLotto
        if (!LOTTO_NUMBER_REGULAR_EXPRESSION.matches(bonusNumberInput)) return LottoGameResult.InvalidBonusNumber
        val bonusNumber: LottoNumber = LottoNumber.from(bonusNumberInput)
        if (prizeLotto.isContainNumber(bonusNumber)) return LottoGameResult.IsContainBonusNumber
        val winningLotto = WinningLotto(prizeLotto, bonusNumber)
        val prizeStatics = LottoPrizeStatics(winningLotto, lottoList)
        return LottoGameResult.Success(prizeNumbers, bonusNumber, prizeStatics)
    }

    companion object {
        fun of(gameMoney: LottoGameMoney, manualLottos: List<Lotto> = listOf()): LottoGame {
            val autoLottoCount = gameMoney.getCountOfGame() - manualLottos.size
            return LottoGame(manualLottos + LottoGenerator.createAutoLottoList(autoLottoCount))
        }
    }
}
