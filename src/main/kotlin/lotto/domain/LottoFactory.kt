package lotto.domain

object LottoFactory {
    fun buyLotto(money: Int, manualLottoCount: Int): List<Lotto> {
        val lottoCount = money / Lotto.LOTTO_PRICE
        require(lottoCount >= manualLottoCount) { "수동으로 구매할 로또 수가 전체 로또 수보다 많습니다." }

        return listOf(buyAutoLotto(lottoCount - manualLottoCount), buyManualLotto(manualLottoCount)).flatten()
    }

    private fun buyManualLotto(manualLottoCount: Int): List<Lotto> {
        // todo 구현
        return emptyList()
    }

    private fun buyAutoLotto(autoLottoCount: Int): List<Lotto> {
        return List(autoLottoCount) { Lotto.auto() }
    }
}
