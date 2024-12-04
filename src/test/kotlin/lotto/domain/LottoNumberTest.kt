package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class LottoNumberTest : DescribeSpec({
    describe("LottoNumber를 생성한다.") {
        context("1 ~ 45 숫자를 생성한다.") {
            it("LottoNumber 1을 생성한다.") {
                val actual = LottoNumber(1)
                actual.number shouldBe 1
            }

            it("LottoNumber 45을 생성한다.") {
                val actual = LottoNumber(45)
                actual.number shouldBe 45
            }
        }

        context("1 ~ 45 사이 숫자가 아니면 throw exception") {
            it("1보다 작은 경우 경우 throw exception") {
                val exception =
                    assertThrows<IllegalArgumentException> {
                        LottoNumber(0)
                    }
                exception.message shouldBe "Lotto number must be between 1 and 45."
            }

            it("45보다 큰 경우 throw exception") {
                val exception =
                    assertThrows<IllegalArgumentException> {
                        LottoNumber(46)
                    }
                exception.message shouldBe "Lotto number must be between 1 and 45."
            }
        }
    }
})
