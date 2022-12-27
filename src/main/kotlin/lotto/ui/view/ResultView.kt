package lotto.ui.view

import lotto.domain.Lottos
import lotto.domain.Rank
import lotto.domain.RoundResult
import lotto.domain.Ticket

fun printTicketInfo(ticket: Ticket) {
    println("수동으로 ${ticket.manualLottoSize}장, 자동으로 ${ticket.autoLottoSize}장을 구매했습니다.")
}

fun printLottos(lottos: Lottos) {
    lottos.elements.forEach { lotto ->
        println(
            "[" +
                lotto.lottoNumbers.joinToString(", ") { it.toString() } +
                "]"
        )
    }
    println("\n")
}

fun printLottoResult(roundResult: RoundResult, earningRate: Double) {
    println("당첨결과")
    println("===============")
    Rank.values()
        .filter { it != Rank.MISS }
        .forEach {
            var result = "${it.score.matchedCount}개 일치 " +
                (if (it.score.matchedBonus) "보너스 볼 일치 " else "") +
                "(${it.rewardPrice}원) - ${roundResult.getCountOfRank(it)}개"

            println(result)
        }

    println("총 수익률은 ${earningRate}입니다.")
}
