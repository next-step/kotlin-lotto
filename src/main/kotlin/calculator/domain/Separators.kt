package calculator.domain

class Separators {
    val separators: MutableList<Separator> = mutableListOf(Separator(","), Separator(":"))

    fun add(separator: Separator) {
        separators.add(separator)
    }
}
