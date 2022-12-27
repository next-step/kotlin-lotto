package lotto.domain

class BonusNumber(private val number: Int) {
    fun getMatchingBonus(numbers: Numbers) = numbers.issueNumbers.contains(number)
}
