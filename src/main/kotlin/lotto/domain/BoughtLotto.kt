package lotto.domain

import java.util.EnumMap

class BoughtLotto(
    private val lottos: List<Lotto>,
    private val winningLotto: WinningLotto,
) {
    fun matchResult(): LottoResult {
        val initialRewards = initializeRewards()
        val rewards = lottos
            .map { winningLotto.match(it) }
            .groupingBy { it }
            .eachCount()
        return LottoResult(initialRewards + rewards)
    }

    private fun initializeRewards(): EnumMap<Reward, Int> =
        Reward.entries
            .associateWith { 0 }
            .toMap(EnumMap<Reward, Int>(Reward::class.java))
}
