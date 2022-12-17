package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class WInningNumberTest : FunSpec({
    context("당첨 번호 생성") {
        test("번호는 전달받은 값으로 생성된다.") {
            val numbers = listOf(10, 27, 45, 33, 21, 42)
            val winningNumber = WinningNumber.from(numbers = numbers)
            winningNumber.numbers shouldContainExactly numbers
        }

        context("6개의 숫자를 전달하지 않으면") {
            test("당청 번호를 생성할 수 없다.") {
                val numbers = listOf(10, 27, 45, 33)
                assertThrows<IllegalArgumentException> { WinningNumber.from(numbers = numbers) }
            }
        }

        context("6개의 숫자를 전달하면") {
            test("당청 번호를 생성할 수 있다.") {
                val numbers = listOf(10, 27, 45, 33, 21, 42)
                val winningNumber = WinningNumber.from(numbers = numbers)
                winningNumber.numbers shouldHaveSize 6
            }

            context("1 ~ 45 사이의 숫자를 전달하지 않으면") {
                test("당첨 번호를 생성할 수 없다.") {
                    val numbers = listOf(55, 45, 20, 60, 70, 3)
                    assertThrows<IllegalArgumentException> { WinningNumber.from(numbers = numbers) }
                }
            }

            context("1 ~ 45 사이의 숫자를 전달하면") {
                test("당첨 번호를 생성할 수 있다.") {
                    val numbers = listOf(10, 27, 45, 33, 21, 42)
                    val winningNumber = WinningNumber.from(numbers = numbers)
                    winningNumber.numbers shouldContainExactly numbers
                }

                context("중복된 숫자를 전달하면") {
                    test("당첨 번호를 생성할 수 없다.") {
                        val numbers = listOf(10, 10, 20, 20, 33, 44)
                        assertThrows<IllegalArgumentException> { WinningNumber.from(numbers = numbers) }
                    }
                }

                context("중복되지 않은 숫자를 전달하면") {
                    test("당첨 번호를 생성할 수 있다.") {
                        val numbers = listOf(10, 27, 45, 33, 21, 42)
                        val winningNumber = WinningNumber.from(numbers = numbers)
                        winningNumber.numbers shouldContainExactly numbers
                    }
                }
            }
        }
    }
})
