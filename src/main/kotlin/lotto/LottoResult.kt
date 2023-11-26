package lotto

data class LottoResult(
    val rank: Rank,
) {
    var count: Int = 0
        private set

    fun addCount() {
        count += 1
    }
}
