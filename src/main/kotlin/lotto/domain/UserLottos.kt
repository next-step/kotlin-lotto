package lotto.domain

class UserLottos(internal val lottos: List<Lotto>) {
    fun match(winningLotto: WinningLotto): List<MatchResult> {
        return lottos.map { lotto ->
            val matchCount = winningLotto.calculateMatchCount(lotto)
            val containsBonusNumber = winningLotto.containsBonusNumberIn(lotto)
            MatchResult(matchCount, containsBonusNumber)
        }
    }

    fun calculatePurchaseAmount(): LottoAmount {
        return LottoAmount.fromLottoCount(lottos.size)
    }

    fun getPurchaseLottoCount(): Int {
        return lottos.size
    }

    override fun toString(): String {
        return lottos.joinToString(separator = ",\n", postfix = "\n")
    }
}
