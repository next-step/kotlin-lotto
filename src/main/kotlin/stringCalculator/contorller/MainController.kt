package stringCalculator.contorller

import stringCalculator.domain.ColonSeparatorParser
import stringCalculator.domain.CommaSeparatorParser
import stringCalculator.domain.CustomSeparatorParser
import stringCalculator.domain.FormulaFormatException
import stringCalculator.domain.FormulaFormatException.CustomSeparatorFormatException
import stringCalculator.domain.FormulaFormatException.NegativeNumberException
import stringCalculator.domain.FormulaFormatException.NotNumberFormatException
import stringCalculator.domain.FormulaFormatException.UndefinedFormatException
import stringCalculator.domain.FormulaParser

class MainController(private val view: View) {
    fun start() {
        val formula = view.getFormula() ?: return
        val parsedFormula = getParsedFormula(formula) ?: return
        view.showAnswer(parsedFormula.sum())
    }

    private fun getParsedFormula(formula: String): List<Int>? =
        kotlin.runCatching {
            FormulaParser.toNumbers(
                CustomSeparatorParser(formula),
                ColonSeparatorParser(formula),
                CommaSeparatorParser(formula),
            )
        }.onFailure {
            view.showErrorMessage(getErrorMessage(it))
        }.getOrNull()

    private fun getErrorMessage(throwable: Throwable): String {
        throwable as? FormulaFormatException ?: throw IllegalStateException("지정하지 않은 않은 에러 발생")
        return when (throwable) {
            is CustomSeparatorFormatException -> "커스텀 구분자 입력 형식을 확인하세요."
            is NotNumberFormatException -> "숫자 입력 자리에 문자가 입력되었습니다.(구분자를 확인해주세요 에러상황 유력)"
            is UndefinedFormatException -> "정의되지 않은 포멧의 식입니다."
            is NegativeNumberException -> "음수가 입력 되었습니다."
        }
    }
}
