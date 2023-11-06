package stringLettersCalculator

fun main() {
    val inputLetters = CalculatorView.inputLetters("문자열 수식을 입력해 주세요.")

    val stringCalculatorController = StringCalculatorController()
    val result = stringCalculatorController.answerToSum(inputLetters)

    CalculatorView.printResult(result)
}
