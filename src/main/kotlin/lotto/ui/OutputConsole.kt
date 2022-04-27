package lotto.ui

import lotto.domain.rank.LottoRank.LAST_PLACE
import lotto.domain.ticket.LottoGame
import lotto.domain.ticket.WinningStatistics

object OutputConsole : Output {
    private const val BREAK_EVEN = 1

    override fun outputRequestToEnterHowManyBuyLottoGames() {
        println("구입 금액을 입력해 주세요.")
    }

    override fun outputNumberOfLottoGames(numberOfLottoGames: Int) {
        println("$numberOfLottoGames 를 구매했습니다.")
    }

    override fun outputNumberOfLottoGames(lottoGames: List<LottoGame>) {
        println("${lottoGames.size}개를 구매했습니다.")
        lottoGames.forEach {
            println(it)
        }
    }

    override fun outputWinningNumbersLastWeek() {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
    }

    override fun outputLottoGameResult(winningStatistics: WinningStatistics) {
        println("\n당첨 통계")
        println("---------")

        winningStatistics.rankMap
            .filter { entry ->
                entry.key != LAST_PLACE
            }
            .forEach { (rank, count) ->
                println("${rank.lottoMatching.matchingCount}개 일치 (${rank.prize}) - ${count}개")
            }

        println(
            "총 수익률은 ${winningStatistics.profitRate}입니다." +
                if (winningStatistics.profitRate < BREAK_EVEN) " (기준이 ${BREAK_EVEN}이기 때문에 결과적으로 손해라는 의미임)"
                else ""
        )
    }
}
