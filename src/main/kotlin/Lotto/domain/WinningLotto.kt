package Lotto.domain

class WinningLotto(
    numbers: List<LottoNumber>,
    bonusNumber: LottoNumber
) : Lotto(numbers) {

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
