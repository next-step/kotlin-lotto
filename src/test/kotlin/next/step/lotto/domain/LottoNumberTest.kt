package next.step.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equals.shouldBeEqual

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

        context("같은 값으로 생성하면") {
            it("동등함") {
                LottoNumber.of(1) shouldBeEqual LottoNumber.of(1)
            }
        }
    }
})
