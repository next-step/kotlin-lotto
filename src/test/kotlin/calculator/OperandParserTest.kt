package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

internal class OperandParserTest : FunSpec({
    data class OperandParserTestData(
        val expression: String,
        val delimiter: List<String>,
    )

    context("입력값에서 //와 \n 사이에 위치하는 커스텀 구분자를 이용하여 수식을 파싱할 수 있다.") {
        withData(
            OperandParserTestData("//;\n1;2;3", listOf(";")) to listOf(1, 2, 3),
            OperandParserTestData("//!\n1!2!3", listOf("!")) to listOf(1, 2, 3),
            OperandParserTestData("//@\n1@2@3", listOf("@")) to listOf(1, 2, 3),
        ) { (data, result) ->
            OperandParser.run(data.expression, data.delimiter) shouldBe result
        }
    }

    context("디폴트 구분자를 이용하여 수식을 파싱할 수 있다.") {
        withData(
            OperandParserTestData("1,2,3", listOf(",", ":")) to listOf(1, 2, 3),
            OperandParserTestData("1:2:3", listOf(",", ":")) to listOf(1, 2, 3),
            OperandParserTestData("1,2:3", listOf(",", ":")) to listOf(1, 2, 3),
        ) { (data, result) ->
            OperandParser.run(data.expression, data.delimiter) shouldBe result
        }
    }
})
