package lotto.domain

private const val TICKET_PRICE = 1000

@JvmInline
value class Lottos(private val values: List<Lotto>) {
    fun toList(): List<Lotto> = values.toList()

    fun count() = values.size

    fun totalPrice() = values.size * TICKET_PRICE

    fun matchCount(other: Lotto): List<Int> = values.map { it.matchCount(other) }

    companion object {
        fun from(money: Money): Lottos {
            val count = money.value / TICKET_PRICE
            require(count >= 1) { "지불 금액은 최소 금액(${TICKET_PRICE}원) 이상이어야 합니다." }
            return Lottos((1..count).map { Lotto.random() })
        }
    }
}
