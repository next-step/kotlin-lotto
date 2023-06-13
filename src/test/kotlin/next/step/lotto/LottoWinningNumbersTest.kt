package next.step.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoWinningNumbersTest : DescribeSpec({
    describe("LottoWinningNumbers 생성") {
        context("당첨 번호가 콤마로 구분해서 전달되면") {
            it("당첨 번호 6개만큼 생성") {
                LottoWinningNumbers.from("1, 2, 3, 4, 5, 6").size shouldBe 6
            }
        }

        context("당첨 번호가 콤마로 구분해서 6개가 아니면, 예외 발생") {
            withData(
                listOf(
                    "1, 2, 3, 4, 5",
                    "1, 2, 3, 4, 5, 6, 7",
                    "1"
                )
            ) { numbersStr ->
                shouldThrow<IllegalArgumentException> {
                    LottoWinningNumbers.from(numbersStr)
                }
            }
        }

        context("당첨 번호가 콤마로 구분해서 숫자가 아니면, 예외 발생") {
            withData(
                listOf(
                    "1, 2, 3, 4, a",
                    "1, 2, 3, 4, b, 6, 7",
                    "c"
                )
            ) { numbersStr ->
                shouldThrow<IllegalArgumentException> {
                    LottoWinningNumbers.from(numbersStr)
                }
            }
        }
    }

})
