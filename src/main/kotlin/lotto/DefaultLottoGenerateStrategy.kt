package lotto

private const val LOTTO_MINIMUM_NUMBER = 1
private const val LOTTO_MAXIMUM_NUMBER = 45
private const val LOTTO_NUMBER_COUNT = 6

class DefaultLottoGenerateStrategy : LottoGenerateStrategy {
    override fun generate(): List<Int> {
        val lottoNumbers = HashSet<Int>()

        while (lottoNumbers.size < LOTTO_NUMBER_COUNT) {
            val random = (LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER).random()

            lottoNumbers.add(random)
        }

        return lottoNumbers.sorted()
    }
}
