package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.LottoPurchaseController.purchaseLotto
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPurchaseControllerTest {
    @ValueSource(ints = [14000, 8000, 0, 500, 1000])
    @ParameterizedTest
    fun `구입 금액에 따라 로또 번호 묶음을 생성할 수 있다`(amount: Int) {
        val lottos = purchaseLotto(amount)
        lottos.size shouldBe amount / 1000
    }
}
