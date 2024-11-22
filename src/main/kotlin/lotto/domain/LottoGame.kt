package lotto.domain

class LottoGame(private val lottoPurchaseAmount: LottoPurchaseAmount, private val lottoBallMachine: LottoBallMachine) {
    private val lottoPurchaseCount: LottoPurchaseCount = lottoPurchaseAmount.toLottoPurchaseCount()
    private val lottoLines: LottoLines

    init {

        val lottoLines =
            List(lottoPurchaseCount.count) {
                lottoBallMachine.generate()
            }
        this.lottoLines = LottoLines(lottoLines)
    }

    fun returnGameResult(winningNumbers: List<Int>): LottoGameResult {
        val winningLottoLine = LottoLine.makeNewLottoLine(winningNumbers)
        return lottoLines.extractLottoGameResult(winningLottoLine)
    }

    fun getPurchaseCount(): Int {
        return lottoPurchaseCount.count
    }

    fun getLottoLines(): List<List<Int>> {
        return lottoLines.extractLottoLines()
    }
}
