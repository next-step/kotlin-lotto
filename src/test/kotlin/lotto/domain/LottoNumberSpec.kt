package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.error.InvalidLottoNumberException

class LottoNumberSpec : FunSpec({
    test("해당 숫자가 로또 번호에 포함되어 있는지 확인한다") {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        forAll(
            row(1, true),
            row(2, true),
            row(3, true),
            row(4, true),
            row(5, true),
            row(6, true),
            row(7, false),
        ) { number, expect ->
            val result = LottoNumber(numbers) contains number

            result shouldBe expect
        }
    }

    test("두 로또 숫자에 공통으로 있는 숫자 개수가 계산된다") {
        val number1 = LottoNumber(listOf(1, 2, 3, 4, 5, 6))
        val number2 = LottoNumber(listOf(10, 9, 3, 2, 1, 8))

        val result = number1 countMatched number2

        result shouldBe 3
    }

    context("로또 번호가 될 수 있는 수인지 검증") {
        test("1부터 45 사이의 숫자라면 해당 숫자가 반환된다") {
            forAll(
                row(1),
                row(13),
                row(45),
            ) { number ->
                val result = LottoNumber.checkCanInclude(number)

                result shouldBe number
            }
        }
        test("1보다 작은 숫자라면 에러가 발생한다") {
            shouldThrow<InvalidLottoNumberException> {
                LottoNumber.checkCanInclude(0)
            }
        }
        test("45보다 큰 숫자라면 에러가 발생한다") {
            shouldThrow<InvalidLottoNumberException> {
                LottoNumber.checkCanInclude(46)
            }
        }
    }

    context("당첨 번호 검증 및 생성") {
        test("1부터 45까지의 6개의 서로 다른 숫자인지 검증") {
            val numbers = listOf(1, 2, 3, 4, 13, 23)

            val result = LottoNumber.of(numbers)

            result.value shouldBe numbers
        }

        test("오름 차순으로 정렬되지 않았다면 로또 번호 생성시 정렬") {
            val numbers = listOf(6, 1, 5, 3, 4, 2)

            val number = LottoNumber.of(numbers)

            number.value shouldBe listOf(1, 2, 3, 4, 5, 6)
        }

        test("6개의 숫자가 아닐 경우 로또 번호 생성 불가") {
            forAll(
                row(listOf(1, 2, 3, 4, 13, 23, 33)),
                row(listOf(1, 2, 3, 4, 13)),
            ) { numbers ->
                shouldThrow<InvalidLottoNumberException> {
                    LottoNumber.of(numbers)
                }
            }
        }

        test("1부터 45까지의 범위를 넘으면 로또 번호 생성 불가") {
            forAll(
                row(listOf(1, 2, 3, 4, 13, 46)),
                row(listOf(0, 1, 2, 3, 4, 13)),
            ) { numbers ->
                shouldThrow<InvalidLottoNumberException> {
                    LottoNumber.of(numbers)
                }
            }
        }

        test("중복된 숫자가 있으면 로또 번호 생성 불가") {
            shouldThrow<InvalidLottoNumberException> {
                LottoNumber.of(listOf(1, 2, 3, 4, 5, 5))
            }
        }
    }
})
