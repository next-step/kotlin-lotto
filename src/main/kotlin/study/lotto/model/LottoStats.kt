package study.lotto.model

/**
 * @author 이상준
 */
data class LottoStats(
    private val statSet: MutableSet<LottoStat> = mutableSetOf(),
) {
    fun addStat(lottoStat: LottoStat) {
        statSet.add(lottoStat)
    }

    fun getStat(): Set<LottoStat> {
        return statSet.toSet()
    }
}
