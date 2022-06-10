package com.nextstep.jngcii.lotto.view

import com.nextstep.jngcii.lotto.model.Calculator
import com.nextstep.jngcii.lotto.model.Lotto
import com.nextstep.jngcii.lotto.model.ProfitState
import com.nextstep.jngcii.lotto.model.Rank
import com.nextstep.jngcii.lotto.model.Ranks

object ResultView {
    fun printList(passiveLottos: List<Lotto>, autoLottos: List<Lotto>) {
        println("수동으로 ${passiveLottos.size}개, 자동으로 ${autoLottos.size}를 구매했습니다.")

        passiveLottos.forEach {
            println("[${it.numbers.joinToString(", ")}]")
        }
        autoLottos.forEach {
            println("[${it.numbers.joinToString(", ")}]")
        }

        println()
    }

    fun printResult(ranks: Ranks) {
        println("당첨 통계")
        println("---------")

        Rank.firstToFifth.forEach {
            val match = ranks.countOf(it)
            val secondPhase = if (it.isSecond) ", 보너스 볼 일치" else ""
            println("${it.count}개 일치$secondPhase (${it.price}원)- ${match}개")
        }

        val rate = Calculator.calculateYield(ranks)
        val state = ProfitState.of(rate)
        println("총 수익률은 ${rate}입니다.(기준이 ${ProfitState.ORIGIN_POINT}이기 때문에 결과적으로 ${state.phaseOfPrint} 의미임)")
    }

    private val ProfitState.phaseOfPrint
        get() = when (this) {
            ProfitState.LOSS -> "${this.phase}라는"
            else -> "${this.phase}이라는"
        }
}
