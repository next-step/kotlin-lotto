package lotto.input

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.ManualCount
import lotto.domain.Money

class ManualLottoOrderInputViewTest : FreeSpec({

    "수동 로또 주문 입력 검증" - {
        "null 입력 시 예외 발생" {
            // given
            val input = null
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualLottoOrderInputView.process(ManualCount(Money(2000), 2), input) }
            // then
            exception.message shouldBe "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
        }
        "빈 문자열 입력 시 예외 발생" {
            // given
            val input = ""
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualLottoOrderInputView.process(ManualCount(Money(2000), 2), input) }
            // then
            exception.message shouldBe "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
        }
        "스페이스바만 입력 시 예외 발생" {
            // given
            val input = " "
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualLottoOrderInputView.process(ManualCount(Money(2000), 2), input) }
            // then
            exception.message shouldBe "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
        }
        "문자가 포함된 로또 번호 입력 시 예외 발생" {
            // given
            val input = "10000원"
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualLottoOrderInputView.process(ManualCount(Money(2000), 2), input) }
            // then
            exception.message shouldBe "1번째 줄: 올바른 로또번호를 입력하세요"
        }
        "올바른 형식의 로또 번호 입력 시 정상 처리" {
            // given
            val input = "1 2 3 4 5 6\n1 2 3 4 5 6"
            // when
            val manualLottoOrder = ManualLottoOrderInputView.process(ManualCount(Money(2000), 2), input)
            // then
            manualLottoOrder.usedMoney.price shouldBe 2000
        }
    }
})
