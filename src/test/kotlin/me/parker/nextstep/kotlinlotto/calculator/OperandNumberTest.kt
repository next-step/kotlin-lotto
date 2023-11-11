package me.parker.nextstep.kotlinlotto.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

class OperandNumberTest : BehaviorSpec({

        given("피연산자 숫자") {
            `when`("양수(숫자)를 입력하면, ") {
                then("OperandNumber 객체를 생성한다.") {
                    OperandNumber(1)
                }
            }

            `when`("음수(숫자)를 입력하면, ") {
                then("RuntimeException 예외가 발생한다.") {
                    shouldThrow<RuntimeException> {
                        OperandNumber(-1)
                    }
                }
            }

            `when`("양수(문자열)를 입력하면, ") {
                then("OperandNumber 객체를 생성한다.") {
                    OperandNumber("1")
                }
            }

            `when`("음수(문자열)를 입력하면, ") {
                then("RuntimeException 예외가 발생한다.") {
                    shouldThrow<RuntimeException> {
                        OperandNumber("-1")
                    }
                }
            }
        }
})
