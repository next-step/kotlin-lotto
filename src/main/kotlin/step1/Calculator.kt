package step1

/**
 *
 * @author Leo
 */
class Calculator(private val separator: Separator) {

    fun sum(expression: String?): Int {
        val numbers = separator.getNumbers(expression)
        require(numbers.none { it < 0 }) {
            "음수가 포함되어선 안된다."
        }

//        return numbers.reduce { total, number -> total + number }
        return numbers.sum()
    }

}