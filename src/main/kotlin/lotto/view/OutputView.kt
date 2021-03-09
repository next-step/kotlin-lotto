package lotto.view

import lotto.domain.*

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

fun printYield(yield: Yield) {
    println(String.format("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", `yield`.value))
}
