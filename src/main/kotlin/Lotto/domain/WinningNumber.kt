package Lotto.domain

class WinningNumber(numbers: List<LottoNumber>) : Lotto(numbers) {

    fun getLottoRank(lotto: Lotto): LottoRank {
        return when (lotto.numbers.intersect(numbers.toSet()).size) {
            3 -> LottoRank.FIFTH
            4 -> LottoRank.FOURTH
            5 -> LottoRank.THIRD
            6 -> LottoRank.FIRST
            else -> LottoRank.LOSE
        }
    }
}
