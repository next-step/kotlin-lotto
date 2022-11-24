package lotto.domain

interface LottoFactory {

    val NUMBER_RANGE: IntRange
        get() = 1..45

    val DRAWING_QUANTITY: Int
        get() = 6

    val EXTRACTION_POINT: Int
        get() = 0

    fun create(): Lotto
}
