package lotto.domain

class LottoGame(val lottoList: List<Lotto>) {

    fun execute(prizeNumbers: String, bonusNumberInput: String): LottoGameResult {
        return when (val result = WinningLotto.from(prizeNumbers, bonusNumberInput)) {
            is WinningLottoResult.InvalidBonusNumber -> LottoGameResult.InvalidBonusNumber
            is WinningLottoResult.InvalidPrizeLotto -> LottoGameResult.InvalidPrizeLotto
            is WinningLottoResult.IsContainBonusNumber -> LottoGameResult.IsContainBonusNumber
            is WinningLottoResult.Success -> {
                val winningLotto = WinningLotto(result.prizeLotto, result.bonusNumber)
                val prizeStatics = LottoPrizeStatics(winningLotto, lottoList)
                LottoGameResult.Success(winningLotto, prizeStatics)
            }
        }
    }

    companion object {
        fun of(gameMoney: LottoGameMoney, manualLottos: List<Lotto> = listOf()): LottoGame {
            val autoLottoCount = gameMoney.getCountOfGame() - manualLottos.size
            return LottoGame(manualLottos + LottoGenerator.createAutoLottoList(autoLottoCount))
        }
    }
}
