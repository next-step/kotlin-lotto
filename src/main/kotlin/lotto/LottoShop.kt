package lotto

class LottoShop {

    fun buyLotto(lottoMoney: LottoMoney, manualLottoNumbers: List<String>): List<Lotto> {
        val lottoCount = lottoMoney.price / LottoMoney.LOTTO_UNIT_PRICE
        val autoLottoCount = lottoCount - manualLottoNumbers.size

        return autoLottoCount.downTo(1).map { Lotto.ofAuto() }
    }
}
