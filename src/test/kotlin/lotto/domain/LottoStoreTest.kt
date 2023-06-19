package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.model.Lotto
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoStoreTest {

    @ValueSource(ints = [14000])
    @ParameterizedTest
    fun `금액만큼 로또를 구매한다`(money: Int) {
        val lottos = LottoStore.buy(money)
        lottos.size shouldBe money / Lotto.PRICE
    }
}
