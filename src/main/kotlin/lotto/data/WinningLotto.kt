package lotto.data

data class WinningLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {

    init {
        validateWinningLotto()
    }

    fun countMatchingNumbers(lotto: Lotto): Int {
        return this.lotto.matching(lotto)
    }

    fun hasBonusNumber(lotto: Lotto): Boolean {
        return lotto.selectNumbers.contains(bonusNumber)
    }

    private fun validateWinningLotto() {
        validateDuplicationBonusNumber()
    }

    private fun validateDuplicationBonusNumber() {
        require(!lotto.selectNumbers.contains(bonusNumber)) { ERR_MSG_DUPLICATION_BONUS_NUMBER }
    }

    private fun Lotto.matching(lotto: Lotto): Int {
        return this.selectNumbers.intersect(lotto.selectNumbers).size
    }

    companion object {
        private const val ERR_MSG_DUPLICATION_BONUS_NUMBER = "당첨 번호 구성과 보너스 번호가 중복됩니다."
    }
}
