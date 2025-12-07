package lotto

class LottoShop {

    fun buyLotto(lottoMoney: LottoMoney, manualLottoNumbers: List<String>): List<Lotto> {
        val lottoCount = lottoMoney.price / LottoMoney.LOTTO_UNIT_PRICE
        val autoLottoCount = lottoCount - manualLottoNumbers.size

        val manualLottos = manualLottoNumbers.stream()
            .map { Lotto.ofManual(it) }
            .toList()
        val autoLottos = autoLottoCount.downTo(1).map { Lotto.ofAuto() }

        return manualLottos + autoLottos
    }
}
