package lotto

import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @ParameterizedTest
    @ValueSource(ints = [14000])
    fun `구입 금액을 입력해서 구매 가능 개수를 구한다`(input: Int) {
        val purchaseCount = input / 1000
        purchaseCount shouldBe 14
    }

    @Test
    fun `로또는 6개의 랜덤한 숫자로 구성된다`() {
        val lotto = Lotto()
        lotto.lottoNumbers.size shouldBe 6
    }

    @Test
    fun `로또는 오름차순으로 구성된다`() {
        val lotto = Lotto()
        for(i in 0..4) {
            lotto.lottoNumbers.get(i + 1) shouldBeGreaterThan lotto.lottoNumbers.get(i)
        }
    }
}