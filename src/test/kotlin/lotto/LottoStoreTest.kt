package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoStore {
    fun sell(money: Int): List<Lotto> {
        if (isValidAmount(money)) throw NotEnoughMoneyException(money)

        val theNumberOfLotto = money / MIN_AMOUNT_UNIT
        return (1..theNumberOfLotto).map {
            Lotto()
        }
    }

    private fun isValidAmount(money: Int) = money % MIN_AMOUNT_UNIT != 0

    companion object {
        private const val MIN_AMOUNT_UNIT = 1000
    }
}

class Lotto

class NotEnoughMoneyException(money: Int) : RuntimeException("입력 금액은 1천원 단위여야 합니다. 현재 입력 = $money") {
}

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