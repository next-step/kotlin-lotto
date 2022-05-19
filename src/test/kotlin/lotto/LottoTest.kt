package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import stringaddcalculator.lotto.Lotto
import stringaddcalculator.lotto.LottoNumber

class LottoTest : DescribeSpec({

    describe("로또는") {
        it("6개의 고유한 로또 번호를 오름차순으로 저장한다") {
            val lotto = Lotto(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                )
            )
            lotto.numbers shouldBeEqualToComparingFields sortedSetOf(1, 2, 3, 4, 5, 6)
        }

        it("로또 번호의 개수가 6개가 아니면 예외를 발생시킨다.") {
            val invalidLottoNumbers = listOf(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                    LottoNumber(7),
                ),
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                ),
            )
            invalidLottoNumbers.forAll {
                shouldThrowExactly<IllegalArgumentException> {
                    Lotto(it)
                }
            }
        }

        context("다른 로또가 주어지면") {
            val lotto = Lotto(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                )
            )
            val other = Lotto(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(44),
                    LottoNumber(45),
                )
            )
            it("주어진 로또와 일치하는 로또 번호의 개수를 알 수 있다") {
                lotto.getMatchingNumbers(other) shouldBe 4
            }
        }
    }
})
