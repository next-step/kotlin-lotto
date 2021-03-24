package lotto.userinterface

import lotto.dto.LottoNumbersDto
import lotto.dto.StatisticsDto

class Console : UserInterface {
    override fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val money = readLine()?.toIntOrNull() ?: inputPurchaseAmount()
        return if (money > 0 && money % 1000 == 0) money else inputPurchaseAmount()
    }

    override fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val lottoCount = readLine()?.toIntOrNull() ?: inputManualLottoCount()
        return if (lottoCount >= 0) lottoCount else inputManualLottoCount()
    }

    override fun inputManualLottoNumbers(count: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..count).map { inputManualLottoNumber() }
    }

    private fun inputManualLottoNumber(retry: Boolean = false): List<Int> {
        if (retry) println("로또번호를 잘못 입력하셨습니다. 다시 입력해 주세요.")
        val lottoNumbers = readLine()
            ?.split(MANUAL_LOTTO_NUMBERS_DELIMITER)
            ?.map { it.trim() }
            ?.mapNotNull { it.toIntOrNull() }
            ?.filter { it in 1..45 }
            ?.distinct()
            ?: listOf()
        return if (lottoNumbers.size == 6) lottoNumbers else inputManualLottoNumber(retry = true)
    }

    override fun inputLastWeekWinningLottoNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningLotto = readLine()
            ?.split(WINNING_LOTTO_NUMBERS_DELIMITER)
            ?.map { it.trim() }
            ?.mapNotNull { it.toIntOrNull() }
            ?.filter { it in 1..45 }
            ?.distinct()
            ?: listOf()
        return if (winningLotto.size == 6) winningLotto
        else {
            println("로또번호를 잘못 입력하셨습니다. 다시 입력해 주세요.")
            inputLastWeekWinningLottoNumbers()
        }
    }

    override fun inputLastWeekWinningLottoBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine()?.toIntOrNull() ?: inputLastWeekWinningLottoBonusNumber()
        return if (bonusNumber in 1..45) bonusNumber else inputLastWeekWinningLottoBonusNumber()
    }

    override fun outputPurchasedMessage(dto: LottoNumbersDto) {
        println("수동으로 ${dto.manualLottoCount}장, 자동으로 ${dto.randomLottoCount}개를 구매했습니다.")
        dto.lottos.forEach { println(it) }
    }

    override fun outputWinningStatistics(dto: StatisticsDto) {
        println("당첨 통계")
        println("---------")

        dto.prizeRankCount.forEach { println("${matchingCountMessage(it.matchedCount)} (${it.reward}원)- ${it.winnerCount}개") }

        println("총 수익률은 ${dto.profitRate}입니다.")
    }

    private fun matchingCountMessage(matchedCount: Int): String {
        var message = "$matchedCount 개 일치"

        if (matchedCount == 2) {
            message += ", 보너스 볼 일치"
        }

        return message
    }

    companion object {
        private const val WINNING_LOTTO_NUMBERS_DELIMITER = ","
        private const val MANUAL_LOTTO_NUMBERS_DELIMITER = ","
    }
}
