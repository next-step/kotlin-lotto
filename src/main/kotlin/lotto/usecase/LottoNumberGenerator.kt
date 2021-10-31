package lotto.usecase

class LottoNumberGenerator : Generator {

    override fun generate(range: IntRange): List<Int> {
        return (1..LOTTO_NUMBER_SIZE).map {
            range.random()
        }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
