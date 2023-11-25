package lotto.domain

object LottoFactory {
    fun buyLotto(autoLottoCount: Int, manualLottoNumberList: List<List<LottoNumber>>): List<Lotto> {
        val manualLottoList = manualLottoNumberList.map(::Lotto)
        val autoLottoList = List(autoLottoCount) { Lotto.auto() }

        return manualLottoList + autoLottoList
    }
}
