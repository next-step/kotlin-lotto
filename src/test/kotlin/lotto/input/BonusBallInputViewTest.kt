package lotto.input

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber

class BonusBallInputViewTest : FreeSpec({

    "보너스 볼 입력 검증" - {
        "null 입력 시 예외 발생" {
            // given
            val input = null
            val lotto =
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                )
            // when
            val exception = shouldThrow<IllegalArgumentException> { BonusBallInputView.process(lotto, input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "빈 문자열 입력 시 예외 발생" {
            // given
            val input = ""
            val lotto =
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                )
            // when
            val exception = shouldThrow<IllegalArgumentException> { BonusBallInputView.process(lotto, input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }
        "스페이스바만 입력 시 예외 발생" {
            // given
            val input = " "
            val lotto =
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                )
            // when
            val exception = shouldThrow<IllegalArgumentException> { BonusBallInputView.process(lotto, input) }
            // then
            exception.message shouldBe "뭐라도 입력하세요"
        }

        "한글 문자가 포함된 경우 예외 발생" {
            // given
            val input = "목"
            val lotto =
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                )
            // when
            val exception = shouldThrow<IllegalArgumentException> { BonusBallInputView.process(lotto, input) }
            // then
            exception.message shouldBe "올바른 보너스번호를 입력하세요"
        }
        "범위를 벗어난 음수 입력 시 예외 발생" {
            // given
            val input = "-6"
            val lotto =
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                )
            // when
            val exception = shouldThrow<IllegalArgumentException> { BonusBallInputView.process(lotto, input) }
            // then
            exception.message shouldBe "1부터 45까지의 숫자를 입력하세요"
        }
    }
})
