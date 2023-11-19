package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoNumberTest : FunSpec({
    test("로또 번호는 1부터 45 사이의 숫자다.") {
        shouldNotThrow<Exception> { LottoNumber(15) }
    }

    test("로또 번호가 1부터 45 사이의 숫자가 아니라면 예외가 발생한다.") {
        shouldThrow<RuntimeException> { LottoNumber(50) }
    }

    context("로또 번호는 어떤 숫자 그룹에 자신의 값이 속해있는지 알 수 있다.") {
        withData(
            row(
                LottoNumbers(
                    setOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6)
                    )
                ), LottoNumber(1), true
            ),
            row(
                LottoNumbers(
                    setOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6)
                    )
                ), LottoNumber(7), false
            )
        ) { (lottoNumbers, lottoNumber, expected) ->
            (lottoNumber in lottoNumbers) shouldBe expected
        }
    }
})
