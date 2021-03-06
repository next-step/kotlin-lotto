package lotto

data class Money(val value: Int) {
    constructor(input: String) : this(input.toInt())
}
