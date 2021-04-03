package lotto.userinterface

import lotto.dto.LottoNumbersDto
import lotto.dto.PrizeRankCountDto
import lotto.dto.StatisticsDto
import lotto.dto.WinningLottoDto

class Console : UserInterface {
    override tailrec fun inputPurchaseAmount(lottoPrice: Int): Int {
        println("구입금액을 입력해 주세요.")
        val money = readLine()?.toIntOrNull()

        if (money == null || money <= 0 || money % lottoPrice != 0) {
            return inputPurchaseAmount(lottoPrice)
        }

        return money
    }

    override fun inputManualLottoNumbers(): List<List<Int>> {
        val manualLottoCount = inputManualLottoCount()

        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..manualLottoCount).map { inputLottoNumber() }
    }

    private tailrec fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val lottoCount = readLine()?.toIntOrNull()

        if (lottoCount == null || lottoCount < 0) {
            return inputManualLottoCount()
        }

        return lottoCount
    }

    private tailrec fun inputLottoNumber(): List<Int> {
        val lottoNumbers = readLine()
            ?.split(LOTTO_NUMBERS_DELIMITER)
            ?.map { it.trim() }
            ?.mapNotNull { it.toIntOrNull() }
            ?.filter { it in LOTTO_NUMBER_RANGE }
            ?.distinct()
            ?: emptyList()

        if (lottoNumbers.size != 6) {
            println("로또번호를 잘못 입력하셨습니다. 다시 입력해 주세요.")
            return inputLottoNumber()
        }

        return lottoNumbers
    }

    override fun inputLastWeekWinningLotto(): WinningLottoDto {
        val lottoNumbers = inputLastWeekWinningLottoNumbers()
        val bonusNumber = inputLastWeekWinningLottoBonusNumber(lottoNumbers)
        return WinningLottoDto(lottoNumbers, bonusNumber)
    }

    private fun inputLastWeekWinningLottoNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return inputLottoNumber()
    }

    private tailrec fun inputLastWeekWinningLottoBonusNumber(lottoNumbers: List<Int>): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine()?.toIntOrNull()

        if (bonusNumber == null || bonusNumber !in LOTTO_NUMBER_RANGE || bonusNumber in lottoNumbers)
            return inputLastWeekWinningLottoBonusNumber(lottoNumbers)

        return bonusNumber
    }

    override fun outputPurchasedMessage(dto: LottoNumbersDto) {
        println("수동으로 ${dto.manualLottoCount}장, 자동으로 ${dto.randomLottoCount}개를 구매했습니다.")
        dto.lottos.forEach { println(it) }
    }

    override fun outputWinningStatistics(dto: StatisticsDto) {
        val winningStatisticsMessage =
            """
                |당첨 통계 
                |--------- 
                |${dto.prizeRankCount.joinToString(System.lineSeparator()) { it.toView() }} 
                |총 수익률은 ${dto.profitRate}입니다.
            """.trimMargin()

        println(winningStatisticsMessage)
    }

    private fun PrizeRankCountDto.toView(): CharSequence =
        "${matchingCountMessage(this.matchedCount)} (${this.reward}원)- ${this.winnerCount}개"

    private fun matchingCountMessage(matchedCount: Int): String {
        var message = "$matchedCount 개 일치"

        if (matchedCount == 2) {
            message += ", 보너스 볼 일치"
        }

        return message
    }

    companion object {
        private const val LOTTO_NUMBERS_DELIMITER = ","
        private val LOTTO_NUMBER_RANGE = (1..45)
    }
}
