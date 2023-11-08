package lotto.dto

import lotto.domain.LottoNumbers.Companion.LOTTO_PRICE

class ImmutableMoney private constructor(val money: Int) {

    init {
        require(money >= 0) { "돈은 0원 이상이어야 합니다." }
    }

    fun buy(count: Int) = of(this.money - LOTTO_MONEY.money * count)

    fun buyAll() = this.money / LOTTO_MONEY.money

    companion object {
        val LOTTO_MONEY = of(LOTTO_PRICE)
        fun of(money: Int) = ImmutableMoney(money)
    }
}
