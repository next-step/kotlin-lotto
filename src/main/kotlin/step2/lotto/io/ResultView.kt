package step2.lotto.io

import step2.lotto.domain.MatchResult
import step2.lotto.domain.PlayInfo
import step2.lotto.domain.PlayResults

object ResultView {
    private const val MATCHED_RESULT_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개"
    private const val FINAL_PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f입니다."
    private const val WINNING_STATISTICS_TITLE = "당첨 통계\n---------"

    fun printResult(playInfo: PlayInfo, playResults: PlayResults) {
        printEachLotto(playResults)
        printWinningStatistics(playInfo, playResults)
    }

    private fun printEachLotto(playResults: PlayResults) {
        playResults.elements.forEach {
            println(it.lotto)
        }
    }

    private fun printWinningStatistics(playInfo: PlayInfo, playResults: PlayResults) {
        println(WINNING_STATISTICS_TITLE)
        println(MATCHED_RESULT_MESSAGE_FORMAT.format(MatchResult.FOURTH_PLACE.matchCount, MatchResult.FOURTH_PLACE.reward, playResults.fourthPlaceCount))
        println(MATCHED_RESULT_MESSAGE_FORMAT.format(MatchResult.THIRD_PLACE.matchCount, MatchResult.THIRD_PLACE.reward, playResults.thirdPlaceCount))
        println(MATCHED_RESULT_MESSAGE_FORMAT.format(MatchResult.SECOND_PLACE.matchCount, MatchResult.SECOND_PLACE.reward, playResults.secondPlaceCount))
        println(MATCHED_RESULT_MESSAGE_FORMAT.format(MatchResult.FIRST_PLACE.matchCount, MatchResult.FIRST_PLACE.reward, playResults.firstPlaceCount))
        println(FINAL_PROFIT_RATE_MESSAGE_FORMAT.format(playResults.calculateProfitRate(playInfo.buyAmount)))
    }
}
