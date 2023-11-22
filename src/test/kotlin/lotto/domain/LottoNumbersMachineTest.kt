package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoNumbersMachineTest {
    private val lottoNumbers: List<LottoNumber> = listOf(
        LottoNumber(1),
        LottoNumber(2),
        LottoNumber(3),
        LottoNumber(4),
        LottoNumber(5),
        LottoNumber(6),
    )
    private val lottoMachine: LottoMachine = LottoMachine(1000) { lottoNumbers }

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
        userLotto[0].getNumbers() shouldContainInOrder lottoNumbers
    }

    @Test
    fun `로또 숫자를 수동으로 입력받는다`() {
        val manualNumber = listOf("1,2,3,4,5,6")
        val userLotto = lottoMachine.sellLotto(1000, manualNumber)
        userLotto[0].getNumbers() shouldContainInOrder lottoNumbers
    }

    @Test
    fun `수동 로또를 뺀 나머지는 자동로또로 구매한다`() {
        val manualNumber = listOf("1,2,3,4,5,6")
        val userLotto = lottoMachine.sellLotto(2000, manualNumber)
        userLotto.size shouldBe 2
    }
}
