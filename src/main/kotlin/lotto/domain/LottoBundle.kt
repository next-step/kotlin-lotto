package lotto.domain

import lotto.enums.Rank
import lotto.service.NumberCreateStrategy

class LottoBundle(
    val bundle: List<Lotto>
) {
    fun findAllByMatchRanks(winningLotto: WinningLotto): List<Rank> {
        val countAndBonusByRank = mutableListOf<Rank>()

        bundle.forEach { lotto ->
            val countByNumbers = lotto.makeMatchCountByNumbers(winningLotto.winningLotto)//0~6개
            val isHaveBonus = lotto.isMatchBonus(winningLotto.bonusNumber)
            val findRank = Rank.valueOf(countByNumbers, isHaveBonus)
            countAndBonusByRank.add(findRank)
        }
        return countAndBonusByRank
    }

    companion object {
        fun of(
            quantity: Int,
            strategy: NumberCreateStrategy
        ): LottoBundle {
            val numbersByQuantity = strategy.makeNumbersByQuantity(quantity)

            return List(numbersByQuantity.size) { index ->
                Lotto.from(numbersByQuantity[index].randomNumbers)
            }.let {
                LottoBundle(it)
            }
        }
    }
}
