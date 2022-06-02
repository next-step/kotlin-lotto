package lotto.domain

import java.math.BigDecimal

class Lottos private constructor(
    val values: List<Lotto>,
) {
    init {
        require(values.isNotEmpty()) {
            "로또 구입을 위한 최소 금액은 ${LOTTO_PRICE.value} 입니다."
        }
    }

    companion object {
        private val LOTTO_PRICE: Money = Money(BigDecimal.valueOf(1_000))

        fun buyLottos(money: Money): Lottos {
            val lottos = mutableListOf<Lotto>()
            repeat(money.divideInt(LOTTO_PRICE)) { lottos.add(Lotto.autoCreate()) }
            return Lottos(values = lottos)
        }
    }
}
