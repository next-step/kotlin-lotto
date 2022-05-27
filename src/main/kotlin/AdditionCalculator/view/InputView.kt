package AdditionCalculator.view

object InputView {
  fun getExpression(message: String): String? {
    println(message)
    return readLine()
  }
}
