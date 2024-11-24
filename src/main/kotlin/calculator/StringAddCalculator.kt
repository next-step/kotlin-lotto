package calculator

object StringAddCalculator {

    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            return 0
        }

        return expression
            .selectSeparator()
            .parse()
            .validate()
            .calculate()
    }

    private fun String.selectSeparator(): SeparatorSelectResult {
        return SeparatorSelector.select(this)
    }

    private fun SeparatorSelectResult.parse(): List<Int> {
        return this.expression.split(this.regex).map { it.toInt() }
    }

    private fun List<Int>.validate(): List<Int> {
        this.forEach { if (it < 0) throw RuntimeException("음수값을 포함 할 수 없습니다") }
        return this
    }

    private fun List<Int>.calculate(): Int {
        return this.sum()
    }

}
