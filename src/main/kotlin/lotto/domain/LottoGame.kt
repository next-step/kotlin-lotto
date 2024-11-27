package lotto.domain

class LottoGame(private val lottoPurchaseCount: LottoPurchaseCount, private val lottoLines: LottoLines) {
    fun returnGameResult(
        winningBalls: LottoBalls,
        bonusBall: LottoBall,
        profitRateCalculator: ProfitRateCalculator,
    ): LottoGameResult {
        val winningLottoLine = WinningLotto.makeWinningLotto(winningBalls, bonusBall)
        return lottoLines.extractLottoGameResult(winningLottoLine, profitRateCalculator)
    }

    fun getPurchaseCount(): Int {
        return lottoPurchaseCount.count
    }

    fun getLottoLines(): LottoLines {
        return lottoLines
    }

    companion object {
        fun makeNewLottoGame(
            lottoPurchaseAmount: LottoPurchaseAmount,
            manualLines: List<LottoLine>,
            lottoBallMachine: LottoBallMachine,
        ): LottoGame {
            val lottoPurchaseCount = lottoPurchaseAmount.toLottoPurchaseCount()
            val lottoLines =
                manualLines +
                    List(lottoPurchaseCount.count) {
                        lottoBallMachine.generate()
                    }
            return LottoGame(lottoPurchaseCount, LottoLines(lottoLines))
        }
    }
}
