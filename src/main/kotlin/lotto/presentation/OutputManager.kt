package lotto.presentation

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Revenue
import java.math.RoundingMode
import java.text.DecimalFormat

class OutputManager {
    fun printUserPay(pay: Int) {
        println(pay)
    }

    fun printSellLottoCount(userLottos: List<Lotto>) {
        println("${userLottos.size}개를 구매했습니다.")
        userLottos.forEach {
            println(it.getNumbers())
        }
        println()
    }

    fun printResult(result: LottoResult) {
        println(RESULT_MESSAGE)
        println("-------------------------")
        RESULT_MESSAGE_MAP2.keys.forEach {
            println("${RESULT_MESSAGE_MAP2[it]} ${result.getLottoRankingMatchCount(it)}개")
        }
    }

    fun printRevenue(revenue: Double) {
        DECIMAL_FORMAT.roundingMode = RoundingMode.DOWN
        println("총 수익률은 ${DECIMAL_FORMAT.format(revenue)}입니다.")
    }

    companion object {
        private val DECIMAL_FORMAT: DecimalFormat = DecimalFormat("#.##")
        private const val RESULT_MESSAGE: String = "당첨 통계"
        private val RESULT_MESSAGE_MAP2: MutableMap<Revenue, String> = Revenue.values().associate {
            when (it) {
                Revenue.FIVE -> Revenue.FIVE to "3개 일치 (5000원)-"
                Revenue.FOUR -> Revenue.FOUR to "4개 일치 (50000원)-"
                Revenue.THIRD -> Revenue.THIRD to "5개 일치 (1500000원)-"
                Revenue.SECOND -> Revenue.SECOND to "5개 일치, 보너스 볼 일치(30000000원)-"
                Revenue.FIRST -> Revenue.FIRST to "6개 일치 (2000000000원)-"
            }
        }.toMutableMap()
    }
}
