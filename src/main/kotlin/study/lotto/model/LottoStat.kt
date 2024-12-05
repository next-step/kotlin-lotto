package study.lotto.model

/**
 * @author 이상준
 */
class LottoStat(
    val rank: Rank,
    count: Int = DEFAULT_COUNT,
) {
    var count: Int = count
        private set

    fun addCount() {
        this.count++
    }

    companion object {
        private const val DEFAULT_COUNT = 0
    }
}
