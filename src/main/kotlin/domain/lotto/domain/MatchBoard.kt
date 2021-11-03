package domain.lotto.domain

enum class MatchBoard(val numberOfMatch: Int, val matchPrize: Int) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    // 보너스 번호를 가지고 있는 등수 유무를 나타내는 값
    // 보너스 번호를 가지고 있고, 등수 유무를 나타내는 값
    // "보너스 번호를 가지고 있는 등수 유무" 를 나타내는 값
    /***
     * TODO
     * class Rank {
     *     bonusBall: LottoNumber
     * }
     * 보너스볼이 필요하지 않다면? -> 전부다 하나의 값으로 통일 -> true 가져가는게 낫겠지? -> 있어도 사용되니까
     * 보너스볼이 필요하다면? -> 들어온 값, 그대로 내보내면 되지 않나? -> true/false 가지고 알아서 계산할 듯
     */

    companion object {
        fun values(numberOfMatch: Int, isMatchBonus: Boolean): MatchBoard {
            if (numberOfMatch == SECOND.numberOfMatch && isMatchBonus) {
                return SECOND
            }
            return values().find { it.numberOfMatch == numberOfMatch } ?: MISS
        }

        fun valuesExcludedMiss(): List<MatchBoard> = values().filterNot { it == MISS }
    }
}
