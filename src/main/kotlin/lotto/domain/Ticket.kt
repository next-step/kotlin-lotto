package lotto.domain

class Ticket(
    private val numbers: Numbers = Numbers()
) {
    init {
        valid(numbers)
    }

    private fun valid(numbers: Numbers) {
        require(numbers.size() == LOTTO_COUNT) { "로또 번호 6개에 적합하지 않습니다" }
        require(numbers.duplicateSize() == LOTTO_COUNT) { "중복된 로또 번호가 존재합니다" }
    }

    fun getNumbers() = this.numbers.values

    fun getMatchingNumbersCount(numbers: Numbers) =
        this.numbers.values.filter { numbers.values.contains(it) }.size

    companion object {
        val LOTTO_RANGE = 1..45
        const val LOTTO_COUNT = 6
    }
}
