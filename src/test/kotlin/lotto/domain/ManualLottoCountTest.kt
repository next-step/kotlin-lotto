package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ManualLottoCountTest {
    @Test
    fun `수동 로또 구매 개수 - 수동 로또 구매 개수가 음수로 입력된 경우에 대한 예외처리 테스트`() {
        // given, when, then
        assertThatThrownBy { ManualLottoCount(-1, 5) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("수동으로 구매할 로또의 갯수는 0 이상이어야 합니다.")
    }

    @Test
    fun `수동 로또 구매 개수 - 수동 로또 구매 개수가 구매 가능한 로또 개수보다 큰 경우에 대한 예외처리 테스트`() {
        // given, when, then
        assertThatThrownBy { ManualLottoCount(6, 5) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("수동으로 구매할 로또 수는 구매 금액을 초과할 수 없다.")
    }
}
