package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoStoreTest {
    private lateinit var lottoStore: LottoStore

    @BeforeEach
    fun setUp() {
        lottoStore = LottoStore()
    }

    @Test
    fun `입력된 금액에 따라 로또를 구매한다`() {
        val money = 14000

        val lottos = lottoStore.sell(money)

        assertThat(lottos).hasSize(14)
    }

    @ParameterizedTest
    @ValueSource(ints = [999, 1001, 1010, 1100, 1111])
    fun `입력된 금액이 1천원 단위가 아니면 예외를 발생시킨다`(money: Int) {
        assertThatThrownBy { lottoStore.sell(money) }
            .isExactlyInstanceOf(NotEnoughMoneyException::class.java)
    }
}
