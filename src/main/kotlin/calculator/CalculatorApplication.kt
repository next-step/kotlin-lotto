package calculator

fun main() {
    val inputView = InputView()
    val input = inputView.input()
    val parser = Parser()
    val parse = parser.parse(input)
    val numbers = Numbers(parse)
    val result = numbers.sum()
    print(result)
}