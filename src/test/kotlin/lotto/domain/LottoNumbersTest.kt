package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe

internal class LottoNumbersTest : FreeSpec({

    "중복되지 않는 6개의 번호를 가진 로또를 자동으로 생성한다." {
        // when
        val lottoNumbers = LottoNumbers.random()

        // then
        lottoNumbers.values.shouldHaveSize(6)
    }

    "로또 번호가 중복되는 경우 예외가 발생한다." {
        // when, then
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LottoNumbers(
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
        // when
        val lottoNumbers = LottoNumbers.random()

        // then
        lottoNumbers.values.zipWithNext { currentNumber, nextNumber ->
            currentNumber.value.shouldBeLessThan(nextNumber.value)
        }
    }

    "서로 일치하는 번호의 개수를 반환한다." - {
        val winningNumbers = LottoNumbersFixture.of(setOf(1, 2, 3, 4, 5, 6))

        listOf(
            row(LottoNumbersFixture.of(setOf(11, 12, 13, 14, 15, 16)), 0),
            row(LottoNumbersFixture.of(setOf(1, 12, 13, 14, 15, 16)), 1),
            row(LottoNumbersFixture.of(setOf(1, 2, 13, 14, 15, 16)), 2),
            row(LottoNumbersFixture.of(setOf(1, 2, 3, 14, 15, 16)), 3),
            row(LottoNumbersFixture.of(setOf(1, 2, 3, 4, 15, 16)), 4),
            row(LottoNumbersFixture.of(setOf(1, 2, 3, 4, 5, 16)), 5),
            row(LottoNumbersFixture.of(setOf(1, 2, 3, 4, 5, 6)), 6),
        ).forEach { (lottoNumbers, result) ->
            "'${lottoNumbers.values}' 는 $result 개가 일치한다." {
                winningNumbers.matchedNumberCount(other = lottoNumbers) shouldBe result
            }
        }
    }
})
