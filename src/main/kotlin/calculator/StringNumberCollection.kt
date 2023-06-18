package calculator

class StringNumberCollection(
    private val stringNumbers: List<StringNumber>
) {

    constructor(stringNumbers: List<String>, dummyForImplicit: Any? = null) : this(stringNumbers.map { StringNumber(it) })

    fun add(): Int {
        return this.stringNumbers.sumOf { it.number.toInt() }
    }
}
