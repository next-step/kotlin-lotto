package next.step.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoNumberParserTest : DescribeSpec({
    describe("LottoNumberParser parse") {
        context("번호가 콤마로 구분해서 전달되면") {
            it("번호 6개만큼 생성") {
                LottoNumberParser.parse("1, 2, 3, 4, 5, 6").size shouldBe 6
            }
        }

        context("번호가 콤마로 구분해서 숫자가 아니면, 예외 발생") {
            withData(
                listOf(
                    "1, 2, 3, 4, a",
                    "1, 2, 3, 4, b, 6, 7",
                    "c"
                )
            ) { numbersStr ->
                shouldThrow<IllegalArgumentException> {
                    LottoNumberParser.parse(numbersStr)
                }
            }
        }
    }

})

