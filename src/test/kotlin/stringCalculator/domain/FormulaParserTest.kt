package stringCalculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import stringCalculator.domain.FormulaFormatException.NegativeNumberException
import stringCalculator.domain.FormulaFormatException.NotNumberFormatException

class FormulaParserTest : FunSpec({
    context("숫자식 내(구분자에 영향없는)숫자 형식을 제외한 것이 입력되면 오류를 발생한다.") {
        test(": 구분자") {
            listOf("1:2:%:4", "1:45,:2", "1:65:77^").forAll { formula ->
                shouldThrow<NotNumberFormatException> {
                    FormulaParser.toNumbers(
                        CustomSeparatorParser(formula),
                        ColonSeparatorParser(formula),
                        CommaSeparatorParser(formula),
                    )
                }
            }
        }
        test(", 구분자") {
            listOf("1,2,%,4", "1,45:,2", "1,65,77^").forAll { formula ->
                shouldThrow<NotNumberFormatException> {
                    FormulaParser.toNumbers(
                        CustomSeparatorParser(formula),
                        ColonSeparatorParser(formula),
                        CommaSeparatorParser(formula),
                    )
                }
            }
        }
        test("커스텀 구분자") {
            listOf("//$\n1$%2$3$4", "//%\n1&45%2", "//+\n1++65+77").forAll { formula ->
                shouldThrow<NotNumberFormatException> {
                    FormulaParser.toNumbers(
                        CustomSeparatorParser(formula),
                        ColonSeparatorParser(formula),
                        CommaSeparatorParser(formula),
                    )
                }
            }
        }
    }

    context("숫자식 내(구분자에 영향없는)음수가 입력되면 오류를 발생한다.") {
        test(": 구분자") {
            listOf("1:-2:3:4", "1:-45:2", "1:65:-77").forAll { formula ->
                shouldThrow<NegativeNumberException> {
                    FormulaParser.toNumbers(
                        CustomSeparatorParser(formula),
                        ColonSeparatorParser(formula),
                        CommaSeparatorParser(formula),
                    )
                }
            }
        }
        test(", 구분자") {
            listOf("1,-2,3,4", "1,-45,2", "1,65,-77").forAll { formula ->
                shouldThrow<NegativeNumberException> {
                    FormulaParser.toNumbers(
                        CustomSeparatorParser(formula),
                        ColonSeparatorParser(formula),
                        CommaSeparatorParser(formula),
                    )
                }
            }
        }
        test("커스텀 구분자") {
            listOf("//$\n1$-2$3$4", "//%\n1%-45%2", "//+\n1+65+-77").forAll { formula ->
                shouldThrow<NegativeNumberException> {
                    FormulaParser.toNumbers(
                        CustomSeparatorParser(formula),
                        ColonSeparatorParser(formula),
                        CommaSeparatorParser(formula),
                    )
                }
            }
        }
    }
})
