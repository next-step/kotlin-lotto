package next.step.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec

class LottoNumberTest : DescribeSpec({

    describe("로또 번호 생성") {
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
    }
})
