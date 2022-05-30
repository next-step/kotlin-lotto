package lotto.domain

class LottoNumber {
    val numbers: Set<Int> = LOTTO_RANGE.toMutableList().shuffled().subList(MIN_LOTTO_INDEX, MAX_LOTTO_INDEX).sorted().toSet()

    companion object {
        private val LOTTO_RANGE = 1..45
        private const val MIN_LOTTO_INDEX = 0
        private const val MAX_LOTTO_INDEX = 6
    }
}
