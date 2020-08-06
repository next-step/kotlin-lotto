package lotto.model

enum class Win(val matchNumber: Int, val matchBonus: Boolean = false, val prize: Money) {
    NONE(0, prize = Money(0)),
    FIFTH(3, prize = Money(5_000)),
    FOURTH(4, prize = Money(50_000)),
    THIRD(5, prize = Money(1_500_000)),
    SECOND(5, prize = Money(30_000_000), matchBonus = true),
    FIRST(6, prize = Money(2_000_000_000));

    fun hasPrize(): Boolean = prize.hasMoney()
}
