package domain

class Calculator {
    fun sum(input: String?): Int {
        if (input.isNullOrBlank()) return 0
        return Seperator().parse(input).sum()
    }
}
