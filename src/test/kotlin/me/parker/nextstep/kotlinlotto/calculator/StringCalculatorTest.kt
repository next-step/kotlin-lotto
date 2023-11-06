package me.parker.nextstep.kotlinlotto.calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : BehaviorSpec({

    given("문자열 계산기 입력") {
        `when`("기본 구분자 ':'를 사용하는 '1:2'를 입력하면, ") {
            then("3을 반환한다.") {
                StringCalculator.add("1:2") shouldBe 3
            }
        }

        `when`("기본 구분자 ','를 사용하는 '1,2'를 입력하면, ") {
            then("3을 반환한다.") {
                StringCalculator.add("1,2") shouldBe 3
            }
        }

        `when`("기본 구분자 두 개 모두를 사용하는 '1,2:3'를 입력하면, ") {
            then("6을 반환한다.") {
                StringCalculator.add("1,2:3") shouldBe 6
            }
        }

        `when`("기본 구분자 두 개 모두를 사용하는 '1:2,3'를 입력하면, ") {
            then("6을 반환한다.") {
                StringCalculator.add("1:2,3") shouldBe 6
            }
        }
    }
})