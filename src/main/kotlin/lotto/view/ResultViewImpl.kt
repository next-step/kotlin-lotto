package lotto.view

import lotto.adapter.LottoDto
import lotto.adapter.LottoResultDto
import lotto.adapter.ProfitRateDto
import kotlin.math.floor

class ResultViewImpl : ResultView {
    override fun printBoughtLotto(lottos: List<LottoDto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println("[${it.numbers.joinToString(", ")}]")
        }
        println()
    }

    override fun printLottoResults(results: List<LottoResultDto>) {
        println("\n당첨 통계\n---------")
        results.forEach {
            println("${it.name} (${it.price}원) - ${it.count}개")
        }
    }

    override fun printProfitRate(profitRate: ProfitRateDto) {
        val builder: StringBuilder = StringBuilder()
        builder.append("총 수익률은 ${floor(profitRate.profitRate * 100) / 100}입니다.")

        when {
            profitRate.profitRate > profitRate.criterion ->
                builder.append("(기준이 ${profitRate.criterion}이기 때문에 결과적으로 이익이라는 의미임)")
            profitRate.profitRate < profitRate.criterion ->
                builder.append("(기준이 ${profitRate.criterion}이기 때문에 결과적으로 손해라는 의미임)")
            else -> builder.append("(기준이 ${profitRate.criterion}이기 때문에 결과적으로 원금라는 의미임)")
        }
        println(builder.toString())
    }
}
