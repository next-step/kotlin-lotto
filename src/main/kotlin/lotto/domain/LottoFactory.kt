package lotto.domain

object LottoFactory {
    fun calculateLottoCount(money: Int, manualLottoCount: Int): LottoCount {
        val lottoCount = money / Lotto.LOTTO_PRICE
        require(lottoCount >= manualLottoCount) { "수동으로 구매할 로또 수가 전체 로또 수보다 많습니다." }

        return LottoCount(lottoCount - manualLottoCount, manualLottoCount)
    }

    fun buyLotto(autoLottoCount: Int, manualLottoNumberList: List<List<Int>>): List<Lotto> {
        val manualLottoList = manualLottoNumberList.map(::Lotto)
        val autoLottoList = List(autoLottoCount) { Lotto.auto() }

        return manualLottoList + autoLottoList
    }
}
