package lotto

class WinningLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {
    constructor(winningStrings: StringNumbers, bonusNumber: LottoNumber) : this(
        Lotto(winningStrings.numbers.map { LottoNumber(it.trim()) }.toSet()), bonusNumber
    )

    init {
        require(!lotto.contains(bonusNumber)) { "bonusNumber same input lotto numbers" }
    }

    fun matchNumbers(lotto: Lotto): List<LottoNumber> {
        return this.lotto.numbers.filter { lotto.contains(it) }
    }
}
