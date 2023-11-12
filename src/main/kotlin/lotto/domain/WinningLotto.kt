package lotto.domain

data class WinningLotto(
    val winningNumber: LottoNumber,
    val bonusNumber: Int,
) {
    init {
        LottoNumberGenerator.checkNumber(bonusNumber)
        require(!winningNumber.contains(bonusNumber)) {
            "보너스 볼과 당첨번호 숫자가 중복됩니다"
        }
    }

    fun rank(number: LottoNumber): LottoRank {
        val matchedCount = winningNumber countMatched number
        val matchesBonus = number contains bonusNumber
        return LottoRank.valueOf(matchedCount, matchesBonus)
    }
}
