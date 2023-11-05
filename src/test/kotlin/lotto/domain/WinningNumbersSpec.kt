package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinningNumbersSpec : FunSpec({
    test("로또 당첨 번호가 생성된다") {
        forAll(
            row(LottoSpec.NUMBERS_RANGE, LottoSpec.NUMBERS_COUNT),
            row(1..5, 5),
        ) { requiredRange, requiredCount ->
            val validNumbers = requiredRange.shuffled().take(requiredCount)

            val result = WinningNumbers.of(validNumbers, requiredRange, requiredCount)

            result.value shouldBe validNumbers
        }
    }

    test("로또 당첨 번호 개수가 정해진 수보다 많으면 당첨 번호 생성에 실패한다") {
        val ranges = 1..6
        val count = 5
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        shouldThrow<IllegalArgumentException> {
            WinningNumbers.of(numbers, ranges, count)
        }
    }

    test("로또 당첨 수가 정해진 범위에 있지 않으면 당첨 번호 생성에 실패한다") {
        val ranges = 1..5
        val count = 5
        val numbers = listOf(1, 2, 3, 4, 6)

        shouldThrow<IllegalArgumentException> {
            WinningNumbers.of(numbers, ranges, count)
        }
    }

    test("로또 당첨 번호에 중복된 번호가 있으면 당첨 번호 생성에 실패한다") {
        val ranges = 1..5
        val count = 5
        val numbers = listOf(1, 1, 3, 4, 5)

        shouldThrow<IllegalArgumentException> {
            WinningNumbers.of(numbers, ranges, count)
        }
    }
})
