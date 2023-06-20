package next.step.lotto.domain

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual

class LottoNumberGeneratorTest : DescribeSpec({
    describe("랜덤 생성") {
        context("랜덤으로 생성하면") {
            it("1과 45 사이의 숫자로 생성됨").config(invocations = 1000) {
                val number = LottoNumberGenerator.random()()
                println(number)

                assertSoftly {
                    number.minOf { it.number } shouldBeGreaterThanOrEqual LottoNumber.MIN_LOTTO_NUMBER
                    number.maxOf { it.number } shouldBeLessThanOrEqual LottoNumber.MAX_LOTTO_NUMBER
                }
            }
        }

        context("랜덤으로 생성하면") {
            it("모두 다른 6개의 LottoNumber를 가짐").config(invocations = 1000) {
                val numbers = LottoNumberGenerator.random()()
                println(numbers)

                numbers shouldHaveSize 6
            }
        }
    }
})
