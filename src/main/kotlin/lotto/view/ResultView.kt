package lotto.view

import lotto.dto.LottoResultDto

object ResultView {
    private const val LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
    private const val LOTTO_RESULT_MESSAGE_TITLE = "당첨 통계"
    private const val LOTTO_RESULT_MESSAGE_DELIMITER = "---------"
    private const val LOTTO_RESULT_DELIMITER = "- "
    private const val LOTTO_RESULT_MATCH_MESSAGE = "개 일치"
    private const val LOTTO_RESULT_WINNING_MONEY_TERMS = "원"
    private const val LOTTO_RESULT_WINNING_MONEY_PREFIX = " ("
    private const val LOTTO_RESULT_WINNING_MONEY_SUFFIX = ")"
    private const val LOTTO_RESULT_COUNT_MESSAGE = "개"
    private const val LOTTO_RESULT_MATCH_BONUS_NUMBER_MESSAGE = ", 보너스 볼 일치"
    private const val LOTTO_RESULT_REVENUE_MESSAGE_PREFIX = "총 수익률은 "
    private const val LOTTO_RESULT_REVENUE_MESSAGE_SUFFIX = "입니다."
    private const val LOTTO_RESULT_REVENUE_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    private const val LOTTO_RESULT_EMPTY_STRING = ""
    private const val REFERENCE_VALUE = 1
    private const val LOTTO_RANK_MISS = 0

    fun printNumberOfLotto(numberOfLotto: Int) {
        println("$numberOfLotto$LOTTO_COUNT_MESSAGE")
    }

    fun printLottos(lottos: List<List<Int>>) {
        lottos.forEach { println(it) }
    }

    fun printFinalResult(lottoResultDto: LottoResultDto) {
        printLottoResultTitle()
        lottoResultDto.getResult().forEach { printLottoResult(it.key.countOfMatch, it.key.winningMoney, it.value, it.key.isSecondPlace()) }
        printProfitRate(lottoResultDto.getProfitRate())
    }

    private fun printLottoResultTitle() {
        println("\n" + LOTTO_RESULT_MESSAGE_TITLE + "\n" + LOTTO_RESULT_MESSAGE_DELIMITER)
    }

    private fun printLottoResult(countOfMatch: Int, winningMoney: Int, count: Int, isSecondPlace: Boolean) {
        if (countOfMatch == LOTTO_RANK_MISS) {
            return
        }
        println(
            countOfMatch.toString() +
                LOTTO_RESULT_MATCH_MESSAGE +
                printMatchBonusNumber(isSecondPlace) +
                LOTTO_RESULT_WINNING_MONEY_PREFIX +
                winningMoney.toString() +
                LOTTO_RESULT_WINNING_MONEY_TERMS +
                LOTTO_RESULT_WINNING_MONEY_SUFFIX +
                LOTTO_RESULT_DELIMITER +
                count.toString() +
                LOTTO_RESULT_COUNT_MESSAGE
        )
    }

    private fun printProfitRate(profitRate: Float) {
        println(
            LOTTO_RESULT_REVENUE_MESSAGE_PREFIX +
                profitRate +
                LOTTO_RESULT_REVENUE_MESSAGE_SUFFIX +
                printResultRevenueLossMessage(profitRate)
        )
    }

    private fun printResultRevenueLossMessage(profitRate: Float): String {
        if (profitRate < REFERENCE_VALUE) {
            return LOTTO_RESULT_REVENUE_LOSS_MESSAGE
        }
        return LOTTO_RESULT_EMPTY_STRING
    }

    private fun printMatchBonusNumber(isSecondPlace: Boolean): String {
        if (isSecondPlace) {
            return LOTTO_RESULT_MATCH_BONUS_NUMBER_MESSAGE
        }
        return LOTTO_RESULT_EMPTY_STRING
    }
}
