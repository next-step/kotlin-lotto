package calculator

object Calculator {
    fun add(input: String?): Int {
        if (input.isNullOrEmpty())
            return 0
        val formula = Formula(input)
        return formula.sumValues()
    }
}
