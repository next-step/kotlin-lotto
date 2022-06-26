package lotto.domain

class LottoShop {
    fun buyLotto(money: PaidMoney, manualLottos: ManualLottos): LottoTickets =
        LottoVendor.generate(
            autoLottoCount(
                lottoTotal(money),
                manualLottos.count()
            ),
            manualLottos
        )

    private fun autoLottoCount(lottoTotal: Int, manualLottoTotal: Int): Int {
        require(lottoTotal >= manualLottoTotal) { "수동 로또 수가 구매 가능 로또 수보다 많아요." }
        return lottoTotal - manualLottoTotal
    }

    private fun lottoTotal(paidMoney: PaidMoney) = (paidMoney.money / LOTTO_PRICE).toInt()
}
