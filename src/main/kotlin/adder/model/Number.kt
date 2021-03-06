package adder.model


data class Number(private val value: Int) {
    init {
        require(value >= ZERO) { "0보다 큰 수만 가능합니다." }
    }

    constructor(input: String) : this(input.toInt())

    companion object {
        private const val ZERO = 0
    }
}
