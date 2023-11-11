package lotto

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoStore(private val lottoPrice: Int) {
    fun sellLotto(pay: Int): List<Lotto> {
        require(pay >= lottoPrice) { SELL_LOTTO_ERROR_MESSAGE }
        val numbers = listOf(
            LottoNumber(6),
            LottoNumber(5),
            LottoNumber(4),
            LottoNumber(3),
            LottoNumber(2),
            LottoNumber(1),
        )

        return (0 until pay / lottoPrice).map { Lotto(numbers) }
    }

    companion object {
        private const val SELL_LOTTO_ERROR_MESSAGE: String = "금액이 부족합니다."
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
}
