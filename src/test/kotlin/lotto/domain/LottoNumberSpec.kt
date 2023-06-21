package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoNumberSpec : DescribeSpec({
    describe("로또 번호 범위(1이상 45이하) 검증") {
        it("로또 번호 1은 정상적으로 생성된다.") {
            val lottoNumber = LottoNumber(1)

            lottoNumber.value shouldBe 1
        }
        it("로또 번호 22은 정상적으로 생성된다.") {
            val lottoNumber = LottoNumber(22)

            lottoNumber.value shouldBe 22
        }
        it("로또 번호 45은 정상적으로 생성된다.") {
            val lottoNumber = LottoNumber(45)

            lottoNumber.value shouldBe 45
        }

        context("로또 번호가 1보다 작으면") {
            it("예외가 발생한다.") {
                val number = 0
                shouldThrow<IllegalArgumentException> {
                    LottoNumber(number)
                }
            }
        }

        context("로또 번호가 45보다 크면") {
            it("예외가 발생한다.") {
                val number = 46
                shouldThrow<IllegalArgumentException> {
                    LottoNumber(number)
                }
            }
        }
    }
})
