package lotto.domain

class Lotto(val numbers: List<Int>) : List<LottoNumber> by numbers.map(::LottoNumber) {

    init {
        require(isValid())
    }

    fun match(target: Lotto) = intersect(target).size

    private fun isValid(): Boolean = numbers
        .distinct()
        .let { it.size == NUMBER_SIZE }

    companion object {
        private const val NUMBER_SIZE = 6

        private fun generateRandom(): List<Int> = LottoNumber.NUMBER_RANGE
            .shuffled()
            .asSequence()
            .take(NUMBER_SIZE)
            .sorted()
            .toList()

        fun buyRandom(): Lotto {
            return Lotto(generateRandom())
        }
    }
}
