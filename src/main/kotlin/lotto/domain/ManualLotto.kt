package lotto.domain

class ManualLotto private constructor(numbers: List<Int>) : Lotto(numbers) {
    constructor(numbers: String) : this(
        numbers.split(",").map { it.toInt() }
    )
    fun isValidSize(): Boolean = numbers.size == COUNT_OF_NUMBERS
}
