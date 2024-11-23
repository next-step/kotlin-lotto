package lotto.adapter

import lotto.domain.LottoPurchaseAmount

class LottoInputAdapter {
    fun adaptPurchaseAmount(input: String): LottoPurchaseAmount {
        val amount = input.toInt()
        return LottoPurchaseAmount(amount)
    }

    fun adaptWinningNumbers(input: String): List<Int> {
        return input.split(",")
            .map { it.trim().toInt() }
    }
}
