package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.lottoFixture
import lotto.fixture.lottoNumbersFixture

class LottoTest : StringSpec({
    "로또는 6개의 정렬된 숫자를 가진다" {
        val numbers = lottoNumbersFixture(1, 2, 3, 4, 5, 6)

        val actual = Lotto(numbers)

        actual.sortedNumbers.size shouldBe 6
    }

    "로또는 6개의 숫자가 아닌 경우 IllegalArgumentException을 던진다" {
        val numbers = lottoNumbersFixture(1, 2, 3, 4, 5)

        shouldThrow<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    "로또는 당첨 로또와 일치하는 숫자의 개수를 반환한다" {
        val numbers = lottoNumbersFixture(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        val winningLotto = lottoFixture(1, 2, 3, 4, 5, 6)

        val actual = lotto.compare(winningLotto)

        actual shouldBe 6
    }
})
