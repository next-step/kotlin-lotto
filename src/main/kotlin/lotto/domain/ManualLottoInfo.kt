package lotto.domain

class ManualLottoInfo(val manualCount: Int, val lottoStrings: List<String>) {
    init {
        require(manualCount == lottoStrings.size) { "manualCount different input lotto list" }
    }
}
