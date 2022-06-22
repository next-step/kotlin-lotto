package lotto.domain.lottoticket

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.Row2
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers

internal class LottoNumbersTest : FreeSpec({

    "로또 번호가 중복되는 경우 예외가 발생한다." {
        // when, then
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LottoNumbers.createWithSort(
                setOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    LottoNumber.from(5),
                )
            )
        }

        // then
        exception.message shouldBe "로또의 번호 개수는 6 여야 합니다."
    }

    "각각의 번호는 오름차순으로 정렬되어 있다." {
        // given
        val numberSet = listOf(5, 12, 7, 3, 1, 9)
            .map { LottoNumber.from(it) }
            .toSet()

        // when
        val lottoNumbers = LottoNumbers.createWithSort(numberSet)

        // then
        lottoNumbers.values.zipWithNext { currentNumber, nextNumber ->
            currentNumber.value.shouldBeLessThan(nextNumber.value)
        }
    }

    "서로 일치하는 번호의 개수를 반환한다." - {
        val winningNumbers = LottoNumbers(setOf(1, 2, 3, 4, 5, 6))

        listOf(
            lottoNumbersAndResult(11, 12, 13, 14, 15, 16, result = 0),
            lottoNumbersAndResult(1, 12, 13, 14, 15, 16, result = 1),
            lottoNumbersAndResult(1, 2, 13, 14, 15, 16, result = 2),
            lottoNumbersAndResult(1, 2, 3, 14, 15, 16, result = 3),
            lottoNumbersAndResult(1, 2, 3, 4, 15, 16, result = 4),
            lottoNumbersAndResult(1, 2, 3, 4, 5, 16, result = 5),
            lottoNumbersAndResult(1, 2, 3, 4, 5, 6, result = 6),
        ).forEach { (lottoNumbers, result) ->
            "'${lottoNumbers.values}' 는 $result 개가 일치한다." {
                winningNumbers.matchedNumberCount(other = lottoNumbers) shouldBe result
            }
        }
    }
})

fun lottoNumbersAndResult(n1: Int, n2: Int, n3: Int, n4: Int, n5: Int, n6: Int, result: Int): Row2<LottoNumbers, Int> =
    row(LottoNumbers(setOf(n1, n2, n3, n4, n5, n6)), result)
