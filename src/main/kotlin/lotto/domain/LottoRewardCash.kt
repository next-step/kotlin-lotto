package lotto.domain

import lotto.argumentError

class LottoRewardCash(
    private val value: Int
) {
    init {
        check(value >= 0) { argumentError("로또 당첨금은 0원 아래일 수 없습니다.") }
    }

    override fun toString(): String {
        return "$value"
    }

    fun calculateYield(cash: Cash): Long {
        return value.toLong() / cash.getAmount()
    }
}
