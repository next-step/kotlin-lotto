package lotto.domain

import WinningLotto

class Lotto(
    val lottoNumbers: List<LottoNumber>,
) {

    init {
        require(lottoNumbers.size == 6) { "로또 번호는 6개여야 합니다." }
    }

    fun match(winningLotto: WinningLotto): LottoRank {
        val matchNumberCount = lottoNumbers.count { it in winningLotto.lottoNumbers }
        val isBonusMatched = winningLotto.bonusNumber in lottoNumbers
        return LottoRank.from(
            matchCount = matchNumberCount,
            isBonusMatched = isBonusMatched,
        )
    }
}
