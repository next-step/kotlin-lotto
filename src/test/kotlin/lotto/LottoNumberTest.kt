package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeSortedWith
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoNumberTest : FunSpec({
    context("로또 번호 자동 생성") {
        test("번호는 6개의 숫자로 이루어진다.") {
            val actual = LottoNumber.autoGenerate()
            actual.numbers.shouldBeInstanceOf<List<Int>>()
            actual.numbers shouldHaveSize 6
        }

        test("각 숫자는 1 ~ 45 사이의 숫자로 생성된다.") {
            repeat(100) {
                val actual = LottoNumber.autoGenerate()
                actual.numbers.forEach { value ->
                    value shouldBeInRange (1..45)
                }
            }
        }

        test("번호는 오름차순으로 정렬되어 있다.") {
            val actual = LottoNumber.autoGenerate()
            actual.numbers shouldBeSortedWith { a, b -> a - b }
        }

        test("번호는 중복된 숫자를 가질 수 없다.") {
            repeat(100) {
                val actual = LottoNumber.autoGenerate()
                actual.numbers.toSet() shouldHaveSize 6
            }
        }
    }

    context("로또 번호 수동 생성") {
        context("예외 사항") {
            context("6개의 숫자를 전달하지 않으면") {
                test("로또 번호를 생성할 수 없다.") {
                    val numbers = listOf(10, 20, 30, 40, 11)
                    assertThrows<IllegalArgumentException> { LottoNumber.manualGenerate(numbers = numbers) }
                }
            }

            context("1 ~ 45 사이의 숫자를 전달하지 않으면") {
                test("로또 번호를 생성할 수 없다.") {
                    val numbers = listOf(10, 20, 30, 40, 50, 60)
                    assertThrows<IllegalArgumentException> { LottoNumber.manualGenerate(numbers = numbers) }
                }
            }

            context("중복된 숫자를 전달하면") {
                test("로또 번호를 생성할 수 없다.") {
                    val numbers = listOf(10, 20, 30, 40, 30, 20)
                    assertThrows<IllegalArgumentException> { LottoNumber.manualGenerate(numbers = numbers) }
                }
            }
        }

        context("정상 생성") {
            context("올바른 값을 전달하면") {
                test("로또 번호를 생성할 수 있다.") {
                    val numbers = listOf(10, 22, 31, 5, 36, 42)
                    val actual = LottoNumber.manualGenerate(numbers = numbers)
                    actual.numbers shouldContainExactlyInAnyOrder numbers
                    test("번호는 오름차순으로 정렬되어 있다.") {
                        actual.numbers shouldBeSortedWith { a, b -> a - b }
                    }
                }
            }
        }
    }

    context("로또 번호 당첨 비교") {
        context("당첨 번호를 전달하면") {
            test("맞춘 갯수를 구할 수 있다.") {
                val winningNumber = WinningNumber.from(listOf(10, 20, 30, 15, 25, 35))
                val sut = LottoNumber.manualGenerate(listOf(10, 20, 30, 1, 2, 3))
                val actual = sut.matchCount(winningNumber = winningNumber)
                actual shouldBe 3
            }
        }
    }
})
