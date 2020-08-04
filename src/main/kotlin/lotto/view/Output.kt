package lotto.view

import lotto.domain.LottoSingleLine
import lotto.domain.ResultData

fun printLottoTicket(list: List<LottoSingleLine>) {
    println("${list.size}개를 구입했습니다.")
    list.forEach {
        println("${it.getNumbers()}")
    }
}

fun printResult(resultData: ResultData, money: Int) {
    print(
        """
            당첨 통계
            ---------
            3개 일치 (5000원)- ${resultData.fourth}개
            4개 일치 (50000원)- ${resultData.third}개
            5개 일치 (1500000원)- ${resultData.second}개
            6개 일치 (2000000000원)- ${resultData.first}개
            총 수익률은 ${resultData.price / money}입니다.(기준이 1)
        """.trimIndent()
    )
}
