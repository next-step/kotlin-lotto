package lotto

class LottoBuilder {
    fun create(): Lotto {
        val numbers = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).shuffled()
            .subList(0, LOTTO_COUNT)
            .toSet()
        return Lotto(numbers)
    }

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
        private const val LOTTO_COUNT = 6
    }
}
