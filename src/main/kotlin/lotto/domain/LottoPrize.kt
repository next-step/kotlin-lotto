package lotto.domain

enum class LottoPrize(val price: Int) {
    SIX_MATCH(2000000000), FIVE_MATCH(1500000), FOUR_MATCH(50000), THREE_MATCH(5000), NOT_MATCH(0)
}
