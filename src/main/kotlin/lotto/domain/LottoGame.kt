package lotto.domain

class LottoGame(private val lottoPurchaseAmount: LottoPurchaseAmount, private val lottoBallMachine: LottoBallMachine) {
    private val lottoPurchaseCount: LottoPurchaseCount
    private val lottoLines: LottoLines

    init {
        this.lottoPurchaseCount = lottoPurchaseAmount.toLottoPurchaseCount()

        val lottoLines =
            List(lottoPurchaseCount.count) {
                lottoBallMachine.generate()
            }
        this.lottoLines = LottoLines(lottoLines)
    }

    fun returnGameResult(winningNumberInput: String): LottoGameResult {
        val winningLottoLine = LottoLine.makeNewLottoLine(winningNumberInput)
        return lottoLines.extractLottoGameResult(winningLottoLine)
    }

    fun getPurchaseCount(): Int {
        return lottoPurchaseCount.count
    }

    fun getLottoLines(): List<List<Int>> {
        return lottoLines.extractLottoLines()
    }
}
