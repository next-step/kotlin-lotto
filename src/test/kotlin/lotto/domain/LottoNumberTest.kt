package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class LottoNumberTest : DescribeSpec({
    describe("constructor") {
        context("1~45 숫자가 주어지면") {
            it("로또 번호가 생성된다") {
                listOf(1, 10, 45).forAll {
                    LottoNumber(it) shouldNotBe null
                }
            }
        }

        context("1~45 이외의 숫자가 주어지면") {
            it("IllegalArgumentException 예외가 발생한다") {
                listOf(-1, 0, 46).forAll {
                    shouldThrow<IllegalArgumentException> {
                        LottoNumber(it)
                    }
                }
            }
        }
    }

    describe("equals") {
        context("같은 로또 번호를 가진 객체가 주어지면") {
            it("true 를 반환한다") {
                (LottoNumber(5) == LottoNumber(5)) shouldBe true
            }
        }
        context("다른 로또 번호를 가진 객체가 주어지면") {
            it("false 를 반환한다") {
                (LottoNumber(1) == LottoNumber(5)) shouldBe false
            }
        }
    }
})
