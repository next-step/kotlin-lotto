package lotto.domain.numbers

@JvmInline
value class LottoNumber(private val number: Int) {

    init {
        require(number in LOTTO_NUMBER_POOL) { "로또 번호는 1과 45사이의 숫자여야 합니다." }
    }

    fun toInt(): Int = number

    companion object {
        val LOTTO_NUMBER_POOL = (1..45)
    }
}
