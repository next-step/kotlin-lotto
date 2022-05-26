package lotto.domain

import lotto.domain.vo.LottoNumber

class WinningLotto(winningNumbers: List<Int>, bonusNumber: Int) {
    private val winningLotto: Lotto

    private val bonusNumber: LottoNumber

    private val winningLottoNumbers: Set<LottoNumber>
        get() = winningLotto.lottoNumbers

    init {
        winningLotto = Lotto(winningNumbers.map(::LottoNumber).toSet())
        this.bonusNumber = LottoNumber(bonusNumber)
    }

    fun match(
        lottoBundle: LottoBundle
    ): List<MatchType> = lottoBundle.lottos.map { MatchType.findMatchType(matchCount(it), hasBonusNumber(it)) }

    private fun matchCount(purchaseLotto: Lotto): Int =
        winningLottoNumbers.count { lottoNumber -> purchaseLotto.lottoNumbers.contains(lottoNumber) }

    private fun hasBonusNumber(purchaseLotto: Lotto): Boolean =
        purchaseLotto.lottoNumbers.contains(bonusNumber)
}
