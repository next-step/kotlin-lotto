package lotto

import io.kotest.matchers.collections.haveSize
import io.kotest.matchers.should
import org.junit.jupiter.api.Test

class LottoStoreTest {

    @Test
    fun `1000원으로 로또를 구매한다`() {
        val lotto1 = LottoStore().sell(1000)
        lotto1 should haveSize(1)

        val lotto2 = LottoStore().sell(500)
        lotto2 should haveSize(0)

        val lotto3 = LottoStore().sell(18000)
        lotto3 should haveSize(18)
    }
}
