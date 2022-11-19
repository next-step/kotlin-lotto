import view.InputView

fun main() {
    val expression = InputView.getExpression()
    val result = Calculator().execute(expression)

    println(result)
}
