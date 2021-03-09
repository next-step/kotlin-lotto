package lotto.view

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Rank
import lotto.domain.Result

fun printLottos(lottos: Lottos) {
    println(String.format("%d개를 구매했습니다.", lottos.elements.size))
    lottos.elements.forEach { printLotto(it) }
    println()
}

private fun printLotto(lotto: Lotto) = println(lotto.elements.joinToString { "${it.value}" })

fun printResult(result: Result) {
    Rank.values().reversed().forEach {
        println(
            String.format(
                "%d개 일치(%d원) - %d개",
                it.matchCount,
                it.prizeMoney.value,
                result.elements[it] ?: 0
            )
        )
    }
}
