package lotto.model

enum class LottoRank(
    val prize: Long,
    val countCondition: Int,
    matchConditionFactory: (Int) -> (Int, Boolean) -> Boolean,
) {
    FIRST(2_000_000_000, 6, exactlyCountAndNotMatchedBonusCondition),
    SECOND(30_000_000, 5, exactlyCountAndMatchedBonusCondition),
    THIRD(1_500_000, 5, exactlyCountAndNotMatchedBonusCondition),
    FOURTH(50_000, 4, exactlyCountCondition),
    FIFTH(5_000, 3, exactlyCountCondition),
    MISS(0, 2, lessThanCountCondition),
    ;

    private val matchCondition: (Int, Boolean) -> Boolean = matchConditionFactory(countCondition)

    companion object {
        fun rankOf(count: Int, isMatchedBonus: Boolean): LottoRank {
            return values()
                .firstOrNull { it.matchCondition(count, isMatchedBonus) }
                ?: throw IllegalArgumentException("matched rank is not exist. provided count(`$count`), isMatchedBonus(`$isMatchedBonus`)")
        }

        val Collection<LottoRank>.totalPrize: Long
            get() = this.sumOf { it.prize }
    }
}

private val exactlyCountCondition: (Int) -> (Int, Boolean) -> Boolean = { countCondition ->
    { it, _ -> it == countCondition }
}

private val lessThanCountCondition: (Int) -> (Int, Boolean) -> Boolean = { countCondition ->
    { it, _ -> it <= countCondition }
}

private val exactlyCountAndMatchedBonusCondition: (Int) -> (Int, Boolean) -> Boolean = { countCondition ->
    { it, isMatchedBonus -> it == countCondition && isMatchedBonus }
}

private val exactlyCountAndNotMatchedBonusCondition: (Int) -> (Int, Boolean) -> Boolean = { countCondition ->
    { it, isMatchedBonus -> it == countCondition && !isMatchedBonus }
}
