package lotto.domain

import lotto.dto.LottoPrice

class LottoResult {

    private val result = LottoPrice.values().associateWith { 0 }.toMutableMap()

    fun updateExact(exact: LottoPrice) {
        result.computeIfPresent(exact) { _, v -> v + 1 }
    }

    fun getExact(exact: LottoPrice) = result[exact]

    fun getPrice() = result.map { it.key.price * it.value }.sum()
}
