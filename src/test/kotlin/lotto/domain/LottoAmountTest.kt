package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoAmountTest {
    @Test
    fun `로또 구매 금액을 입력 하면 로또 개수를 알 수 있다`() {
        val amount = LottoAmount(14000)

        amount.ticketCount shouldBe 14
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 900, 1111, 99999])
    fun `구입 금액이 1000원 단위가 아니면 예외 발생한다`(amount: Int) {
        val exception = shouldThrowExactly<IllegalArgumentException> { LottoAmount(amount) }

        exception.message.shouldStartWith("구입 금액은 1000원 단위여야 합니다.")
    }
}
