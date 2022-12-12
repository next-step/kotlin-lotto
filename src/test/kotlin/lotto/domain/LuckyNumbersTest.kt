package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.common.Number

class LuckyNumbersTest : StringSpec({
    "당첨 번호가 6개를 넘으면 에러 발생 테스트" {
        val numbers = listOf(
            Number(1),
            Number(2),
            Number(3),
            Number(4),
            Number(5),
            Number(6),
            Number(7)
        )
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LuckyNumbers(luckyNumbers = numbers, bonusNumber = Number(10))
        }
        exception.message shouldBe "당첨 번호는 6개가 필요합니다."
    }

    "당첨 번호가 중복이면 에러 발생 테스트" {
        val numbers = listOf(
            Number(1),
            Number(2),
            Number(3),
            Number(4),
            Number(6),
            Number(6)
        )
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LuckyNumbers(luckyNumbers = numbers, bonusNumber = Number(10))
        }
        exception.message shouldBe "당첨 번호에 중복이 있습니다."
    }

    "보너스볼 중복 에러 테스트" {
        val numbers = listOf(
            Number(1),
            Number(2),
            Number(3),
            Number(4),
            Number(5),
            Number(6)
        )
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LuckyNumbers(luckyNumbers = numbers, bonusNumber = Number(6))
        }
        exception.message shouldBe "보너스볼은 당첨번호와 중복될 수 없습니다."
    }

    "로또 Hit Count 계산 테스트" {
        forAll(
            // given
            row(
                "0개 일치하는 로또",
                LuckyNumbers(
                    luckyNumbers = listOf(
                        Number(1),
                        Number(3),
                        Number(5),
                        Number(7),
                        Number(9),
                        Number(11)
                    ), bonusNumber = Number(13)
                ),
                listOf(
                    LottoNumber(Number(2)),
                    LottoNumber(Number(4)),
                    LottoNumber(Number(6)),
                    LottoNumber(Number(8)),
                    LottoNumber(Number(10)),
                    LottoNumber(Number(12))
                ),
                LottoRank.MISS
            ),
            row(
                "3개 일치하는 로또",
                LuckyNumbers(
                    luckyNumbers = listOf(
                        Number(1),
                        Number(3),
                        Number(5),
                        Number(7),
                        Number(9),
                        Number(11)
                    ), bonusNumber = Number(13)
                ),
                listOf(
                    LottoNumber(Number(7)),
                    LottoNumber(Number(8)),
                    LottoNumber(Number(9)),
                    LottoNumber(Number(10)),
                    LottoNumber(Number(11)),
                    LottoNumber(Number(12))
                ),
                LottoRank.FIFTH
            ),
            row(
                "5개 일치+보너스번호 일치하는 로또",
                LuckyNumbers(
                    luckyNumbers = listOf(
                        Number(1),
                        Number(3),
                        Number(5),
                        Number(7),
                        Number(9),
                        Number(11)
                    ), bonusNumber = Number(13)
                ),
                listOf(
                    LottoNumber(Number(1)),
                    LottoNumber(Number(3)),
                    LottoNumber(Number(5)),
                    LottoNumber(Number(7)),
                    LottoNumber(Number(9)),
                    LottoNumber(Number(13))
                ),
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
