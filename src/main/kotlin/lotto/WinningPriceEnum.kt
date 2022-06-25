package lotto

import java.lang.Exception

enum class WinningPriceEnum(val number: Int, val price: Int, val bonusMatched: Boolean) {
    ZERO(0, 0, false),
    ONE(1, 0, false),
    TWO(2, 0, false),
    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    FIVE(5, 1500000, false),
    SIX(6, 2000000000, false),
    FIVE_BONUS(5, 30000000, true);

    companion object {
        fun find(number: Int): WinningPriceEnum {
            return values().find { it.number == number }!!
        }
    }
}

fun getPrice(number: WinningPriceEnum): Int {
    return try {
        WinningPriceEnum.values().filter { it.equals(number) }
            .map { return it.price }.first()
    } catch (e: Exception) {
        throw IllegalArgumentException("일치하지 않는 숫자입니다")
    }
}
