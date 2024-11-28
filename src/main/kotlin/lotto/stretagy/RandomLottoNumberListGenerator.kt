package lotto.stretagy

class RandomLottoNumberListGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled()
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
    }
}
