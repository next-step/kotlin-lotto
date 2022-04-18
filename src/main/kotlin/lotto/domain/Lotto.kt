package lotto.domain

class Lotto(numbers: List<Int>) {

    private val _numbers: MutableList<LottoNumber> = numbers
        .map(::LottoNumber)
        .toMutableList()
    val numbers: List<LottoNumber> get() = _numbers

    init {
        require(isValid())
    }

    fun match(target: Lotto) = numbers.intersect(target.numbers.toSet()).size

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
