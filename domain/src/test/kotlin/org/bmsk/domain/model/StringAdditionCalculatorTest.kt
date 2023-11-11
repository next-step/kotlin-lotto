package org.bmsk.domain.model

import io.kotest.assertions.throwables.shouldNotThrowExactly
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringAdditionCalculatorTest : FunSpec({

    context("구분자를 기준으로 숫자를 분리해낸다.") {
        test("빈 문자열이면 빈 리스트를 반환한다.") {
            StringAdditionCalculator("").separate() shouldBe emptyList()
        }

        test("\"1,2\"는 [1, 2]이다.") {
            StringAdditionCalculator("1,2").separate() shouldBe listOf(1, 2)
        }

        test("\"1,2,3\"은 [1, 2, 3]이다.") {
            StringAdditionCalculator("1,2,3").separate() shouldBe listOf(1, 2, 3)
        }

        test("\"1\"은 [1]이다.") {
            StringAdditionCalculator("1").separate() shouldBe listOf(1)
        }

        test("\"1,2:3\"은 [1, 2, 3]이다.") {
            StringAdditionCalculator("1,2:3").separate() shouldBe listOf(1, 2, 3)
        }
    }

    context("숫자들의 합을 계산한다.") {
        test("빈 문자열이면 0을 반환한다.") {
            StringAdditionCalculator("").calculate() shouldBe 0
        }

        context("숫자 이외의 값이나 음수가 전달되는 경우 RuntimeException 예외를 발생시킨다.") {
            test("\"-1,2,3\"은 예외가 발생해야 한다.") {
                shouldThrowExactly<RuntimeException> {
                    StringAdditionCalculator("-1,2,3")
                }
            }
            test("\"//;\\n1;2;-3\"은 예외가 발생한다.") {
                shouldThrowExactly<RuntimeException> {
                    StringAdditionCalculator("//;\n1;2;-3")
                }
            }
            test("//-\\n1;2;-3은 예외가 발생한다.") {
                shouldThrowExactly<RuntimeException> {
                    StringAdditionCalculator("//-\n1;2;-3")
                }
            }
            test("//-\\n1:2:-3은 예외가 발생 하지 않는다.") {
                shouldNotThrowExactly<IllegalArgumentException> {
                    StringAdditionCalculator("//-\n1:2:-3")
                }
            }
            test("\"1, 2, 3\"은 예외가 발생한다.") {
                shouldThrowExactly<IllegalArgumentException> {
                    StringAdditionCalculator("1, 2, 3")
                }
            }
        }

        test("\"1,2\"는 3이다.") {
            StringAdditionCalculator("1,2").calculate() shouldBe 3
        }

        test("\"1,2,3\"은 6이다.") {
            StringAdditionCalculator("1,2,3").calculate() shouldBe 6
        }

        test("\"1\"은 [1]이다.") {
            StringAdditionCalculator("1").calculate() shouldBe 1
        }

        test("\"1,2:3\"은 6이다.") {
            StringAdditionCalculator("1,2:3").calculate() shouldBe 6
        }
    }
})
