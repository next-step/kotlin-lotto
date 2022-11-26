package lotto.domain

data class Rewards(private val _rewards: MutableList<Rank> = mutableListOf()) {
    val value: List<Rank>
        get() = _rewards

    fun add(matches: Int) {
        Rank.fromOrNull(matches)?.let {
            _rewards.add(it)
        }
    }

    fun calculateRateOfReturn(purchaseAmount: PurchaseAmount): Double {
        return _rewards.sumOf { it.money } / purchaseAmount.amount
    }
}
