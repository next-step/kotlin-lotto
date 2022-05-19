package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import stringaddcalculator.lotto.Lotto
import stringaddcalculator.lotto.LottoNumber

class LottoTest : DescribeSpec({

    describe("로또는") {
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
    }
})
