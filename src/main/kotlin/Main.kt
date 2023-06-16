import calculator.ExpressionParser
import calculator.ResultView
import calculator.StringCalculator

fun main() {
    val input = readLine()!!

    val expressionParser = ExpressionParser()
    val checkData = expressionParser.checkNullOrEmpty(input)
    val calculateTargetData = expressionParser.parseInputData(checkData)

    val result = StringCalculator(calculateTargetData).execute()
    ResultView().showResult(result)
}
