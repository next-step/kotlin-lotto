package lotto.domain

data class LottoBuy(
    val cost: Int,
    val manual: List<List<Int>> = listOf()
)
