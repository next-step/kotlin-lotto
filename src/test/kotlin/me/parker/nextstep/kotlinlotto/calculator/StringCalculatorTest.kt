package me.parker.nextstep.kotlinlotto.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : BehaviorSpec({

    given("기본 구분자 문자열 계산기") {
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

    given("커스텀 구분자 문자열 계산기") {
        `when`("커스텀 구분자를 사용하는 '//;\n1;2;3'를 입력하면, ") {
            then("6을 반환한다.") {
                StringCalculator.add("//;\n1;2;3") shouldBe 6
            }
        }

        `when`("커스텀 구분자를 사용하는 '//;\n1;2:3'를 입력하면, ") {
            then("6을 반환한다.") {
                StringCalculator.add("//;\n1;2:3") shouldBe 6
            }
        }

        `when`("커스텀 구분자를 사용하는 '//;\n1,2;3'를 입력하면, ") {
            then("6을 반환한다.") {
                StringCalculator.add("//;\n1,2;3") shouldBe 6
            }
        }
    }

    given("유효하지 않은 입력이 포함된 문자열 계산기") {
        `when`("음수를 포함하는 '1:-2:3'를 입력하면, ") {
            then("RuntimeException 예외가 발생한다.") {
                val exception = shouldThrow<RuntimeException> {
                    StringCalculator.add("1:-2:3")
                }
                exception.message shouldBe "음수는 입력할 수 없습니다."
            }
        }

        `when`("음수를 포함하는 '-1,2:3'를 입력하면, ") {
            then("RuntimeException 예외가 발생한다.") {
                val exception = shouldThrow<RuntimeException> {
                    StringCalculator.add("-1,2:3")
                }
                exception.message shouldBe "음수는 입력할 수 없습니다."
            }
        }

        `when`("숫자가 아닌 값을 포함하는 'a,2:3'를 입력하면, ") {
            then("RuntimeException 예외가 발생한다.") {
                shouldThrow<RuntimeException> {
                    StringCalculator.add("a,2:3")
                }
            }
        }
    }
})