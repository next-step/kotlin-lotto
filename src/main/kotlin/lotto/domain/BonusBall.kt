package lotto.domain

class BonusBall(val bonusNumber: LottoNumber, lotteryPaper: LotteryPaper) {
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
}
