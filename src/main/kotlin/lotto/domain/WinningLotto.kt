package lotto.domain

import lotto.domain.vo.LottoNumber

class WinningLotto {
    private val winningLotto: Lotto

    constructor(winningNumbers: List<Int>) {
        winningLotto = Lotto(winningNumbers.map(::LottoNumber).toSet())
    }

    fun match(
        lottoBundle: LottoBundle
    ): List<WinningResult> = lottoBundle.lottos.map { WinningResult.findResult(matchCount(it)) }

    private fun matchCount(purchaseLotto: Lotto): Int =
        winningLotto.lottoNumbers.count { lottoNumber -> purchaseLotto.lottoNumbers.contains(lottoNumber) }
}
