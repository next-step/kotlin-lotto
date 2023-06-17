package lotto

import java.math.BigDecimal

object InputView {
    private const val LOTTO_NUMBER_DELIMITER = ", "

    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("구입금액을 입력해야 합니다.")
    }

    fun readWinningLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요. (예. 1, 2, 3, 4, 5, 6)")
        val wonNumbers = readlnOrNull()?.split(LOTTO_NUMBER_DELIMITER)
            ?: throw IllegalArgumentException("당첨 번호를 입력해야 합니다.")
        return Lotto(wonNumbers.map { LottoNumber(it.toInt()) })
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
            "|${it.matchedCount}개 일치 (${it.prizeAmount}원)- ${it.winningLottoCount}개"
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
