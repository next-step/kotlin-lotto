package lotto.entity

class Lotto(val manualLotto: List<LottoInfo>, val autoLotto: List<LottoInfo>) {
    fun getTotalLottoInfos(): List<LottoInfo> {
        return manualLotto + autoLotto
    }
}
