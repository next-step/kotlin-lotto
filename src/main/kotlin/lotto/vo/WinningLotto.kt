package lotto.vo

import lotto.winningpoint.WinningRank

class WinningLotto(input: String, inputBonus: String = "") {
    val numbers: List<LottoNumber>
    val bonusNumber: LottoNumber

    init {
        numbers = LottoNumber.of(input.split(","))
        bonusNumber = LottoNumber.of(inputBonus)
        require(numbers.isNotEmpty()) { "당첨 번호는 비어있을 수 없습니다." }
        require(numbers.size == 6) { "당첨 번호는 6개여야 합니다." }
        require(numbers.distinct().size == 6) { "당첨 번호는 중복되지 않아야 합니다." }
        require(!numbers.contains(bonusNumber)) { "보너스 번호는 당첨 번호에 포함될 수 없습니다." }
    }

    fun calculateTotalWinningPrice(lottos: List<Lotto>): Long {
        return lottos.sumOf { lotto ->
            checkWinning(lotto).winningPrice
        }
    }

    fun checkWinning(lotto: Lotto): WinningRank {
        val matchCount = lotto.numbers.intersect((this.numbers).toSet()).size
        val matchingBonusNumber = lotto.numbers.contains(this.bonusNumber)
        return WinningRank.of(matchCount, matchingBonusNumber)
    }
}
