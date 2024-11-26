package study.lotto.model

/**
 * @author 이상준
 */
class LottoStat(
    val lottoPrize: Rank,
    count: Int = DEFAULT_COUNT,
) {
    var count: Int = count
        private set

    fun addCount() {
        this.count++
    }

    companion object {
        const val DEFAULT_COUNT = 0
    }
}
