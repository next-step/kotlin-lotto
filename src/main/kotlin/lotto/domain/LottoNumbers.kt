package lotto.domain

class LottoNumbers {
    var lottoNumberList: MutableList<List<Int>> = mutableListOf()
        private set

    fun generateRandomLottoNumber() {
        val generatedLottoNumber = (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled()
            .take(NUMBER_OF_LOTTO_DRAWS)
        lottoNumberList.add(generatedLottoNumber)
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private const val NUMBER_OF_LOTTO_DRAWS = 6
    }
}
