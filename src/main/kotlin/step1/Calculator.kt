package step1

/**
 *
 * @author Leo
 */
class Calculator(private val seperator: Seperator) {

    fun sum(expression: String?): Int {
        val numbers = seperator.getNumbers(expression)
        if (!numbers.none { it < 0 }) {
            throw RuntimeException("음수가 포함되어선 안된다.")
        }

        return numbers.reduce { total, number -> total + number }
    }

}