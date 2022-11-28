package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LuckyNumbersTest : StringSpec({
    "당첨 번호가 6개를 넘으면 에러 발생 테스트" {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LuckyNumbers(luckyNumbers = numbers, bonusNumber = 10)
        }
        exception.message shouldBe "당첨 번호는 6개가 필요합니다."
    }

    "당첨 번호가 중복이면 에러 발생 테스트" {
        val numbers = listOf(1, 2, 3, 4, 6, 6)
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LuckyNumbers(luckyNumbers = numbers, bonusNumber = 10)
        }
        exception.message shouldBe "당첨 번호에 중복이 있습니다."
    }

    "보너스볼 중복 에러 테스트" {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LuckyNumbers(luckyNumbers = numbers, bonusNumber = 6)
        }
        exception.message shouldBe "보너스볼은 당첨번호와 중복될 수 없습니다."
    }

    "로또 Hit Count 계산 테스트" {
        forAll(
            // given
            row("0개 일치하는 로또", LuckyNumbers(luckyNumbers = listOf(1, 3, 5, 7, 9, 11), bonusNumber = 13), listOf(2, 4, 6, 8, 10, 12), LottoRank.MISS),
            row("3개 일치하는 로또", LuckyNumbers(luckyNumbers = listOf(1, 3, 5, 7, 9, 11), bonusNumber = 13), listOf(7, 8, 9, 10, 11, 12), LottoRank.FIFTH),
            row(
                "5개 일치+보너스번호 일치하는 로또",
                LuckyNumbers(luckyNumbers = listOf(1, 3, 5, 7, 9, 11), bonusNumber = 13),
                listOf(1, 3, 5, 7, 9, 13),
                LottoRank.SECOND
            )
        ) { title, luckyNumbers, lottoNumbers, expectedRank ->
            // when
            val actual = luckyNumbers.rank(lottoNumbers)
            // then
            actual shouldBe expectedRank
        }
    }
})
