package lotto.usecase

class LottoNumberGenerator : Generator {

    override fun generate(numberRange: IntRange): List<Int> {
        return numberRange
            .shuffled()
            .subList(START_INDEX, LOTTO_NUMBER_SIZE)
            .sorted()
    }

    companion object {
        private const val START_INDEX = 0
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
