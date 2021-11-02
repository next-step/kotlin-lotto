package lotto.domain

@JvmInline
value class LottoNumber(private val number: Int) {
    fun toNumber(): Int = number
}
