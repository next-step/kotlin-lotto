package calculator.domain

@JvmInline
value class Operand(val value: Int) {

    constructor(value: String) : this(
        try {
            value.toInt()
        } catch (e: NumberFormatException) {
            throw RuntimeException("숫자가 아닌 값[$value] 입니다.")
        }
    )

    init {
        if (value < 0) throw RuntimeException("음수[$value]를 사용할 수 없습니다.")
    }
}
