package lotto.domain

data class Lotto(
    val numbers: List<Int>,
) {
    companion object {
        const val AMOUNT_PER_LOTTO = 1_000
    }
}
