package lotto.model

class LottoManager(money: Int) {
    private val _lottos: List<Lotto>
    val lottos: List<Lotto>
        get() = _lottos

    init {
        _lottos = (1..purchaseCount(money)).map { _ ->
            makeLotto()
        }
    }

    fun checkNumbers(winningNumbers: Numbers, bonusNumber: Int): Winners {
        val winners = lottos.map { it.checkNumbers(winningNumbers, bonusNumber) }
        return Winners(winners)
    }

    private fun purchaseCount(money: Int) =
        if (money < 0) 0 else (money / Lotto.PRICE)

    private fun makeLotto() = Lotto.newAutoInstance()
}
