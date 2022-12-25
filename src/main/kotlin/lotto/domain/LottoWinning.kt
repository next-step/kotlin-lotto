package lotto.domain

data class LottoWinning(
    val result: Map<Int, Int>,
) {
    fun totalAmount(): Long {
        var totalAmount = 0L
        result.entries.map {
            totalAmount += WinningAmount.from(it.key).amount * it.value
        }

        return totalAmount
    }
}
