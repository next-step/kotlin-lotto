package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class WinLottoTest : FreeSpec({

    "보너스볼 유효성체크" - {
        "당첨 번호와 보너스볼이 겹치면 예외가 발생한다" {
            val exception =
                shouldThrow<IllegalArgumentException> { WinLotto("1, 2, 3, 4, 5, 6", "1") }
            exception.message shouldBe "보너스볼은 당첨 번호와 겹치지 않게 선택해주세요"
        }

        "보너스볼이 ${LottoNumber.MINIMUM_LOTTO_NUMBER} ~ ${LottoNumber.MAXIMUM_LOTTO_NUMBER} 사이 숫자가 아닌 경우" {
            val exception =
                shouldThrow<IllegalArgumentException> { WinLotto("1, 2, 3, 4, 5, 6", "46") }
            exception.message shouldBe "1부터 45까지의 숫자를 입력하세요"
        }
    }
})
