package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.lottoNumbersFixture

class LottoTest : StringSpec({
    "로또는 6개의 정렬된 숫자를 가진다" {
        val numbers =
            listOf(
                LottoNumber(6),
                LottoNumber(5),
                LottoNumber(4),
                LottoNumber(3),
                LottoNumber(2),
                LottoNumber(1),
            )

        val actual = Lotto(numbers)

        actual.sortedNumbers.size shouldBe 6
    }

    "로또는 6개의 숫자가 아닌 경우 IllegalArgumentException을 던진다" {
        val numbers =
            listOf(
                LottoNumber(6),
                LottoNumber(5),
                LottoNumber(4),
                LottoNumber(3),
                LottoNumber(2),
            )

        shouldThrow<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    "로또는 당첨 번호와 일치하는 숫자의 개수를 반환한다" {
        val numbers =
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        val lotto = Lotto(numbers)
        val winningNumbers = lottoNumbersFixture(1, 2, 3, 4, 5, 6)

        val actual = lotto.match(winningNumbers)

        actual shouldBe 6
    }
})
