package lotto.model

class Lotto {

    private val _numbers = mutableListOf<Int>()
    val numbers: List<Int> get() = _numbers

    fun generate(numbers: List<Int>) {
        require(numbers.size == 6) {
            "6개의 숫자를 선택해주세요."
        }
        _numbers.addAll(numbers)
    }

    companion object {
        const val PRICE = 1_000
        const val NUMBER_COUNT = 6
        val NUMBER_GENERATION_RANGE = 1..99
    }
}
