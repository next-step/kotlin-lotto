package lotto

class LottoShop {
    fun buyLotto(
        lottoMoney: LottoMoney,
        manualLottoNumbers: List<String>,
    ): List<Lotto> {
        val lottoCount = lottoMoney.price / LottoMoney.LOTTO_UNIT_PRICE
        val autoLottoCount = lottoCount - manualLottoNumbers.size

        val manualLottos =
            manualLottoNumbers.map { Lotto.ofManual(it) }.toList()
        val autoLottos = List(autoLottoCount) { Lotto.ofAuto() }

        return manualLottos + autoLottos
    }
}
