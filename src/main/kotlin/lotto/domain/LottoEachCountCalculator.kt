package lotto.domain

data class LottoEachCountCalculator(private val totalCount: Int, private val manualCount: Int) {
    val autoCount = totalCount - manualCount
}
