package lotto.view

import lotto.domain.LottoMatchResult

class ResultView(private val output: Output) {

    fun print(results: List<LottoMatchResult>) {
        output.print("당첨 통계")
        output.print("---------")

        results.forEach {
            output.print(
                "${it.matchCount}개 일치${if (it.bonus) ", 보너스 볼 일치" else " "}(${it.price.amount}원)- ${it.winCount}개"
            )
        }
    }
}
