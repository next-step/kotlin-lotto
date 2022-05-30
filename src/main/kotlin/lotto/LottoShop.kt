package lotto

class LottoShop(
    private val money: Int
) {

    init {
        moneyValidate(money)
    }

    fun buyLotto(): List<LottoTicket> {
        val numberOfBuy = money / LottoPolicy.LOTTO_PRICE
        return List(numberOfBuy) { LottoCreator.autoCreate() }
    }

    private fun moneyValidate(money: Int) {
        if (money < LottoPolicy.LOTTO_PRICE) {
            throw RuntimeException("로또 구매 비용이 부족합니다. - `$money` (최소`${LottoPolicy.LOTTO_PRICE}` 이상 필요)")
        }
    }

    fun buyManual(manualLotto: List<Int>): LottoTicket {
        return LottoCreator.manualCreate(manualLotto)
    }
}
