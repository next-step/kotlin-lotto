package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : StringSpec({

    "로또 번호는 6개를 가진다" {
        // Arrange:
        val lottoNumbers = LottoNumbers.created(listOf(1, 2, 3, 4, 5, 6))

        // Act:
        val result = lottoNumbers.numbers.size

        // Assert:
        result shouldBe 6
    }

    "로또 번호는 1부터 45까지의 숫자로 이루어져 있다" {
        // Arrange:
        val lottoNumbers = LottoNumbers.created(listOf(1, 2, 3, 4, 5, 6))

        // Act:
        val result = lottoNumbers.numbers.all { it.value in 1..45 }

        // Assert:
        result shouldBe true
    }

    "당첨 번호와 로또 번호를 비교하면 6개가 일치한다" {
        // Arrange:
        val lottoNumbers = LottoNumbers.created(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = LottoNumbers.created(listOf(1, 2, 3, 4, 5, 6))

        // Act:
        val result = lottoNumbers.countMatch(winningNumbers)

        // Assert:
        result shouldBe 6
    }

    "보너스 번호가 로또 번호에 포함되어 있으면 true를 반환한다" {
        // Arrange:
        val userLotto = LottoNumbers.created(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.generate(2)

        // Act:
        val result = bonusNumber in userLotto.numbers

        // Assert:
        result shouldBe true
    }

    "주어진 범위만큼 로또 번호를 생성하되 중복되지 않는다." {
        // Arrange:
        val range = 1..6

        // Act:
        val lottoNumbers = LottoNumbers.generate(range)

        // Assert:
        lottoNumbers.numbers.size shouldBe 6
        lottoNumbers.numbers.toSet().size shouldBe 6
    }
})
