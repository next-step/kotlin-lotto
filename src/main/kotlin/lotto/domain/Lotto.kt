package lotto.domain

@JvmInline
value class Lotto private constructor(
    private val numbers: Set<LottoNumber>
) {

    init {
        require(numbers.size == SIZE) { LOTTO_SIZE_NOT_MATCHED_MESSAGE(numbers.size) }
    }

    val sortedNumbers: List<LottoNumber>
        get() = numbers.sortedBy { it.number }

    fun countMatchNumber(other: Lotto): Int {
        return numbers.filter { other.numbers.contains(it) }.count()
    }

    fun hasLottoNumber(lottoNumber: LottoNumber): Boolean {
        return numbers.contains(lottoNumber)
    }

    companion object {
        const val SIZE = 6
        val PRICE = Money.of(1000)
        private const val DELIMITER = ","
        private const val NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또번호 형식에 맞지 않습니다."
        private const val NOT_ENOUGH_MONEY_MESSAGE = "로또를 구입 하시려면 최소 1000원은 필요합니다."

        private val LOTTO_SIZE_NOT_MATCHED_MESSAGE: (numberSize: Int) -> String = { "로또 숫자의 갯수는 ${SIZE}여야 합니다. 현재 갯수 == $it" }

        fun of(lottoNumbers: List<LottoNumber>): Lotto {
            return Lotto(lottoNumbers.toSet())
        }

        fun of(value: String): Lotto {
            val numbers = value.split(DELIMITER).map {
                it.trim().toIntOrNull() ?: throw IllegalArgumentException(
                    NUMBER_FORMAT_EXCEPTION_MESSAGE
                )
            }
            return of(numbers.map { LottoNumber.of(it) })
        }

        fun getPurchasedLottoCount(money: Money): Int {
            require(money >= PRICE) { NOT_ENOUGH_MONEY_MESSAGE }
            return money / PRICE
        }
    }
}
