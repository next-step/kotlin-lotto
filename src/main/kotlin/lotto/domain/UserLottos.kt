package lotto.domain

class UserLottos(private val lottos: List<Lotto>) {
    fun calculateMatchCountEach(winningLotto: WinningLotto): List<Int> {
        return lottos.map { lotto ->
            winningLotto.calculateMatchCount(lotto)
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
