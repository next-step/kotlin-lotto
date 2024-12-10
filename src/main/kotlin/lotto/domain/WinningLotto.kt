package lotto.domain

class WinningLotto(
    val winningNumbers: Lotto,
    val bonusNumber: LottoNumber,
) {
    init {
        validateDuplicate()
    }

    fun match(order: Order): List<Rank> {
        return order.lottos.map { this.matchLotto(it) }
    }

    private fun matchLotto(targetLotto: Lotto): Rank {
        return Rank.findByMatchCount(
            countMatchingNumbers(targetLotto),
            matchBonusNumber(targetLotto),
        )
    }

    private fun countMatchingNumbers(targetLotto: Lotto): Int {
        return targetLotto.numbers.count { it in winningNumbers.numbers }
    }

    private fun matchBonusNumber(targetLotto: Lotto): Boolean {
        return targetLotto.numbers.contains(bonusNumber)
    }

    private fun validateDuplicate() {
        require(!winningNumbers.numbers.contains(bonusNumber)) { "당첨 로또 번호와 보너스 번호는 중복될 수 없습니다." }
    }
}
