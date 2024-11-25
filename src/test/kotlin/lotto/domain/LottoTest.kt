package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.lottoFixture
import lotto.fixture.lottoNumbersFixture
import lotto.fixture.winningLottoFixture

class LottoTest : StringSpec({
    "로또는 6개의 정렬된 숫자를 가진다" {
        val numbers = lottoNumbersFixture(1, 2, 3, 4, 5, 6)

        val actual = DefaultLotto(numbers)

        actual.sortedNumbers.size shouldBe 6
    }

    "로또는 6개의 숫자가 아닌 경우 IllegalArgumentException을 던진다" {
        val numbers = lottoNumbersFixture(1, 2, 3, 4, 5)

        shouldThrow<IllegalArgumentException> {
            DefaultLotto(numbers)
        }
    }

    "당첨 로또는 로또와 비교하여 결과를 반환한다" {
        val lotto = lottoFixture(1, 2, 3, 4, 5, 6)
        val winningLotto =
            winningLottoFixture(
                numbers = intArrayOf(1, 2, 3, 4, 5, 6),
                bonusNumber = 45,
            )

        val actual = winningLotto.compare(lotto)

        actual shouldBe Result.FIRST
    }

    "당첨 로또는 보너스 번호가 일치하는 5개의 번호를 가진 로또와 비교하여 2등을 반환한다" {
        val lotto = lottoFixture(1, 2, 3, 4, 5, 45)
        val winningLotto =
            winningLottoFixture(
                numbers = intArrayOf(1, 2, 3, 4, 5, 6),
                bonusNumber = 45,
            )

        val actual = winningLotto.compare(lotto)

        actual shouldBe Result.SECOND
    }

    "당첨 로또는 보너스 번호와 중복되는 번호를 가지면 IllegalArgumentException이 발생한다" {
        val numbers = lottoNumbersFixture(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber(6)

        shouldThrow<IllegalArgumentException> {
            WinningLotto(numbers, bonusNumber)
        }
    }
})
