package calculator

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputString = InputView().inputString()

        val validatedString = validate(inputString)
        val customDelimiter = customDelimeter(validatedString)
        val list = parse(validatedString, customDelimiter)
        val numbers = list.filter { Number(it).isNatural() }.map { it.toInt() }
        val sum = Calculator().sum(numbers)

        ResultView().show(sum)
    }
}
