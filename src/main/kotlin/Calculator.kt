class Calculator {

    fun calculate(expr: String): Int {
        if (expr.isEmpty()) return 0

        val numberGroup = expr.split(",", ":")
        if (numberGroup.size == 1) return numberGroup[0].toInt()

        return numberGroup
            .map { it.toInt() }
            .reduce { acc, number ->
                acc + number
            }
    }
}
