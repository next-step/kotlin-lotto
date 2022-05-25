package lotto.domain

import lotto.domain.vo.LottoNumber

class WinningLotto(winningNumbers: List<Int>) {
    private val winningLotto: Lotto

    init {
        winningLotto = Lotto(winningNumbers.map(::LottoNumber).toSet())
    }

    fun match(
        lottoBundle: LottoBundle
    ): List<MatchType> = lottoBundle.lottos.map { MatchType.findMatchType(matchCount(it)) }

    private fun matchCount(purchaseLotto: Lotto): Int =
        winningLotto.lottoNumbers.count { lottoNumber -> purchaseLotto.lottoNumbers.contains(lottoNumber) }
}
