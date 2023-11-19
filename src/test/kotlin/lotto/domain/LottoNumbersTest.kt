package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoNumbersTest : FunSpec({
    test("로또 한 장은 숫자 6개를 가진다.") {
        val lottoNumbers = LottoNumbers(
            setOf(
                LottoNumber(10),
                LottoNumber(20),
                LottoNumber(17),
                LottoNumber(45),
                LottoNumber(16),
                LottoNumber(29)
            )
        )
        lottoNumbers.value.size shouldBe 6
    }

    test("로또에 적힌 숫자 개수가 6개를 넘는다면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(
                setOf(
                    LottoNumber(10),
                    LottoNumber(20),
                    LottoNumber(17),
                    LottoNumber(45),
                    LottoNumber(16),
                    LottoNumber(29),
                    LottoNumber(30),
                )
            )
        }
    }

    test("로또에 적힌 숫자가 중복된다면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers(
                setOf(
                    LottoNumber(10),
                    LottoNumber(10),
                    LottoNumber(17),
                    LottoNumber(45),
                    LottoNumber(16),
                    LottoNumber(29),
                )
            )
        }
    }

    context("로또 번호가 어떤 번호를 포함하고 있으면 true를, 아니라면 false를 반환한다") {
        val lottoNumbers = LottoNumbers(
            setOf(
                LottoNumber(10),
                LottoNumber(20),
                LottoNumber(17),
                LottoNumber(45),
                LottoNumber(16),
                LottoNumber(29)
            )
        )
        withData(
            row(LottoNumber(10), true),
            row(LottoNumber(11), false)
        ) { (lottoNumber, expected) ->
            (lottoNumber in lottoNumbers) shouldBe expected
        }
    }

    test("로또는 다른 로또와 비교하여 일치 개수를 계산할 수 있다.") {
        val lottoNumbers = LottoNumbers(
            setOf(
                LottoNumber(10),
                LottoNumber(15),
                LottoNumber(20),
                LottoNumber(25),
                LottoNumber(30),
                LottoNumber(35)
            )
        )
        val other = LottoNumbers(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(10),
                LottoNumber(15)
            )
        )
        lottoNumbers.match(other) shouldBe 2
    }
})
