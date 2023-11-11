package lotto

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoStore(private val lottoPrice: Int) {
    fun sellLotto(pay: Int): List<Lotto> {
        require(pay >= lottoPrice) { SELL_LOTTO_ERROR_MESSAGE }
        return (0 until pay / lottoPrice).map { Lotto(lottoNumberGenerator()) }
    }

    private fun lottoNumberGenerator(): List<LottoNumber>  {

        return (0 until 6).map { LottoNumber((START_NUMBER..END_NUMBER).random()) }
    }

    companion object {
        private const val SELL_LOTTO_ERROR_MESSAGE: String = "금액이 부족합니다."
        private const val START_NUMBER: Int = 1
        private const val END_NUMBER: Int = 45
    }
}

class LottoStoreTest {
    private val lottoStore: LottoStore = LottoStore(1000)

    @Test
    fun `로또 한장의 가격은 천원이다`() {
        shouldNotThrow<IllegalArgumentException> {
            lottoStore.sellLotto(1000)
        }
    }

    @Test
    fun `1000원 미만의 돈으로는 로또를 살 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            lottoStore.sellLotto(900)
        }
    }

    @Test
    fun `1500원으로는 한개의 로또를 살 수 있다`() {
        lottoStore.sellLotto(1500).size shouldBe 1
    }

    @Test
    fun `로또의 숫자는 자동 생성된다`() {
        val userLotto = lottoStore.sellLotto(1000)

        userLotto[0].getSize() shouldBe 6
    }
}
