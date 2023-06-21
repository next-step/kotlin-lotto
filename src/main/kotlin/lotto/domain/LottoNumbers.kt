package lotto.domain

class LottoNumbers {

    fun generateRandomLottoNumbers(): List<Int> {
        return (LottoNumbers.MINIMUM_NUMBER..LottoNumbers.MAXIMUM_NUMBER).shuffled()
            .take(LottoNumbers.NUMBER_OF_LOTTO_DRAWS)
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private const val NUMBER_OF_LOTTO_DRAWS = 6
    }
}
