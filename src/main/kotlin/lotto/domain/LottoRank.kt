package lotto.domain

enum class LottoRank(val rankName: String, val prizePolicy: LottoPrizePolicy) {
    ONE("1등", LottoPrizePolicy(6, Money(2000000000))),
    TWO("2등", LottoPrizePolicy(5, Money(30000000), true)),
    THREE("3등", LottoPrizePolicy(5, Money(1500000), false)),
    THIRD("4등", LottoPrizePolicy(4, Money(50000))),
    FOURTH("5등", LottoPrizePolicy(5, Money(1500000), false)),
    FIFTH("6등", LottoPrizePolicy(3, Money(5000))),
}
