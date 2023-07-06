package lotto.domain

import lotto.view.ExceptionMessage

class WinningLotto(
    numbers: List<LottoNumber>,
    private val bonusNumber: LottoNumber
) : Lotto(numbers) {

    init {
        require(bonusNumber !in numbers) { ExceptionMessage.DUPLICATE_NUMBER_AND_BONUS.message }
    }

    fun getLottoRank(lotto: Lotto): LottoRank {
        return LottoRank.getRank(getMatchCount(lotto), containsBonusNumber(lotto.numbers))
    }

    private fun getMatchCount(lotto: Lotto): Int {
        return lotto.numbers.intersect(numbers.toSet()).size
    }

    private fun containsBonusNumber(number: Set<LottoNumber>): Boolean {
        return bonusNumber in number
    }
}
