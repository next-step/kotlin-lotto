package lotto.model

class Lotto {

    private val _numbers = mutableListOf<Int>()
    val numbers: List<Int> get() = _numbers

    init {
        generate()
    }

    private fun generate() {
        repeat(NUMBER_COUNT) {
            _numbers.add(NUMBER_GENERATION_RANGE.random())
        }
    }

    companion object {
        private const val NUMBER_COUNT = 6
        private val NUMBER_GENERATION_RANGE = 1..99
    }
}
