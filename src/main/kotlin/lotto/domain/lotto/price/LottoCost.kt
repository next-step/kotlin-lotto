package lotto.domain.lotto.price

data class LottoCost(val cost: Int) {
    init {
        require(cost > 0) { "Cost must be greater than zero" }
    }
}
