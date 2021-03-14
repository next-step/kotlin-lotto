package calculator

class StringNumberCollection(val numbers: List<StringNumber>) {
    constructor(numbers: Array<String>) : this(numbers.map { StringNumber(it) })

    fun sum(): Int {
        return numbers.map {
            it.toInt()
        }.sum()
    }
}
