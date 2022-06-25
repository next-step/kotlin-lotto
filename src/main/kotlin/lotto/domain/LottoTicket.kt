package lotto.domain

class LottoTicket(
    val lottoNumbers: LottoNumbers
) {
    constructor(numbers: List<Int>) : this(
        LottoNumbers(numbers)
    )

    fun match(winningNumbers: WinningLotto, bonusNumber: BonusNumber): Rank {
        val matchCount = count(winningNumbers)
        val matchBonus = contains(bonusNumber)
        return Rank.of(matchCount, matchBonus)
    }

    private fun count(winningNumbers: WinningLotto): Int =
        lottoNumbers.lottoNumbers.count(winningNumbers::hasNumber)

    private fun contains(bonusNumber: BonusNumber): Boolean =
        lottoNumbers.lottoNumbers.contains(bonusNumber.bonusNumber)
}
