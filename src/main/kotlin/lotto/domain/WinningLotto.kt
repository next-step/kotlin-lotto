package lotto.domain

class WinningLotto(
    private val winningLotto: LottoTicket,
    number: String,
) {
    private val bonusNumber: BonusNumber

    init {
        val intNumber = number.toIntOrNull() ?: throw IllegalArgumentException("보너스 번호가 유효하지 않습니다")
        bonusNumber = BonusNumber.of(this.winningLotto, LottoNumber.from(intNumber))
    }

    fun calculateMatchCount(numbers: Set<LottoNumber>): Int {
        return winningLotto.intersect(numbers).size
    }

    fun isMatchedBonusNumber(numbers: Set<LottoNumber>): Boolean {
        return bonusNumber.isMatched(numbers)
    }
}
