package lotto.domain

const val LOTTO_PRICE = 1000

class ManualLottoDispenser(
    private val lottoDispenser: LottoDispenser = RandomLottoDispenser(),
    vararg manualLottos: Lotto,
): LottoDispenser {
    private val manualLottos = manualLottos.toList()

    override fun issue(money: Int): List<Lotto> {
        require(manualLottoPrice() <= money) { "수동으로 발급한 로또 금액보다 입력 금액은 크거나 같아야합니다." }

        if (money > manualLottoPrice()) {
            val remainMoney = money - manualLottoPrice()
            val remainLottos = lottoDispenser.issue(remainMoney)
            return manualLottos + remainLottos
        }
        return manualLottos
    }

    private fun manualLottoPrice(): Int {
        return manualLottos.size * LOTTO_PRICE
    }
}
