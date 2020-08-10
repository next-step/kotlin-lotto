package lotto.domain

class Lotto private constructor(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == VALID_LOTTO_NUMBER) { INVALID_MESSAGE }
    }

    fun match(other: Lotto): Int {
        return numbers.filter { other.contains(it) }.count()
    }

    fun contains(number: LottoNumber): Boolean = numbers.contains(number)

    fun contains(number: Int): Boolean = contains(LottoNumber.of(number))

    companion object {
        private const val VALID_LOTTO_NUMBER = 6
        private const val LOTTO_DELIMITER = ","
        const val INVALID_MESSAGE = "로또는 중복되지 않은 ${VALID_LOTTO_NUMBER}개의 숫자로 생성할 수 있습니다."

        fun of(vararg numbers: Int): Lotto {
            require(numbers.size == VALID_LOTTO_NUMBER) { INVALID_MESSAGE }
            val lottoNumbers = numbers.map { LottoNumber.of(it) }.sortedBy { it.number }.toSet()
            return Lotto(lottoNumbers)
        }

        fun of(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map { LottoNumber.of(it) }.sortedBy { it.number }.toSet()
            return Lotto(lottoNumbers)
        }

        fun ofComma(value: String): Lotto {
            val numbers = value.split(LOTTO_DELIMITER).map { it.trim().toInt() }
            return Lotto(numbers.map { LottoNumber.of(it) }.toSet())
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lotto

        if (numbers != other.numbers) return false

        return true
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    override fun toString(): String {
        return "$numbers\n"
    }
}
