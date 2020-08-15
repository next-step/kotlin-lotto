package lotto.domain

object MatchingMachine {

    fun match(
        lotto: Set<LottoNumber>,
        winningLotto: WinningLotto
    ): PrizeResult {

        val matchedCount = lotto.filter {
            winningLotto.winningNumbers.contains(it)
        }.count()

        val isContainBonusNumber = lotto.contains(winningLotto.bonusNumber)

        return PrizeResult.findByMatch(matchedCount, isContainBonusNumber)
    }
}
