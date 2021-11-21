package lotto.ui

import lotto.domain.Lotteries
import lotto.domain.Lottery
import lotto.domain.LotteryStatistics
import lotto.domain.LotteryYield
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Ranking
import java.lang.StringBuilder

const val LINE_FEED = "\n"
const val LINE = "--------------------------------------"

object LottoView {

    fun input(): Int = readLine()?.toIntOrNull() ?: 0

    fun inputNumbers(): List<Int> = readLine()?.split(DELIMITER)?.map { it.trim().toInt() } ?: listOf()

    fun inputPrompt() {
        println("구매금액을 입력해 주세요.")
    }

    fun inputBonusBallPrompt() {
        println("보너스 볼을 입력해 주세요.")
    }

    fun inputManualCountPrompt(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return input()
    }

    fun inputSelectedLottoNumbersPrompt(counts: Int): List<LottoNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return (1..counts)
            .map { inputManualLottoNumbers() }
            .run { toList() }
    }

    private fun inputManualLottoNumbers(): LottoNumbers {
        return inputNumbers()
            .map { LottoNumber.of(it) }
            .run { LottoNumbers.of(this) }
    }

    fun displayLotteries(lotteries: Lotteries) {
        println("${lotteries.values.size}개를 구매했습니다.")
        println(showLotteries(lotteries))
        println("당첨 번호 입력")
    }

    fun displayStatistics(statistics: LotteryStatistics, lotteryYield: LotteryYield) {
        println(STATISTICS_INTRO)
        println(showStatistics(statistics))
        println(showYield(lotteryYield))
    }

    private fun showLotteries(lotteries: Lotteries): String {
        val result = StringBuilder()
        lotteries.values.forEach { result.append("[${showLottery(it)}]").append("\n") }
        return result.toString()
    }

    private fun showLottery(lottery: Lottery): String {
        return lottery.numbers.values.joinToString { it.value.toString() }
    }

    private fun showStatistics(statistics: LotteryStatistics): String {
        val result = StringBuilder()
        statistics.values.entries
            .filter { entry -> !Ranking.isNone(entry.key) }
            .forEach { (key, value) ->
                result.append("${key.matches}개 일치${if (Ranking.isSecond(key)) ",보너스 볼 일치" else ""} (${key.reward.value}원)- ${value}개")
                    .append(LINE_FEED)
            }
        return result.toString()
    }

    private fun showYield(lotteryYield: LotteryYield): String {
        return "총 수익률은  ${lotteryYield.ratio}입니다."
    }

    private const val STATISTICS_INTRO = "당첨 통계 $LINE_FEED $LINE"

    private const val DELIMITER = ","
}
