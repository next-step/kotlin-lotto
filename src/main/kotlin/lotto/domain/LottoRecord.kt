package lotto.domain

import lotto.enums.Rank

class LottoRecord(
    val rank: Rank,
    quantity: Int = 0,
) {
    init {
        require(quantity > 0) {
            "등급별 수량은 0이상입니다."
        }
    }

    var quantity = quantity
        private set

    fun matchCount(): Int {
        return rank.matchCount
    }

    fun addQuantity() {
        quantity++
    }

    fun reward(): Int {
        return rank.reward
    }

    fun totalReward(): Int {
        return rank.reward * quantity
    }
}