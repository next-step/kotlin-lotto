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

    fun getIssueNumbers() = this.numbers.issueNumbers

    fun getMatchingNumbersCount(numbers: Numbers) = this.numbers.getMatchingNumbers(numbers)

    fun getMatchingBonus(numbers: Numbers) = this.numbers.bonusNumber == numbers.bonusNumber

    companion object {
        val LOTTO_RANGE = 1..45
        const val LOTTO_COUNT = 6
    }
}
