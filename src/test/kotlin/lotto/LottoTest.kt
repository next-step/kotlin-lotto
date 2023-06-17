package lotto

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder

class LottoTest : FreeSpec({

    "로또는 중복 없이 무작위로 선택된 숫자 6개(1~45)로 구성된다." - {
        "성공" {
            forAll(
                row(listOf(1, 20, 35, 40, 42, 44)),
                row(listOf(8, 3, 4, 5, 6, 7)),
                row(listOf(42, 11, 30, 13, 14, 15)),
            ) { numbers ->
                val sut = Lotto.from(numbers)

                val result = sut.numbers

                result shouldContainExactlyInAnyOrder numbers
            }
        }

        "실패 - 숫자 개수 6개 불일치" {
            forAll(
                row(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                row(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)),
            ) { numbers ->
                shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 중복 없이 6개만 입력 가능합니다.") { Lotto.from(numbers) }
            }
        }

        "실패 - 숫자 범위 1~45 벗어남" {
            forAll(
                row(listOf(0, 2, 3, 4, 5, 6)),
                row(listOf(-3, 2, 3, 4, 5, 100000)),
            ) { numbers ->
                shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 1~45 사이만 입력 가능합니다.") { Lotto.from(numbers) }
            }
        }
    }

})
