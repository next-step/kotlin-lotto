package lotto.domain

class BonusNumber private constructor(val number: LottoNumber) {
    constructor(number: Int, lastWeekNumber: LastWeekNumber) : this(LottoNumber(number)) {
        require(!lastWeekNumber.contains(LottoNumber(number))) { ExceptionType.BONUS_NUMBER_MUST_NOT_CONTAINED_BY_LAST_WEEK_NUMBERS }
    }
}
