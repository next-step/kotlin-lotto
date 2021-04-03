package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(val value: Long) : Comparable<Money> {

    init {
        require(value >= 0) { "돈은 음수가 될 수 없습니다. value: $value" }
    }

    constructor(value: Int) : this(value.toLong())

    operator fun plus(other: Money): Money {
        return Money(this.value + other.value)
    }

    operator fun times(other: PositiveNumber): Money {
        return Money(this.value * other.value)
    }

    operator fun minus(other: Money): Money {
        return Money(this.value - other.value)
    }

    operator fun div(other: Money): Int {
        require(other != EMPTY) { "나누는 돈이 0원입니다." }
        return (this.value / other.value).toInt()
    }

    operator fun rem(other: Money): Money {
        require(other != EMPTY) { "나누는 돈이 0원입니다." }
        return Money(this.value % other.value)
    }

    override fun compareTo(other: Money): Int {
        return this.value.compareTo(other.value)
    }

    fun sellableLottoCount(lottoPrice: Money, minLottoCount: Int): Int {
        require(lottoPrice != EMPTY) { "로또 가격이 0원입니다." }
        require(this >= lottoPrice) { "구입금액은 로또가격보다 크거나 같아야 합니다. money: ${this.value}, lottoPrice: ${lottoPrice.value}" }
        require(this % lottoPrice == EMPTY) { "로또 구매 후 남은 돈이 있을 수 없습니다. money: ${this.value}, lottoPrice: ${lottoPrice.value}" }
        require(minLottoCount == 0 || this >= lottoPrice * PositiveNumber(minLottoCount)) { "로또를 구매하기에 부족한 금액입니다. money: ${this.value}, lottoPrice: ${lottoPrice.value}, minLottoCount: $minLottoCount" }

        return this.div(lottoPrice)
    }

    fun rateOf(other: Money): BigDecimal {
        require(other != EMPTY) { "나누는 돈이 0원입니다." }
        val thisValue = BigDecimal(this.value)
        val otherValue = BigDecimal(other.value)
        return thisValue.divide(otherValue, NUMBER_OF_DIGITS_AFTER_THE_DECIMAL_POINT, RoundingMode.HALF_EVEN)
    }

    companion object {
        val EMPTY = Money(0)
        private const val NUMBER_OF_DIGITS_AFTER_THE_DECIMAL_POINT = 6
    }
}
