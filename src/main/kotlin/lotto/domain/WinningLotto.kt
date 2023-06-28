package lotto.domain

class WinningLotto(
    numbers: List<LottoNumber>,
    private val bonusNumber: LottoNumber
) : Lotto(numbers) {

    init {
        check(!numbers.contains(bonusNumber)) { "당첨 번호와 중복되는 번호를 입력했습니다." }
    }

    fun getLottoRank(lotto: Lotto): LottoRank {
        return when (getMatchCount(lotto)) {
            3 -> LottoRank.FIFTH
            4 -> LottoRank.FOURTH
            5 -> checkSecond(lotto)
            6 -> LottoRank.FIRST
            else -> LottoRank.LOSE
        }
    }

    private fun getMatchCount(lotto: Lotto): Int {
        return lotto.numbers.intersect(numbers.toSet()).size
    }

    private fun checkSecond(lotto: Lotto): LottoRank {
        return if (lotto.numbers.contains(bonusNumber)) LottoRank.SECOND else LottoRank.THIRD
    }
}
