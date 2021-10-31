package lotto.usecase

class LottoNumberGenerator : Generator {

    override fun generate(range: IntRange): List<Int> {
        val numbers = mutableListOf<Int>()

        repeat(LOTTO_NUMBER_SIZE) {
            val number = range.random()
            numbers.add(number)
        }

        return numbers.toList()
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
