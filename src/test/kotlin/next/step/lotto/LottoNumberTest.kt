package next.step.lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual

class LottoNumberTest : DescribeSpec({

    describe("LottoNumber 생성") {
        context("1보다 작은 숫자로 생성하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> { LottoNumber.of(0) }
            }
        }

        context("45보다 큰 숫자로 생성하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> { LottoNumber.of(46) }
            }
        }

        context("랜덤으로 생성하면") {
            it("1과 45 사이의 숫자로 생성됨").config(invocations = 1000) {
                val number = LottoNumber.random().number()
                
                assertSoftly {
                    number shouldBeGreaterThanOrEqual LottoNumber.MIN_LOTTO_NUMBER
                    number shouldBeLessThanOrEqual LottoNumber.MAX_LOTTO_NUMBER
                }
            }
        }
    }
})
