package lotto

import java.math.BigDecimal

object InputView {
    private const val LOTTO_NUMBER_DELIMITER = ", "

    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("구입금액을 입력해야 합니다.")
    }

    fun readWinningLottoNumbers(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요. (예. 1, 2, 3, 4, 5, 6)")
        val wonNumbers = readlnOrNull()?.split(LOTTO_NUMBER_DELIMITER)
            ?: throw IllegalArgumentException("당첨 번호를 입력해야 합니다.")
        return wonNumbers.map { LottoNumber(it.toInt()) }
    }

    fun readBonusLottoNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val number = readlnOrNull() ?: throw IllegalArgumentException("보너스 볼을 입력해야 합니다.")
        return LottoNumber(number.toInt())
    }
}

object ResultView {
    fun printLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printLottos(lottos: Lottos) {
        lottos.forEach {
            println(it.lottoNumbers)
        }
    }

    fun printWinnerStatistics(winningLottoPrizeVOs: List<WinningLottoPrizeVO>, totalProfitRate: BigDecimal) {
        val matchedLottos: String = winningLottoPrizeVOs.joinToString("\n") {
            val bonusMatchedText = if (it.bonusMatched) ", 보너스 볼 일치" else ""
            "|${it.matchedCount}개$bonusMatchedText 일치 (${it.prizeAmount}원)- ${it.winningLottoCount}개"
        }

        println(
            """
            |당첨 통계
            |---------
            $matchedLottos
            |총 수익률은 ${totalProfitRate}입니다.
            |""".trimMargin()
        )
    }
}
