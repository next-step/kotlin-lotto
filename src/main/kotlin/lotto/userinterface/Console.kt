package lotto.userinterface

import lotto.domain.LottoPrize
import lotto.dto.LottoNumbersDto
import lotto.dto.StatisticsDto

class Console : UserInterface {
    override fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toInt() ?: 0
    }

    override tailrec fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()?.toInt() ?: inputManualLottoCount()
    }

    override fun inputManualLottoNumbers(count: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..count).map { inputManualLottoNumber() }
    }

    private fun inputManualLottoNumber(retry: Boolean = false): List<Int> {
        if (retry) println("로또번호를 잘못 입력하셨습니다. 다시 입력해 주세요.")
        return readLine()
            ?.split(MANUAL_LOTTO_NUMBERS_DELIMITER)
            ?.map { it.trim() }
            ?.map { it.toInt() }
            ?: inputManualLottoNumber(retry = true)
    }

    override fun inputLastWeekWinningLottoNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()?.split(WINNING_LOTTO_NUMBERS_DELIMITER)
            ?.map { it.trim() }
            ?.map { it.toInt() }
            ?: listOf()
    }

    override fun inputLastWeekWinningLottoBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readLine()?.toInt() ?: 0
    }

    override fun outputPurchasedMessage(dto: LottoNumbersDto) {
        println("수동으로 ${dto.manualLottoCount}장, 자동으로 ${dto.randomLottoCount}개를 구매했습니다.")
        dto.lottos.forEach { println(it) }
    }

    override fun outputWinningStatistics(dto: StatisticsDto) {
        println("당첨 통계")
        println("---------")

        dto.prizeRankCount.forEach { println("${matchingCountMessage(it.key)} (${it.key.reward}원)- ${it.value}개") }

        println("총 수익률은 ${dto.profitRate}입니다.")
    }

    private fun matchingCountMessage(lottoPrize: LottoPrize): String {
        var message = "${lottoPrize.count}개 일치"

        if (lottoPrize == LottoPrize.SECOND_PRIZE) {
            message += ", 보너스 볼 일치"
        }

        return message
    }

    companion object {
        private const val WINNING_LOTTO_NUMBERS_DELIMITER = ","
        private const val MANUAL_LOTTO_NUMBERS_DELIMITER = ","
    }
}
