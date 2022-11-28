package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "로또 Hit Count 계산 테스트" {
        forAll(
            // given
            row("0개 일치하는 로또", Lotto(listOf(1, 3, 5, 7, 9, 11)), listOf(2, 4, 6, 8, 10, 12), 0),
            row("3개 일치하는 로또", Lotto(listOf(1, 3, 5, 7, 9, 11)), listOf(7, 8, 9, 10, 11, 12), 3),
            row("6개 일치하는 로또", Lotto(listOf(1, 3, 5, 7, 9, 11)), listOf(1, 3, 5, 7, 9, 11), 6)
        ) { title, lotto, luckyNumbers, expectedHitCount ->
            // when
            val actual = lotto.countHitNumbers(luckyNumbers)
            // then
            actual shouldBe expectedHitCount
        }
    }

    "로또 번호가 6개를 넘으면 에러 발생 테스트" {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Lotto(numbers)
        }
        exception.message shouldBe "로또 번호는 6개가 필요합니다."
    }
})
