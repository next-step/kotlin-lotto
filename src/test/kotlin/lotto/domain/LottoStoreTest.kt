package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.model.Lotto
import lotto.domain.model.Money
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoStoreTest {

    @ValueSource(ints = [14000])
    @ParameterizedTest
    fun `금액만큼 로또를 구매한다`(money: Int) {
        val lottos = LottoStore.buy(Money(money))
        lottos.size shouldBe money / Lotto.PRICE
    }

    @Test
    fun `로또는 1000원으로 구매할 수 있다`() {
        val lottos = LottoStore.buy(Money(1000))
        lottos.size shouldBe 1
    }

    @Test
    fun `구매한 로또의 번호는 6개이다`() {
        val lotto = LottoStore.buy(Money(1000))[0]
        lotto.numbers.size shouldBe 6
    }
}
