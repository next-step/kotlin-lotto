package lotto.view

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Rank
import lotto.domain.Result
import lotto.domain.Statistics

fun printLottos(lottos: Lottos) {
    println("${lottos.elements.size}개를 구매했습니다.")
    lottos.elements.forEach { printLotto(it) }
    println()
}

private fun printLotto(lotto: Lotto) = println(lotto.elements.joinToString { "${it.value}" })

fun printResult(result: Result) {
    Rank.values().reversed().forEach {
        println(
            if (Rank.SECOND == it) {
                "${it.matchCount}개 일치, 보너스 넘버 일치 ${it.prizeMoney.value}원) - ${result.elements[it] ?: 0}개"
            } else {
                "${it.matchCount}개 일치(${it.prizeMoney.value}원) - ${result.elements[it] ?: 0}개"
            }
        )
    }
}

fun printStatistics(statistics: Statistics) {
    println("총 수익률은 ${statistics.value} 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
}
