package lotto.ui.view

import lotto.domain.Lottos
import lotto.domain.Rank
import lotto.domain.RoundResult
import lotto.domain.Ticket

fun printTicketInfo(ticket: Ticket) {
    println("수동으로 ${ticket.manualLottoSize}장, 자동으로 ${ticket.autoLottoSize}장을 구매했습니다.")
}

fun printLottos(lottos: Lottos) {
    lottos.elements.forEach {lotto ->
        println(
            "[" +
            lotto.lottoNumbers.joinToString(", ") { it.toString() } +
            "]"
        )
    }
    println("\n")
}

fun printLottoResult(roundResult: RoundResult, earningRate: Double) {
    println(
        "당첨 결과\n" +
            "---------\n" +
            "3개 일치 (5000원)- ${roundResult.getCountOfRank(Rank.FIFTH)}개\n" +
            "4개 일치 (50000원)- ${roundResult.getCountOfRank(Rank.FOURTH)}개\n" +
            "5개 일치 (1500000원)- ${roundResult.getCountOfRank(Rank.THIRD)}개\n" +
            "5개 일치, 보너스 볼 일치(30000000원)- ${roundResult.getCountOfRank(Rank.SECOND)}개\n" +
            "6개 일치 (2000000000원)- ${roundResult.getCountOfRank(Rank.FIRST)}개\n" +
            "총 수익률은 ${earningRate}입니다."
    )
    println("\n")
}
