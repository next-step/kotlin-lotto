package lotto.domain

class Lotto private constructor(private val numbers: Set<LottoNumber>) {
    init {
        validNumber(numbers)
    }

    constructor(vararg numbers: Int) : this(numbers.toList())
    constructor(numbers: List<Int>) : this(setLottoNumber(numbers)) {
        validNumber(numbers)
    }

    fun match(other: Lotto): Int {
        return numbers.filter { other.contains(it) }.count()
    }

    fun contains(number: LottoNumber): Boolean = numbers.contains(number)

    fun contains(number: Int): Boolean = contains(LottoNumber.of(number))

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

    companion object {
        private const val VALID_LOTTO_NUMBER = 6
        const val INVALID_MESSAGE = "로또는 중복되지 않은 ${VALID_LOTTO_NUMBER}개의 숫자로 생성할 수 있습니다."
        private fun setLottoNumber(numbers: List<Int>) =
            numbers.map { LottoNumber.of(it) }.sortedBy { it.number }.toSet()

        private fun validNumber(numbers: Collection<Any>) {
            require(numbers.size == VALID_LOTTO_NUMBER) { INVALID_MESSAGE }
        }
    }
}
