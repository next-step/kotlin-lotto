package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.model.LottoErrorCode

class LottoNumberTest : DescribeSpec({

    describe(name = "로또 번호를 생성할 수 있다.") {
        forAll(
            row(1, LottoNumber(number = 1)),
            row(45, LottoNumber(number = 45)),
        ) { number, expect ->
            context(name = "1 ~ 45 사이의 번호로 생성하면") {
                val actual = LottoNumber(number = number)

                it(name = "입력한 번호로 로또 번호가 생성된다.") {
                    actual shouldBe expect
                }
            }
        }

        forAll(
            row(0, "0"),
            row(46, "46"),
        ) { number, expect ->
            context(name = "1 ~ 45 범위 밖의 번호로 생성하면") {
                val exception = shouldThrow<IllegalArgumentException> {
                    LottoNumber(number = number)
                }

                it(name = "로또 번호 범위 안에 번호로 생성하라는 에러가 발생한다.") {
                    exception shouldHaveMessage
                        LottoErrorCode.INVALID_LOTTO_NUMBER.message("${LottoNumber.LOTTO_NUMBER_RANGE} $expect")
                }
            }
        }
    }

    describe(name = "로또 번호를 생성할 수 있다.") {
        forAll(
            row("1", LottoNumber(number = 1)),
            row("45", LottoNumber(number = 45)),
            row(" 40", LottoNumber(number = 40)),
        ) { text, expect ->
            context(name = "1 ~ 45 사이의 번호로 생성하면") {
                val actual = LottoNumber(numberText = text)

                it(name = "입력한 번호로 로또 번호가 생성된다.") {
                    actual shouldBe expect
                }
            }
        }

        forAll(
            row("안돼", "안돼"),
            row("  ", "  "),
        ) { text, expect ->
            context(name = "숫자가 아닌 문자열로 생성하면") {
                val exception = shouldThrow<IllegalArgumentException> {
                    LottoNumber(numberText = text)
                }

                it(name = "로또 번호 범위 안에 번호로 생성하라는 에러가 발생한다.") {
                    exception shouldHaveMessage LottoErrorCode.INVALID_INPUT_NUMBER.message(expect)
                }
            }
        }
    }
})
