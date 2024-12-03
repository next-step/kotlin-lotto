package lotto.domain

data class LottoNumbers(
    val numbers: List<Int>,
) {
    companion object {
        const val START_INDEX = 0
        const val LOTTO_NUMBER_COUNT = 6
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
