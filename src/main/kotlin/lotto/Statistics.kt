package lotto

import java.math.BigDecimal

data class Statistics(private val money: Int = 1000, private val statistics: Map<Int, Int>) {

    val profit: BigDecimal
        get() = BigDecimal("5000").divide(BigDecimal(money))

    constructor(money: Int, vararg pairs: Pair<Int, Int>): this(money, mapOf(*pairs))
}
