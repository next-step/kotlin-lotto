package lotto.domain.vo

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

class LottoNumberTest : FunSpec({
    context("of()") {
        test("로또 번호가 담긴 객체를 생성한다.") {
            shouldNotThrowAny {
                LottoNumber(1)
            }
        }

        test("1 ~ 45 번호가 아닐 경우 예외가 발생한다.") {
            listOf(0, 46).forAll {
                val actual = shouldThrow<IllegalArgumentException> {
                    LottoNumber(it)
                }

                actual.message should startWith("lotto number should be between")
            }
        }
    }
})
