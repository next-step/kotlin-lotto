package lotto.domain

class WinningLotto(
    private val winningLotto: LottoTicket,
    number: String,
) {
    private val bonusNumber: BonusNumber

    init {
        val num = number.toIntOrNull() ?: throw IllegalArgumentException("보너스 번호가 유효하지 않습니다 ")
        bonusNumber = BonusNumber.of(this.winningLotto, LottoNumber.from(num))
    }

    fun calculateRank(lottoTicket: LottoTicket): LottoRank {
        return lottoTicket.calculateRank(winningLotto)
    }

    fun calculateMatchCount(numbers: Set<LottoNumber>): Int {
        return winningLotto.intersect(numbers).size
    }

    fun isMatchedBonusNumber(numbers: Set<LottoNumber>): Boolean {
        return bonusNumber.isMatched(numbers)
    }
}
