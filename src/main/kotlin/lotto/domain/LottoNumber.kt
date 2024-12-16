package lotto.domain

class LottoNumber(private val numbers: Set<Int>) {
    init {
        require(numbers.size == LOTTO_TAKE_NUMBER) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { "로또 번호는 1~45 사이여야 합니다." }
    }

    fun getNumbers(): Set<Int> = numbers

    fun hasNumber(number: Int): Boolean {
        return this.numbers.contains(number)
    }

    fun hasNotNumber(number: Int): Boolean {
        return this.numbers.contains(number).not()
    }

    fun compareWithWinningNumbers(winningLottoNumber: WinningLottoNumber): LottoMatchResult {
        val matchCount = this.getNumbers().count { winningLottoNumber.hasWinningNumber(it) }
        val hasBonus = winningLottoNumber.hasBonusNumber(this)
        return LottoMatchResult(matchCount, hasBonus)
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_TAKE_NUMBER = 6
    }
}
