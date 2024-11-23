package lotto.domain

class LottoUser(
    val lottoPurchaseAmount: LottoPurchaseAmount,
) {
    private val lottoCount = lottoPurchaseAmount.calculateLottoCount()
    val lotteries: List<Lotto> = List(lottoCount) { Lotto() }

    fun checkLotteries(correctNumbers: CorrectNumbers) {
        lotteries.forEach { lotto ->
            val lottoNumbers = lotto.values
            val correctCount = lottoNumbers.intersect(correctNumbers.values).size

            lotto.markCorrectCount(correctCount)
        }
    }
}
