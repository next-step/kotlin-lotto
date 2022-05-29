package com.nextstep.jngcii.lotto.view

import com.nextstep.jngcii.lotto.model.Calculator
import com.nextstep.jngcii.lotto.model.Lotto
import com.nextstep.jngcii.lotto.model.ProfitState
import com.nextstep.jngcii.lotto.model.Rank

object ResultView {
    fun printList(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.prettier)
        }
        println()
    }

    fun printResult(count: Int, ranks: List<Rank>) {
        println("당첨 통계")
        println("---------")

        Rank.values().forEach {
            val match = ranks.count(it)
            println("${it.count}개 일치 (${it.price}원)- ${match}개")
        }

        val rate = Calculator.calculateYield(count, ranks)
        val state = ProfitState.of(rate)
        println("총 수익률은 ${rate}입니다.(기준이 ${ProfitState.ORIGIN_POINT}이기 때문에 결과적으로 ${state.phaseOfPrint} 의미임)")
    }

    private val Lotto.prettier
        get() = "[${this.numbers.joinToString(", ")}]"

    private fun List<Rank>.count(rank: Rank) = this.count { rank == it }

    private val ProfitState.phaseOfPrint
        get() = when (this) {
            ProfitState.LOSS -> "${this.phase}라는"
            else -> "${this.phase}이라는"
        }
}
