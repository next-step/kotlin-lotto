package lotto.domain

const val LOTTO_PRICE = 1000

private val LOTTO_NUMBER_RANGE = 1..45
private const val LOTTO_NUMBER_SIZE = 6

class Lotto
private constructor(
    numbers: List<Int>,
) {
    val numbers: List<LottoNumber>

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또 번호는 6개여야 합니다." }
        require(setOf(*numbers.toTypedArray()).size == LOTTO_NUMBER_SIZE) { "중복된 로또 번호가 존재합니다." }
        this.numbers = numbers.map { LottoNumber(it) }
    }

    companion object Factory {
        fun auto(): Lotto {
            val numbers = LOTTO_NUMBER_RANGE
                .shuffled()
                .take(LOTTO_NUMBER_SIZE)
                .sorted()
            return Lotto(numbers)
        }

        fun manual(numbers: List<Int>): Lotto = Lotto(numbers)
    }
}
