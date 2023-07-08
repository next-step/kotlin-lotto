package lotto.domain

import lotto.dto.MatchedCount

class WinningNumber(private val lotteryPaper: LotteryPaper, private val bonusNumber: LottoNumber) {

    init {
        validateBonusNumber(bonusNumber, lotteryPaper.getLottoNumbers())
    }

    private fun validateBonusNumber(bonusNumber: LottoNumber, answerNumbers: List<LottoNumber>) {
        validateIsBonusNumberAlreadyInAnswerNumbers(bonusNumber, answerNumbers)
    }

    private fun validateIsBonusNumberAlreadyInAnswerNumbers(
        bonusNumber: LottoNumber,
        answerNumbers: List<LottoNumber>
    ) {
        require(!answerNumbers.contains(bonusNumber)) { "보너스 숫자는 기존 당첨 숫자와 중복되면 안됩니다." }
    }

    fun compareLottoNumber(purchasedLottoNumber: List<LottoNumber>): Int {
        return lotteryPaper.getLottoNumbers().toSet().intersect(purchasedLottoNumber.toSet()).size
    }

    fun isBonusNumberMatch(purchasedLottoNumber: List<LottoNumber>): Boolean {
        return purchasedLottoNumber.contains(bonusNumber)
    }

    fun matchCount(purchasedLottoNumber: List<LottoNumber>): MatchedCount {
        val matchedNumber = compareLottoNumber(purchasedLottoNumber)
        val bonusNumberMatch = isBonusNumberMatch(purchasedLottoNumber)
        return MatchedCount(matchedNumber, bonusNumberMatch)
    }
}
