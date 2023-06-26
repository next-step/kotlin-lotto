package lotto.domain

data class LottoResult(
    val result: Map<Int, LottoList>
) {
    companion object {
        val prizeMoneyMap = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 2000000000
        )
    }
}
