package lotto.domain

import lotto.domain.LottoStore.Companion.LOTTO_COST
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoStoreTest {

    private lateinit var lottoStore: LottoStore
    private lateinit var money: Money

    @BeforeEach
    fun init() {
        lottoStore = LottoStore()

    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 10000, 14000])
    fun `금액넣었을때 금액에 맞는 로또가 생성되는지 확인`(moneyValue: Int) {
        money = Money(moneyValue)
        val lottoes = lottoStore.purchaseAuto(money)
        assertThat(lottoes.toList().size).isEqualTo(money.spentMoney / LOTTO_COST)
    }
}
