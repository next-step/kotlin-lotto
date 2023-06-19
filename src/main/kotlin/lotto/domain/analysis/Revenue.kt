package lotto.domain.analysis

import lotto.domain.money.Money

data class Revenue(
    val totalCost: Money,
    val totalRevenue: Money,
) {
    val percentage = (totalRevenue.value * 100) / totalCost.value
    val rateOfReturn = percentage / 100.0
}
