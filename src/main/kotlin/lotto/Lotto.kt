package lotto

class Lotto(val price: Int = LOTTO_PRICE) {
    val numbers: List<Int> = lottoNumberShuffle()

    private fun lottoNumberShuffle(): List<Int> {
        return listOf(LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX)
            .flatten()
            .shuffled()
            .take(LOTTO_NUMBER_SIZE)
    }
    companion object {
        private const val LOTTO_PRICE = 1000
        private const val LOTTO_NUMBER_SIZE = 6
        private const val LOTTO_NUMBER_MIN = 1
        private const val LOTTO_NUMBER_MAX = 45
    }
}
