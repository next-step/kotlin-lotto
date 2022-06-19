package lotto.domain

@JvmInline value class EarnedRate(val rate: Float) {
    init {
        require(rate >= 0.0f) { "수익률은 항상 0이상이에요. given rate: $rate" }
    }
}
@JvmInline value class EarnedMoney(val money: Long) {
    init {
        require(money >= 0L) { "금액은 항상 0이상이에요. given money: $money" }
    }
}

data class LottoMatchResult(
    val matchResult: Map<WinningInfo, Int>,
    val earnedMoney: EarnedMoney,
)
