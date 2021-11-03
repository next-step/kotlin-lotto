package domain.lotto.domain

enum class MatchBoard(val rank: Rank, val matchPrize: Int) {
    FIRST(Rank(6), 2_000_000_000),
    SECOND(Rank(5, true), 30_000_000),
    THIRD(Rank(5), 1_500_000),
    FOURTH(Rank(4), 50_000),
    FIFTH(Rank(3), 5_000),
    MISS(Rank(0), 0);

    /***
     * TODO
     * class Rank {
     *     bonusBall: LottoNumber
     * }
     * 보너스볼이 필요하지 않다면? -> 전부다 하나의 값으로 통일 -> false
     * 보너스볼이 필요하다면? -> 들어온 값, 그대로 내보내면 되지 않나? -> true/false 가지고 알아서 계산할 듯
     */
    companion object {
        fun values(numberOfMatch: Int, isMatchBonus: Boolean): MatchBoard {
            return values().find {
                it.rank.sameAsNumberOfMatch(numberOfMatch) && it.rank.sameAsNeedBonusBall(isMatchBonus)
            } ?: MISS
        }

        fun valuesExcludedMiss(): List<MatchBoard> = values().filterNot { it == MISS }.reversed()
    }
}
