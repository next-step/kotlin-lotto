package lotto

class BonusNumber(
    val value: LottoNumber
) {
    fun isMatch(lotto: Lotto): Boolean {
        return lotto.numbers.contains(value)
    }
}
