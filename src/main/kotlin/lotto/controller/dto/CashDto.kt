package lotto.controller.dto

import lotto.domain.Cash

data class CashDto(
    val input: Int
) {
    fun toCash(): Cash {
        return Cash(input)
    }
}
