package lotto

class LottoGenerator {
    fun getLottoNumbers(): List<Int> {
        val numberSet = mutableSetOf<Int>()
        do {
            numberSet.add(getLottoNumber())
        } while (numberSet.size < Lotto.NUMBER_COUNT)
        return numberSet.sorted()
    }
    private fun getLottoNumber(): Int {
        val numbers = generateLottoNumbers()
        return numbers.shuffled()[PICK_INDEX]
    }

    private fun generateLottoNumbers(): List<Int> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).toList()

    companion object {
        private const val PICK_INDEX: Int = 0
        private const val MINIMUM_NUMBER: Int = 1
        private const val MAXIMUM_NUMBER: Int = 45
    }
}
