package lotto.domain

class WinningLotto(
    private val winningLotto: LottoTicket,
    private val bonusNumber: LottoNumber,
) {
    init {
        require(!winningLotto.contains(bonusNumber)) { "보너스 번호는 로또 티켓의 번호와 중복될 수 없습니다" }
    }

    fun calculateMatchCount(numbers: Set<LottoNumber>): Int {
        return winningLotto.intersect(numbers).size
    }

    fun isMatchedBonusNumber(numbers: Set<LottoNumber>): Boolean {
        return numbers.contains(bonusNumber)
    }
}
