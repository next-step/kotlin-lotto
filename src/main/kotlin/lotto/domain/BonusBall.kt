package lotto.domain

class BonusBall(val bonusNumber: Int, lotteryPaper: LotteryPaper) {
    init {
        validateBonusNumber(bonusNumber, lotteryPaper.getLottoNumber())
    }

    private fun validateBonusNumber(bonusNumber: Int, answerNumbers: List<Int>) {
        validateIsBonusNumberInLotteryNumberBounce(bonusNumber)
        validateIsBonusNumberAlreadyInAnswerNumbers(bonusNumber, answerNumbers)
    }

    private fun validateIsBonusNumberInLotteryNumberBounce(bonusNumber: Int) {
        require(bonusNumber in LotteryPaper.LOTTO_NUMBER_BOUNDS) { "로또 범위의 숫자만 가능합니다. 입력값을 다시 확인하세요." }
    }

    private fun validateIsBonusNumberAlreadyInAnswerNumbers(bonusNumber: Int, answerNumbers: List<Int>) {
        require(!answerNumbers.contains(bonusNumber)) { "보너스 숫자는 기존 당첨 숫자와 중복되면 안됩니다." }
    }
}
