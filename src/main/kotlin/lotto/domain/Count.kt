package lotto.domain

data class Count(val value: Int) : Iterable<Int> {

    constructor(value: Double) : this(value.toInt())

    override fun iterator() = (0 until value).iterator()
}
