package lotto.view

class ResultView {
    fun renderPurchaseLottoCountOutput(lottoCount: Int) = render(lottoCount.toString() + PURCHASE_LOTTO_COUNT)

    fun renderPurchaseLottoNumbersOutput(lottoNumbers: List<Int>) = render(lottoNumbers.toString())

    fun renderResultOutput() = render(RESULT)

    fun renderLottoMatchResultOutput(
        prizeCount: Int,
        prizeAmount: Int,
        matchingCount: Int,
    ) {
        render("${prizeCount}개 일치 (${prizeAmount}원)- ${matchingCount}개")
    }

    fun renderLottoProfit(rate: Double) {
        render("총 수익률은 ${rate}입니다.")
    }

    private fun render(message: String) {
        println(message)
    }

    private companion object {
        const val PURCHASE_LOTTO_COUNT = "개를 구매했습니다."
        const val RESULT = "당첨 통계\n" + "--------"
    }
}
