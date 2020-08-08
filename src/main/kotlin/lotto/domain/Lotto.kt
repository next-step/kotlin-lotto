package lotto.domain

data class Lotto(private val lottoNumbers: LottoNumbers) {

    fun sumOfMatchUp(luckyNumbers: LuckyNumbers): Int {
        return luckyNumbers.getMatchedCount(lottoNumbers)
    }

    fun hasBonusNumber(bonusNumber: BonusNumber): Boolean {
        return lottoNumbers.isMatchedUp(bonusNumber.bonusNumber)
    }

    override fun toString(): String {
        return "$lottoNumbers"
    }
}
