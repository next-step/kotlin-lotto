package lotto.domain

class ManualLottoDispenser(
    private val lottoDispenser: LottoDispenser,
    vararg manualLottos: Lotto,
): LottoDispenser {
    private val manualLottos = manualLottos.toList()

    override fun issue(money: Int): List<Lotto> {
        val manualLottoPrice = manualLottos.size * LOTTO_PRICE
        if (money > manualLottoPrice) {
            val remainMoney = money - manualLottoPrice
            val remainLottos = lottoDispenser.issue(remainMoney)
            return manualLottos + remainLottos
        }
        return manualLottos
    }
}
