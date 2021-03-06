package adder

private const val ZERO = 0

data class Number(private val value: Int) {
    init {
        require(value > ZERO) {"양수만 가능합니다."}
    }

    constructor(input: String) : this(input.toInt())
}