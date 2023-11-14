package me.parker.nextstep.kotlinlotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : DescribeSpec({

    describe("LottoNumber VO 생성") {
        context("1 ~ 45 사이 숫자가 주어지면") {
            it("정상적으로 LottoNumber 객체를 생성한다.") {
                for (num in 1..45) {
                    shouldNotThrow<Exception> {
                        LottoNumber(num)
                    }
                }
            }
        }

        context("1 ~ 45 사이 숫자가 아닌 숫자가 주어지면") {
            it("예외가 발생한다.") {
                for (num in 46..100) {
                    shouldThrow<IllegalArgumentException> {
                        LottoNumber(num)
                    }.message shouldBe "로또 번호는 1 ~ 45 사이만 가능합니다."
                }
                for (num in -100..0) {
                    shouldThrow<IllegalArgumentException> {
                        LottoNumber(num)
                    }.message shouldBe "로또 번호는 1 ~ 45 사이만 가능합니다."
                }
            }
        }
    }
})
