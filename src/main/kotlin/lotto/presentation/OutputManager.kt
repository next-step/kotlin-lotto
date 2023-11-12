package lotto.presentation

import lotto.domain.Lotto
import lotto.domain.LottoResult

class OutputManager {
    fun printUserPay(pay: Int) {
        println(pay)
    }

    fun printSellLottoCount(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.getNumbers())
        }
        println()
    }

    fun printResult(result: LottoResult) {
        println(RESULT_MESSAGE)
        println("-------------------------")
        (START_NUMBER until END_NUMBER).forEach {
            println("${RESULT_MESSAGE_MAP[it]} ${result.getLottoResult(it)}개")
        }
    }

    companion object {
        private const val START_NUMBER: Int = 3
        private const val END_NUMBER: Int = 7
        private const val RESULT_MESSAGE: String = "당첨 통계"
        private val RESULT_MESSAGE_MAP: HashMap<Int, String> = hashMapOf(
            3 to "3개 일치 (5000원)-",
            4 to "4개 일치 (50000원)-",
            5 to "5개 일치 (1500000원)-",
            6 to "6개 일치 (2000000000원)-"
        )
    }
}
