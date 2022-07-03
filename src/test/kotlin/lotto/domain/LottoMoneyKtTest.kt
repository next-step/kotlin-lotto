package lotto.domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoMoneyKtTest {
    @Test
    fun `빼기`() {
        assertThat(LottoMoney(2000) - LottoMoney(1000))
            .isEqualTo(LottoMoney(1000))
    }

    @Test
    fun `뺄셈 결과가 음수인 경우 예외`() {
        assertThrows<IllegalArgumentException> { LottoMoney(1000) - LottoMoney(2000) }
            .shouldHaveMessage("구입금액보다 더 많은 수동 로또를 구매하실 수 없습니다")
    }

    @Test
    fun `대소비교`() {
        assertThat(LottoMoney(2000) > LottoMoney(1000))
            .isTrue
    }
}
