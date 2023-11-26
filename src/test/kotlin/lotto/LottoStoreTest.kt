package lotto

import io.kotest.matchers.collections.haveSize
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = ["1000,1", "2000,2", "3000,3"])
    fun `로또를 여라장 구매한다`(money: Int, expected: Int) {
        val lotto = LottoStore().sell(money)
        lotto should haveSize(expected)
    }

    @Test
    fun `로또를 구매할 돈이 부족하면 예외가 발생한다`() {
        val lottoStore = LottoStore()
        val money = 900
        val lotto = lottoStore.sell(money)
        lotto shouldBe emptyList()
    }
}
