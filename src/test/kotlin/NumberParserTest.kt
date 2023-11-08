import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class NumberParserTest : FunSpec({
    context("문자열 파서에 쉼표(,) 또는 콜론(:)을 구분자로 하는 숫자들을 전달하는 경우 구분자를 기준으로 숫자를 분리하여 반환한다") {
        withData(
            row(null, listOf(0)),
            row("", listOf(0)),
            row("1", listOf(1)),
            row("1,2", listOf(1, 2)),
            row("1:2", listOf(1, 2)),
            row("1:2,3", listOf(1, 2, 3))
        ) { (input, output) ->
            val numberParser = NumberParser()
            val actual = numberParser.parseNumbers(input)
            actual shouldBe output
        }
    }
})
