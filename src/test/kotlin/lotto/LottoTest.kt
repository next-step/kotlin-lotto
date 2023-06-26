package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

internal class LottoTest : StringSpec({
    "추첨번호가 6개가 아니라면 예외를 발생시킨다" {
        table(
            headers("numbers"),
            row(listOf(1)),
            row(listOf(1, 2, 3, 4, 5)),
            row(listOf(1, 2, 3, 4, 5, 6, 7)),
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                val lottoNumbers = it.map { number -> LottoNumber(number) }
                Lotto(LottoNumbers(lottoNumbers), 1000)
            }
        }
    }

    "중복되는 추첨번호가 있다면 예외를 발생시킨다" {
        shouldThrow<IllegalArgumentException> {
            val lottoNumbers = (1..6).map { LottoNumber(1) }
            Lotto(LottoNumbers(lottoNumbers), 1000)
        }
    }

    "로또가 주어진 추점번호 포함여부를 반환한다" {
        val sut = Lotto(LottoNumbers(LottoNumber.of(listOf(1, 2, 3, 4, 5, 6))), 1000)
        sut.isContainLottoNumber(LottoNumber.of(1)) shouldBe true
    }
})
