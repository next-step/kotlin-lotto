package lotto.domain

class ManualLottoStrings(manualCount: Int, val lottoStrings: List<String>) {
    init {
        require(manualCount == lottoStrings.size) { "manualCount different input lotto list" }
    }
}
