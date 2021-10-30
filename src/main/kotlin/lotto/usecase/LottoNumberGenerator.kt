package lotto.usecase

class LottoNumberGenerator(
    private val strategy: NumberGenerateStrategy,
) : Generator {

    override fun generate(): List<Int> {
        return (1..LOTTO_NUMBER_SIZE).map {
            strategy.generate()
        }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
