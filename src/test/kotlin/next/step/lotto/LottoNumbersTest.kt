package next.step.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize

class LottoNumbersTest : DescribeSpec({
    describe("LottoNumbers 생성") {
        context("6개보다 많은 LottoNumber로 생성하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers.of((1..7).map { LottoNumber.of(it) }.toSet())
                }
            }
        }
        context("6개보다 적은 LottoNumber로 생성하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers.of((1..5).map { LottoNumber.of(it) }.toSet())
                }
            }
        }
        context("랜덤으로 생성하면") {
            it("모두 다른 6개의 LottoNumber를 가짐").config(invocations = 1000) {
                val numbers = LottoNumbers.random().numbers()
                println(numbers)

                numbers shouldHaveSize 6
            }
        }
    }

})
