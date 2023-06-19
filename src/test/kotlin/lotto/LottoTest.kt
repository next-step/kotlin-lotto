package lotto

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import lotto.test.lottoNumbersOf

class LottoTest : FreeSpec({

    "로또는 중복 없는 로또 번호 6개(1~45)로 구성된다." - {
        "성공" {
            forAll(
                row(lottoNumbersOf(1, 20, 35, 40, 42, 44)),
                row(lottoNumbersOf(8, 3, 4, 5, 6, 7)),
                row(lottoNumbersOf(42, 11, 30, 13, 14, 15)),
            ) { numbers ->
                val sut = Lotto.from(numbers)

                val result = sut.numbers

                result shouldContainExactlyInAnyOrder numbers
            }
        }

        "실패 - 숫자 개수 6개 불일치" {
            forAll(
                row(lottoNumbersOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                row(lottoNumbersOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)),
            ) { numbers ->
                shouldThrowWithMessage<IllegalArgumentException>("로또 번호는 중복 없이 6개만 입력 가능합니다.") { Lotto.from(numbers) }
            }
        }
    }

    "로또는 당첨 번호와 일치하는 숫자의 개수를 알려준다." - {
        forAll(
            row(lottoNumbersOf(1, 3, 5, 42, 45, 4), lottoNumbersOf(1, 2, 3, 4, 5, 6), 4),
            row(lottoNumbersOf(23, 44, 11, 33, 4, 2), lottoNumbersOf(5, 6, 7, 8, 9, 10), 0)
        ) { lottoNumbers, winningNumbers, expected ->
            val sut = Lotto.from(lottoNumbers)

            val result = sut.countMatchingNumbersFrom(winningNumbers)

            result shouldBe expected
        }
    }
})
