package next.step.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoWinningNumbersTest : DescribeSpec({
    describe("LottoWinningNumbers 생성") {
        context("6개 숫자로 생성") {
            it("오류 없이 생성되고 숫자 개수 6개로 제공") {
                LottoWinningNumbers.from(setOf(1, 2, 3, 4, 5, 6)).size() shouldBe 6
            }
        }

        context("6개가 아닌 숫자로 생성하면 예외 발생") {
            withData(
                listOf(
                    setOf(1, 2, 3, 4, 5),
                    setOf(1, 2, 3, 4, 5, 6, 7),
                    setOf(1, 2)
                )
            ) { numberSet ->
                shouldThrow<IllegalArgumentException> {
                    LottoWinningNumbers.from(numberSet)
                }
            }
        }
    }

})
