package lotto.domain

import Lottos

object LottoFactory {
    fun create(count: Int): Lottos {
        val tickets = (1..count).map { LottoRandomGenerator.randomGenerate() }
        return Lottos(tickets)
    }
}
