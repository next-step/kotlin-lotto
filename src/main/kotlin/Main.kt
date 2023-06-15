import calculator.ExpressionParser
import calculator.ResultView
import calculator.StringCalculator

fun main() {
    val input = readln()

    val expressionParser = ExpressionParser()
    val checkData = expressionParser.checkNullOrEmpty(input)
    val calculateTargetData = expressionParser.isExistCustomDelimiter(checkData)?.let {
        expressionParser.parseCustomDelimiter(it)
    } ?: expressionParser.parseDelimiter(checkData)

    val result = StringCalculator(calculateTargetData).execute()
    ResultView().showResult(result)
}
