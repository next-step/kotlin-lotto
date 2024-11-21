package lotto

class LottoGame(private val purchaseInput: String, private val lottoBallMachine: LottoBallMachine) {
    private val lottoPurchaseCount: LottoPurchaseCount
    private val lottoLines: LottoLines

    init {
        val lottoPurchaseAmount = LottoPurchaseAmount(purchaseInput.toInt())
        this.lottoPurchaseCount = lottoPurchaseAmount.toLottoPurchaseCount()

        val lottoLines =
            List(lottoPurchaseCount.count) {
                lottoBallMachine.generate()
            }
        this.lottoLines = LottoLines(lottoLines)
    }

    fun getPurchaseCount(): Int {
        return lottoPurchaseCount.count
    }

    fun getLottoLines(): List<List<Int>> {
        return lottoLines.extractLottoLines()
    }
}
