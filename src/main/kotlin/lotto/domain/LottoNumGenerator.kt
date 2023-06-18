package lotto.domain

interface LottoNumGenerator {
    fun getNums(): List<Int>
}

class ShuffleNumGenerator : LottoNumGenerator {
    override fun getNums(): List<Int> {
        return (LOTTO_START_NUM..LOTTO_LAST_NUM).toList().shuffled().take(LOTTO_NUM_COUNT).sorted()
    }

    companion object {
        private const val LOTTO_START_NUM = 1
        private const val LOTTO_LAST_NUM = 45
        private const val LOTTO_NUM_COUNT = 6
    }
}
