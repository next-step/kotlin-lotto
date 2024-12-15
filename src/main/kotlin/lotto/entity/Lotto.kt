package lotto.entity

class Lotto(val manualLotto: MutableList<LottoInfo>, val autoLotto: MutableList<LottoInfo>) {
    fun getTotalLottoInfos(): List<LottoInfo> {
        return manualLotto + autoLotto
    }
}
