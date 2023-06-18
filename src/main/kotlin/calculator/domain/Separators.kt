package calculator.domain

class Separators {
    private val separators: MutableList<Separator> = mutableListOf(Separator(","), Separator(":"))

    fun add(separator: Separator) {
        separators.add(separator)
    }

    fun getSeparators() = separators
}
