package lotto.domain

import lotto.domain.LottoGame.LOTTO_PRICE
import lotto.utils.Validation
import java.math.BigDecimal

class PurchaseResult(cost: String) {

    var purchaseCost: BigDecimal = BigDecimal.ZERO
        private set
    var numberOfGames: Int = 0
        private set
    var change: Int = 0
        private set

    init {
        require(Validation.isNotBlank(cost)) { "공백 값이 들어왔습니다." }
        require(Validation.isNumeric(cost)) { "숫자가 아닌 문자가 들어왔습니다." }

        val costConvertedToNumbers = cost.toInt()
        require(costConvertedToNumbers >= LOTTO_PRICE) { "최소 주문 금액보다 적습니다." }
        numberOfGames = costConvertedToNumbers / LOTTO_PRICE
        change = costConvertedToNumbers % LOTTO_PRICE
        purchaseCost = costConvertedToNumbers.toBigDecimal()
    }
}
