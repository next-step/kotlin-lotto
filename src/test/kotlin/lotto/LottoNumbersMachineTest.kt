package lotto

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.LottoMachine
import org.junit.jupiter.api.Test

class LottoNumbersMachineTest {
    private val lottoMachine: LottoMachine = LottoMachine(1000)

    @Test
    fun `로또 한장의 가격은 천원이다`() {
        shouldNotThrow<IllegalArgumentException> {
            lottoMachine.sellLotto(1000)
        }
    }

    @Test
    fun `1000원 미만의 돈으로는 로또를 살 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            lottoMachine.sellLotto(900)
        }
    }

    @Test
    fun `1500원으로는 한개의 로또를 살 수 있다`() {
        lottoMachine.sellLotto(1500).size shouldBe 1
    }

    @Test
    fun `로또의 숫자는 자동 생성된다`() {
        val userLotto = lottoMachine.sellLotto(1000)
        userLotto[0] shouldNotBe null
    }
}
