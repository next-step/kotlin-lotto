package lotto.input

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.ManualCount
import lotto.domain.Money

class ManualLottoOrderInputViewTest : FreeSpec({

    "Money 객체의 유효성 검증 테스트" - {
        "input이 null" {
            // given
            val input = null
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualLottoOrderInputView.process(ManualCount(Money(2000), 2), input) }
            // then
            exception.message shouldBe "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
        }
        "input이 빈 문자열" {
            // given
            val input = ""
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualLottoOrderInputView.process(ManualCount(Money(2000), 2), input) }
            // then
            exception.message shouldBe "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
        }
        "input이 스페이스바 문자열" {
            // given
            val input = " "
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualLottoOrderInputView.process(ManualCount(Money(2000), 2), input) }
            // then
            exception.message shouldBe "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
        }
        "input에 문자가 포함된 경우" {
            // given
            val input = "10000원"
            // when
            val exception =
                shouldThrow<IllegalArgumentException> { ManualLottoOrderInputView.process(ManualCount(Money(2000), 2), input) }
            // then
            exception.message shouldBe "1번째 줄: 올바른 로또번호를 입력하세요"
        }
        "input에 숫자만 있는 경우" {
            // given
            val input = "1 2 3 4 5 6\n1 2 3 4 5 6"
            // when
            val manualLottoOrder = ManualLottoOrderInputView.process(ManualCount(Money(2000), 2), input)
            // then
            manualLottoOrder.usedMoney.price shouldBe 2000
        }
    }
})
