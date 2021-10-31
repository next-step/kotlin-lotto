package calculator

class Operand(val value: Int) {
    constructor(stringValue: String) : this(stringValue.toInt())
}
