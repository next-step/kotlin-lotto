package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoTest : DescribeSpec({
    describe("로또를 생성한다") {
        context("6자리가 아닌경우 exception throw") {
            it("LottoNumber가 5자리인 경우") {
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        Lotto(1, 2, 3, 4, 5)
                    }
                exception.message shouldBe "정확히 6개의 숫자를 입력해야 합니다."
            }

            it("LottoNumber가 7자리인 경우") {
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        Lotto(1, 2, 3, 4, 5, 6, 7)
                    }
                exception.message shouldBe "정확히 6개의 숫자를 입력해야 합니다."
            }
        }

        context("6자리인 경우") {
            it("로또를 생성한다.") {
                shouldNotThrow<IllegalArgumentException> {
                    Lotto(1, 2, 3, 4, 5, 6)
                }
            }
        }

        context("중복이 있는 경우") {
            it("exception throw") {
                shouldThrow<IllegalArgumentException> { Lotto(1, 1, 1, 1, 1, 1) }
            }
        }
    }
})
