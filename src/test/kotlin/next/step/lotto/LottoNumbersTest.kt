package next.step.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoNumbersTest : DescribeSpec({

    describe("LottoNumbers 생성") {
        context("6개보다 많은 LottoNumber로 생성하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers.from((1..7).toSet())
                }
            }
        }

        context("6개보다 적은 LottoNumber로 생성하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers.from((1..5).toSet())
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

        context("같은 번호들로 생성하면") {
            it("동등함") {
                LottoNumbers.from((1..6).toSet()) shouldBe LottoNumbers.from((1..6).toSet())
            }
        }
    }

})
