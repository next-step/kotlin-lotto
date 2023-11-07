package lotto.domain

abstract class Lotto {
    abstract val lottoNumbers: LottoNumbers
    fun getLottoResult(winningNumbers: WinningNumbers): LottoRank {
        return LottoRank.of(lottoNumbers.getContainCount(winningNumbers), lottoNumbers.isMatchBonus(winningNumbers))
    }
}
