package lotto.domain

@JvmInline
value class LottoNumber private constructor(
    val number: Int
) {
    init {
        require(number > 0) { "로또 번호는 양수여야 합니다." }
        require(number in LOTTO_NUMBERS_RANGE) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    companion object {
        val LOTTO_NUMBERS_RANGE = 1..45
        private val LOTTO_NUMBERS = LOTTO_NUMBERS_RANGE.map { LottoNumber(it) }.toList()

        fun create(number: Int): LottoNumber = LottoNumber(number)

        fun createRandom(size: Int): List<LottoNumber> = LOTTO_NUMBERS.shuffled().take(size)
    }
}
