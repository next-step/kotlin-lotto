package lotto.domain

enum class LottoRank(val prizePolicy: LottoPrizePolicy) {
    ONE(LottoPrizePolicy(6, Money(2_000_000_000))),
    TWO(LottoPrizePolicy(5, Money(30_000_000), true)),
    THREE(LottoPrizePolicy(5, Money(1_500_000), false)),
    THIRD(LottoPrizePolicy(4, Money(50_000))),
    FOURTH(LottoPrizePolicy(3, Money(5_000))),
}
