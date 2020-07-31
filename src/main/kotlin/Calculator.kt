class Calculator {

    fun calculate(expr: String): Int {
        if (expr.isEmpty()) return 0
        return expr.toInt()
    }
}
