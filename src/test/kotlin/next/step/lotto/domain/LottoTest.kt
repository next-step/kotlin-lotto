package next.step.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoTest : DescribeSpec({

    describe("Lotto 생성") {
        context("6개보다 많은 LottoNumber로 생성하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> {
                    Lotto.from((1..7).toSet())
                }
            }
        }

        context("6개보다 적은 LottoNumber로 생성하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> {
                    Lotto.from((1..5).toSet())
                }
            }
        }

        context("같은 번호들로 생성하면") {
            it("동등함") {
                Lotto.from((1..6).toSet()) shouldBe Lotto.from((1..6).toSet())
            }
        }
    }

    describe("Lotto match") {
        context("lotto number set을 주면, 같은 숫자 개수 제공") {
            data class MatchExpected(val number: Set<LottoNumber>, val expected: Int)
            withData(
                MatchExpected(lottoNumbers(setOf(1, 2, 3, 4, 5, 6)), 6),
                MatchExpected(lottoNumbers(setOf(1, 2, 3, 4, 5, 7)), 5),
                MatchExpected(lottoNumbers(setOf(1, 2, 3, 4, 8, 7)), 4),
                MatchExpected(lottoNumbers(setOf(1, 2, 3, 9, 8, 7)), 3),
                MatchExpected(lottoNumbers(setOf(1, 2, 10, 9, 8, 7)), 2),
                MatchExpected(lottoNumbers(setOf(1, 11, 10, 9, 8, 7)), 1),
                MatchExpected(lottoNumbers(setOf(12, 11, 10, 9, 8, 7)), 0),
            ) { (matchingNumbers, expected) ->
                Lotto.from(setOf(1, 2, 3, 4, 5, 6)).match(matchingNumbers) shouldBe expected
            }
        }

        context("lotto number를 주면, 해당 숫자 포함 여부 제공") {
            data class MatchExpected(val number: LottoNumber, val expected: Boolean)
            withData(
                MatchExpected(LottoNumber.of(1), true),
                MatchExpected(LottoNumber.of(7), false),
            ) { (number, expected) ->
                Lotto.from(setOf(1, 2, 3, 4, 5, 6)).match(number) shouldBe expected
            }
        }
    }
})

private fun lottoNumbers(numbers: Set<Int>) = numbers.map { LottoNumber.of(it) }.toSet()
