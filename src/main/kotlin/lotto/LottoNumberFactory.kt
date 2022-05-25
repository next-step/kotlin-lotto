package lotto

interface LottoNumberFactory {
    fun generate(): List<Int>
}

class RandomLottoNumberFactory : LottoNumberFactory {
    override fun generate() = LOTTO_NUMBER_COUNT.map { LOTTO_NUMBER_RANGE.random() }

    companion object {
        private val LOTTO_NUMBER_RANGE = (1..44)
        private val LOTTO_NUMBER_COUNT = (0..5)
    }
}
