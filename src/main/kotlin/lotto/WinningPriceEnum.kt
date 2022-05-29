package lotto

import java.lang.Exception

enum class WinningPriceEnum(val number: Int, val price: Int) {
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);
}

fun getPrice(number: Int): Int {
    return try {
        WinningPriceEnum.values().filter { it.number.equals(number) }
            .map { return it.price }.first()
    } catch (e: Exception) {
        throw IllegalArgumentException("일치하지 않는 숫자입니다")
    }
}
