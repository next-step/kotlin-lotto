package lotto

import lotto.vo.Money

enum class Prize(
    val condition: Int,
    val amount: Money,
) {
    MATCH_3(3, Money(5000)),
    MATCH_4(4, Money(50000)),
    MATCH_5(5, Money(1500000)),
    MATCH_5_BONUS(5, Money(30000000)),
    MATCH_6(6, Money(2000000000));
}
