package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoMachineTest {
    private lateinit var lottoMachine1000: LottoMachine

    @BeforeEach
    fun setUp() {
        lottoMachine1000 = LottoMachine(1000)
    }

    @Test
    fun `로또 1 장의 가격은 1000원이다`() {
        lottoMachine1000.lottoPrice shouldBe 1000
    }

    @Test
    fun `로또 발급기는 금액 입력시 구입 가능한 갯수의 로또를 발급한다`() {
        TODO("Not yet implemented")
    }
}
