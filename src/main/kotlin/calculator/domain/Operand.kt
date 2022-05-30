package calculator.domain

@JvmInline
value class Operand(val value: Int) {

    constructor(value: String) : this(value.toInt())
}
