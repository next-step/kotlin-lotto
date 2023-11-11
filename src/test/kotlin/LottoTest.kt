import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `금액을 입력받았을 때, getMaxPurchaseCnt()를 호출한다면, 구매 가능 수량을 반환한다`() {
        // given : 금액을 입력 받는다.
        val cash = 14500

        // when :  getMaxPurchaseCnt()를 호출한다.
        val actual = Lotto().getMaxPurchaseCnt(cash)

        // then : 구매 가능 수량을 반환한다.
        assertThat(actual).isEqualTo(14)
    }
}
