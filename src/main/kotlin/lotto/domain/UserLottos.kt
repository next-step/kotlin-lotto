package lotto.domain

class UserLottos(private val lottos: List<Lotto>) {
    fun match(winningLotto: WinningLotto): List<MatchResult> {
        return lottos.map { lotto ->
            val matchCount = winningLotto.calculateMatchCount(lotto)
            val containsBonusNumber = winningLotto.containsBonusNumberIn(lotto)
            MatchResult(matchCount, containsBonusNumber)
        }
    }

    fun calculatePurchaseAmount(): Long {
        return (lottos.size * Lotto.MIN_AMOUNT_UNIT).toLong()
    }

    fun getPurchaseLottoCount(): Int {
        return lottos.size
    }

    override fun toString(): String {
        return lottos.joinToString(separator = ",\n", postfix = "\n")
    }
}
