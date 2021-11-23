package lotto.view.dto

import lotto.domain.Scoreboard
import lotto.domain.Lottos

data class ConsoleScoreboardDto(private val scoreboard: Scoreboard, private val lottos: Lottos) {
    val status = scoreboard.toMap()
        .toSortedMap()
        .map { "${it.key.count}개 일치 (${it.key.money.value}원) - ${it.value}개" }

    val yield = scoreboard.totalPrize().value.toDouble() / lottos.totalPrice()
}
