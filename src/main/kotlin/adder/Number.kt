package adder

data class Number(private val value: Int) {
    constructor(input: String) : this(input.toInt())
}