package me.parker.nextstep.kotlinlotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import me.parker.nextstep.kotlinlotto.domain.LottoNumber
import me.parker.nextstep.kotlinlotto.domain.ManualLottoNumberGenerationRule
import me.parker.nextstep.kotlinlotto.domain.RandomLottoNumberGenerationRule

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

        context("랜덤 로또 번호 생성 규칙을 주입하면") {
            it("정상적으로 LottoNumber 객체를 생성한다.") {
                val lottoNumber = LottoNumber(RandomLottoNumberGenerationRule())
                lottoNumber.number shouldBeInRange 1..45
            }
        }

        context("1 ~ 45 사이의 수동 로또 번호 생성 규칙을 주입하면") {
            it("정상적으로 LottoNumber 객체를 생성한다.") {
                shouldNotThrow<Exception> { LottoNumber(ManualLottoNumberGenerationRule(1)) }
            }
        }

        context("1 ~ 45 이외의 수동 로또 번호 생성 규칙을 주입하면") {
            it("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumber(ManualLottoNumberGenerationRule(50))
                }.message shouldBe "로또 번호는 1 ~ 45 사이만 가능합니다."
            }
        }
    }
})