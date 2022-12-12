package lotto.domain

private const val MINIMUM_KRW_VALUE = 0

private const val DIVISION_UNIT = 1000

data class KRW(val money: Int) {

    constructor(input: String) : this(input.toIntOrNull() ?: 0)

    val availableLottoQuantity
        get() = money / DIVISION_UNIT

    init {
        require(money >= MINIMUM_KRW_VALUE)
        require(money % DIVISION_UNIT == 0)
    }

    fun add(krw: KRW): KRW {
        return KRW(money + krw.money)
    }
}
