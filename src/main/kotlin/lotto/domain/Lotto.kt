package lotto.domain

@JvmInline
value class Lotto private constructor(
    private val numbers: Set<LottoNumber>
) {

    init {
        require(numbers.size == LOTTO_SIZE) { MESSAGE(numbers.size) }
    }

    val sortedNumbers: List<LottoNumber>
        get() = numbers.sortedBy { it.number }

    fun countMatchNumber(other: Lotto): Int {
        return numbers.filter { other.numbers.contains(it) }.count()
    }

    companion object {
        const val LOTTO_SIZE = 6
        private const val DELIMITER = ","
        private const val NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또번호 형식에 맞지 않습니다."
        private val MESSAGE: (numberSize: Int) -> String = { "로또 숫자의 갯수는 ${LOTTO_SIZE}여야 합니다. 현재 갯수 == $it" }

        fun of(lottoNumbers: List<LottoNumber>): Lotto {
            return Lotto(lottoNumbers.toSet())
        }

        fun of(value: String): Lotto {
            val numbers = value.split(DELIMITER).map {
                it.trim().toIntOrNull() ?: throw IllegalArgumentException(
                    NUMBER_FORMAT_EXCEPTION_MESSAGE
                )
            }
            return of(numbers.map { LottoNumber(it) })
        }
    }
}
