package lotto.domain

data class BonusNumber private constructor(val number: Int) {
    constructor(number: Int, lastWeekNumber: LastWeekNumber) : this(number) {
        require(!lastWeekNumber.contains(number)) { ExceptionType.BONUS_NUMBER_MUST_NOT_CONTAINED_BY_LAST_WEEK_NUMBERS }
    }
}
