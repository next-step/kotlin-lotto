package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.common.IntegerNumber

class LuckyNumbersTest : StringSpec({
    "당첨 번호가 6개를 넘으면 에러 발생 테스트" {
        val numbers = listOf(
            IntegerNumber(1),
            IntegerNumber(2),
            IntegerNumber(3),
            IntegerNumber(4),
            IntegerNumber(5),
            IntegerNumber(6),
            IntegerNumber(7)
        )
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LuckyNumbers(luckyNumbers = numbers, bonusNumber = IntegerNumber(10))
        }
        exception.message shouldBe "당첨 번호는 6개가 필요합니다."
    }

    "당첨 번호가 중복이면 에러 발생 테스트" {
        val numbers = listOf(
            IntegerNumber(1),
            IntegerNumber(2),
            IntegerNumber(3),
            IntegerNumber(4),
            IntegerNumber(6),
            IntegerNumber(6)
        )
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LuckyNumbers(luckyNumbers = numbers, bonusNumber = IntegerNumber(10))
        }
        exception.message shouldBe "당첨 번호에 중복이 있습니다."
    }

    "보너스볼 중복 에러 테스트" {
        val numbers = listOf(
            IntegerNumber(1),
            IntegerNumber(2),
            IntegerNumber(3),
            IntegerNumber(4),
            IntegerNumber(5),
            IntegerNumber(6)
        )
        val exception = shouldThrowExactly<IllegalArgumentException> {
            LuckyNumbers(luckyNumbers = numbers, bonusNumber = IntegerNumber(6))
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
                        IntegerNumber(1),
                        IntegerNumber(3),
                        IntegerNumber(5),
                        IntegerNumber(7),
                        IntegerNumber(9),
                        IntegerNumber(11)
                    ), bonusNumber = IntegerNumber(13)
                ),
                listOf(
                    LottoNumber(IntegerNumber(2)),
                    LottoNumber(IntegerNumber(4)),
                    LottoNumber(IntegerNumber(6)),
                    LottoNumber(IntegerNumber(8)),
                    LottoNumber(IntegerNumber(10)),
                    LottoNumber(IntegerNumber(12))
                ),
                LottoRank.MISS
            ),
            row(
                "3개 일치하는 로또",
                LuckyNumbers(
                    luckyNumbers = listOf(
                        IntegerNumber(1),
                        IntegerNumber(3),
                        IntegerNumber(5),
                        IntegerNumber(7),
                        IntegerNumber(9),
                        IntegerNumber(11)
                    ), bonusNumber = IntegerNumber(13)
                ),
                listOf(
                    LottoNumber(IntegerNumber(7)),
                    LottoNumber(IntegerNumber(8)),
                    LottoNumber(IntegerNumber(9)),
                    LottoNumber(IntegerNumber(10)),
                    LottoNumber(IntegerNumber(11)),
                    LottoNumber(IntegerNumber(12))
                ),
                LottoRank.FIFTH
            ),
            row(
                "5개 일치+보너스번호 일치하는 로또",
                LuckyNumbers(
                    luckyNumbers = listOf(
                        IntegerNumber(1),
                        IntegerNumber(3),
                        IntegerNumber(5),
                        IntegerNumber(7),
                        IntegerNumber(9),
                        IntegerNumber(11)
                    ), bonusNumber = IntegerNumber(13)
                ),
                listOf(
                    LottoNumber(IntegerNumber(1)),
                    LottoNumber(IntegerNumber(3)),
                    LottoNumber(IntegerNumber(5)),
                    LottoNumber(IntegerNumber(7)),
                    LottoNumber(IntegerNumber(9)),
                    LottoNumber(IntegerNumber(13))
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
