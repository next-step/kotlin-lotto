package com.nextstep.second.lotto.domain

class LottoPurchase private constructor(
    val autoNumberCount: Int,
    val manualNumberCount: Int
) {
    companion object {
        const val PRICE = 1000

        fun of(money: Int, autoNumberCount: Int): LottoPurchase {
            require(money / PRICE >= autoNumberCount) { "해당 가격으로 원하는 만큼 로또를 구매할 수 없습니다." }
            return LottoPurchase(autoNumberCount, money / PRICE - autoNumberCount)
        }
    }
}
