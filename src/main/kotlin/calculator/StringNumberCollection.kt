package calculator

class StringNumberCollection(
    private val stringNumbers: List<StringNumber>
) {

    fun add(): Int {
        return this.stringNumbers.sumOf { it.number.toInt() }
    }
}
