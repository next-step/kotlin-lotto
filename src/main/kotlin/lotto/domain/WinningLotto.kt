package lotto.domain

class WinningLotto(
    numbers: List<LottoNumber>,
    private val bonusNumber: LottoNumber
) : Lotto(numbers) {

    init {
        require(bonusNumber !in numbers) { DUPLICATE_NUMBER_AND_BONUS }
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

    companion object {
        private const val DUPLICATE_NUMBER_AND_BONUS = "당첨 번호와 중복되는 번호를 입력했습니다."
    }
}
