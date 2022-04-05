package lotto.domain.money

enum class PrizeMoney(val prize: Int) {
    FIRST_PLACE_PRIZE(2_000_000_000),
    SECOND_PLACE_PRIZE(1_500_000),
    THIRD_PLACE_PRIZE(50_000),
    FOURTH_PLACE_PRIZE(5_000),
    LAST_PLACE_PRIZE(0);
}
