package lotto.domain

@JvmInline
value class MatchedLottos(val value: List<MatchedLotto>) {
    fun totalReward(): Int {
        return value.sumOf { it.winning.reward }
    }
}
