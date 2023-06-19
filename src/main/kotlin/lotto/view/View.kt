package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.vo.WinningLottoPrizeVO
import java.math.BigDecimal

object InputView {
    private const val LOTTO_NUMBER_DELIMITER = ", "

    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("구입금액을 입력해야 합니다.")
    }

    fun readManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("수동으로 구매할 로또 수를 입력해야 합니다.")
    }

    fun readManualLottos(manualLottoCount: Int): Lottos {
        println("수동으로 구매할 번호를 입력해 주세요. (예. 1, 2, 3, 4, 5, 6)")
        return Lottos(List(manualLottoCount) {
            val manualNumbers = readlnOrNull()?.split(LOTTO_NUMBER_DELIMITER)
                ?: throw IllegalArgumentException("수동으로 구매할 번호를 입력해야 합니다.")
            Lotto(manualNumbers.map { LottoNumber(it.toInt()) })
        })
    }

    fun readWinningLottoNumbers(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요. (예. 1, 2, 3, 4, 5, 6)")
        val winningNumbers = readlnOrNull()?.split(LOTTO_NUMBER_DELIMITER)
            ?: throw IllegalArgumentException("당첨 번호를 입력해야 합니다.")
        return winningNumbers.map { LottoNumber(it.toInt()) }
    }

    fun readBonusLottoNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val number = readlnOrNull() ?: throw IllegalArgumentException("보너스 볼을 입력해야 합니다.")
        return LottoNumber(number.toInt())
    }
}

object ResultView {
    fun printLottos(lottos: Lottos, manualLottoCount: Int) {
        println("수동으로 ${manualLottoCount}장, 자동으로 ${lottos.size - manualLottoCount}개를 구매했습니다.")
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
