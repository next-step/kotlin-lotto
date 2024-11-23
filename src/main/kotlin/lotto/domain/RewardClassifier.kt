package lotto.domain

object RewardAnalyzer {
    /**
     * input: List<Lotto>
     * output: Map<RewardType, 사람수>
     */
    fun analyze(lottos: List<Lotto>): Map<RewardType, Int> {
        return lottos.groupBy { it.matchCount }
            .mapValues { it.value.size }
            .mapKeys { RewardType.of(it.key) }
    }
}