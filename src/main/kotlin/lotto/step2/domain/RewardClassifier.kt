package lotto.step2.domain

object RewardClassifier {
    fun classify(lottos: List<Lotto>): Map<RewardType, Int> {
        return lottos.groupBy { it.matchCount }
            .mapValues { it.value.size }
            .mapKeys { RewardType.of(it.key) }
    }
}
