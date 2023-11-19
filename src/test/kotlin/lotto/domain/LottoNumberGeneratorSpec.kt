package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe
import lotto.error.InvalidLottoNumberException

class LottoNumberGeneratorSpec : FunSpec({
    context("로또 번호 생성") {
        val number = LottoNumberGenerator.createFrom()

        test("생성된 숫자는 1이상 45이하") {
            number.value.forEach {
                1..45 shouldContain it
            }
        }

        test("생성된 숫자는 6개의 숫자") {
            number.value.size shouldBe 6
        }

        test("생성된 숫자는 서로 다른 숫자") {
            number.value.size shouldBe number.value.toSet().size
        }

        test("생성된 숫자는 오름차순으로 구성") {
            number.value.zipWithNext { before, next -> before shouldBeLessThan next }
        }
    }

    context("당첨 번호 검증 및 생성") {
        test("1부터 45까지의 6개의 서로 다른 숫자인지 검증") {
            val numbers = listOf(1, 2, 3, 4, 13, 23)

            val result = LottoNumberGenerator.createFrom(numbers)

            result.value shouldBe numbers
        }

        test("오름 차순으로 정렬되지 않았다면 로또 번호 생성시 정렬") {
            val numbers = listOf(6, 1, 5, 3, 4, 2)

            val number = LottoNumberGenerator.createFrom(numbers)

            number.value shouldBe listOf(1, 2, 3, 4, 5, 6)
        }

        test("6개의 숫자가 아닐 경우 로또 번호 생성 불가") {
            forAll(
                row(listOf(1, 2, 3, 4, 13, 23, 33)),
                row(listOf(1, 2, 3, 4, 13)),
            ) { numbers ->
                shouldThrow<InvalidLottoNumberException> {
                    LottoNumberGenerator.createFrom(numbers)
                }
            }
        }

        test("1부터 45까지의 범위를 넘으면 로또 번호 생성 불가") {
            forAll(
                row(listOf(1, 2, 3, 4, 13, 46)),
                row(listOf(0, 1, 2, 3, 4, 13)),
            ) { numbers ->
                shouldThrow<InvalidLottoNumberException> {
                    LottoNumberGenerator.createFrom(numbers)
                }
            }
        }

        test("중복된 숫자가 있으면 로또 번호 생성 불가") {
            shouldThrow<InvalidLottoNumberException> {
                LottoNumberGenerator.createFrom(listOf(1, 2, 3, 4, 5, 5))
            }
        }
    }

    context("로또 번호가 될 수 있는 수인지 검증") {
        test("1부터 45 사이의 숫자라면 해당 숫자가 반환된다") {
            forAll(
                row(1),
                row(13),
                row(45),
            ) { number ->
                val result = LottoNumberGenerator.checkNumber(number)

                result shouldBe number
            }
        }
        test("1보다 작은 숫자라면 에러가 발생한다") {
            shouldThrow<InvalidLottoNumberException> {
                LottoNumberGenerator.checkNumber(0)
            }
        }
        test("45보다 큰 숫자라면 에러가 발생한다") {
            shouldThrow<InvalidLottoNumberException> {
                LottoNumberGenerator.checkNumber(46)
            }
        }
    }
})
