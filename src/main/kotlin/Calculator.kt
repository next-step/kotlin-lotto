class Calculator {

    fun calculate(expr: String): Int {
        if (expr.isEmpty()) return 0

        val numberGroup = expr.split(",")
        return numberGroup
            .map { it.toInt() }
            .reduce { acc, number ->
                acc + number
            }
    }
}
