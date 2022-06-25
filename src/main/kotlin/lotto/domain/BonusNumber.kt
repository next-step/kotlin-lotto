package lotto.domain

class BonusNumber(val bonusNumber: LottoNumber) {
    constructor(number: Int) : this(
        LottoNumber.from(number)
    )
}
