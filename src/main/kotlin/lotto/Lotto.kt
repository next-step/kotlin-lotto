package lotto

data class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBERS_COUNT) { "fail lotto number count" }
    }

    companion object {
        private const val LOTTO_NUMBERS_COUNT = 6
    }
}
