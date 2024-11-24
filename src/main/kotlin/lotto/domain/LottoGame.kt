package lotto.domain

class LottoGame(private val lottoPurchaseCount: LottoPurchaseCount, private val lottoLines: LottoLines) {
    fun returnGameResult(
        winningNumbers: List<Int>,
        profitRateCalculator: ProfitRateCalculator,
    ): LottoGameResult {
        val winningLottoLine = LottoLine.makeNewLottoLine(winningNumbers)
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
            lottoBallMachine: LottoBallMachine,
        ): LottoGame {
            val lottoPurchaseCount = lottoPurchaseAmount.toLottoPurchaseCount()
            val lottoLines =
                List(lottoPurchaseCount.count) {
                    lottoBallMachine.generate()
                }
            return LottoGame(lottoPurchaseCount, LottoLines(lottoLines))
        }
    }
}
