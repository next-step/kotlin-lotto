package study.lotto.domain

class Lotto(val numbers: LottoNumbers) {

    private fun countMatches(winningNumbers: Lotto): Int {
        return this.numbers.count(winningNumbers.numbers::contains)
    }

    private fun matchBonusNumber(bonusNumber: LottoNumber): Boolean {
        return this.numbers.contains(bonusNumber)
    }

    fun getPrizeGrade(winningNumbers: Lotto, bonusNumber: LottoNumber) = PrizeGrade[
        countMatches(winningNumbers),
        matchBonusNumber(bonusNumber)
    ]

    companion object {
        fun generate(): Lotto {
            return Lotto(LottoNumbers.random())
        }
    }
}
