package lotto

class BonusNumber(val number: LottoNumber, lotto: Lotto) {
    constructor(lotto: Lotto) : this(
        LottoNumber(
            LottoNumber.RANGE.subtract(lotto.numbers.map { it.number }.toSet()).random()
        ),
        lotto
    )

    init {
        require(!lotto.contains(number)) { "bonusNumber same input lotto numbers" }
    }
}
