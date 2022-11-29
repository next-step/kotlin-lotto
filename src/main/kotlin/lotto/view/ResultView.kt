package lotto.view

object ResultView {
    private const val LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
    private const val LOTTO_NUMBER_DELIMITER = ", "
    private const val LOTTO_NUMBER_PREFIX = "["
    private const val LOTTO_NUMBER_SUFFIX = "]"
    private const val LOTTO_RESULT_MESSAGE_TITLE = "당첨 통계"
    private const val LOTTO_RESULT_MESSAGE_DELIMITER = "---------"
    private const val LOTTO_RESULT_DELIMITER = " - "
    private const val LOTTO_RESULT_MATCH_MESSAGE = "개 일치"
    private const val LOTTO_RESULT_WINNING_MONEY_TERMS = "원"
    private const val LOTTO_RESULT_WINNING_MONEY_PREFIX = "("
    private const val LOTTO_RESULT_WINNING_MONEY_SUFFIX = ")"
    private const val LOTTO_RESULT_COUNT_MESSAGE = "개"
    private const val LOTTO_RESULT_REVENUE_MESSAGE_PREFIX = "총 수익률은 "
    private const val LOTTO_RESULT_REVENUE_MESSAGE_SUFFIX = "입니다."
    private const val LOTTO_RESULT_REVENUE_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"

    fun printNumberOfLotto(numberOfLotto: Int) {
        println("$numberOfLotto$LOTTO_COUNT_MESSAGE")
    }

    fun printLottoNumbersList(lottoNumbersList: List<List<Int>>) {
        lottoNumbersList.forEach { printLottoNumbers(it) }
    }

    private fun printLottoNumbers(numbers: List<Int>) {
        println(LOTTO_NUMBER_PREFIX + numbers.joinToString(LOTTO_NUMBER_DELIMITER) + LOTTO_NUMBER_SUFFIX)
    }

    fun printLottoResultTitle() {
        println("\n" + LOTTO_RESULT_MESSAGE_TITLE + "\n" + LOTTO_RESULT_MESSAGE_DELIMITER)
    }

    fun printLottoResult(countOfMatch: Int, winningMoney: Int, count: Int) {
        println(
            countOfMatch.toString() +
                LOTTO_RESULT_MATCH_MESSAGE +
                LOTTO_RESULT_DELIMITER +
                winningMoney.toString() +
                LOTTO_RESULT_WINNING_MONEY_TERMS +
                LOTTO_RESULT_WINNING_MONEY_PREFIX +
                count.toString() +
                LOTTO_RESULT_COUNT_MESSAGE +
                LOTTO_RESULT_WINNING_MONEY_SUFFIX
        )
    }

    fun printProfitRate(profitRate: Float) {
        println(
            LOTTO_RESULT_REVENUE_MESSAGE_PREFIX +
                profitRate +
                LOTTO_RESULT_REVENUE_MESSAGE_SUFFIX +
                printResultRevenueLossMessage(profitRate)
        )
    }

    private fun printResultRevenueLossMessage(profitRate: Float): String {
        if (profitRate < 1) {
            return LOTTO_RESULT_REVENUE_LOSS_MESSAGE
        }
        return ""
    }
}
