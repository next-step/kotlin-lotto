package string.add.calculator

@JvmInline
value class NaturalNumber(
    val value: Int,
) {
    init {
        if (value < 0) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
    }

    constructor(value: String) : this(value.toIntOrNull() ?: throw RuntimeException("숫자 이외의 값은 입력할 수 없습니다."))

    fun add(other: NaturalNumber): NaturalNumber = NaturalNumber(value + other.value)

    companion object {
        val ZERO = NaturalNumber(0)

        fun sum(numbers: List<NaturalNumber>): NaturalNumber = numbers.reduceOrNull { acc, naturalNumber -> acc.add(naturalNumber) } ?: ZERO
    }
}
