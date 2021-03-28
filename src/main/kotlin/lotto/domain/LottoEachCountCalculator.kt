package lotto.domain

data class LottoEachCountCalculator(private val totalCount: Int, val manualCount: Int) {
    val autoCount = totalCount - manualCount
}
