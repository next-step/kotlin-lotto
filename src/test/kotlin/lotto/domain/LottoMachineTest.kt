package lotto.domain

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {
    private lateinit var lottoMachine1000: LottoMachine

    @BeforeEach
    fun setUp() {
        lottoMachine1000 = LottoMachine()
    }

    @Test
    fun `로또 1 장의 기본 가격은 1000원이다`() {
        lottoMachine1000.lottoPrice shouldBe 1000
    }

    @ParameterizedTest
    @CsvSource(value = ["14000, 14", "12000, 12", "1000, 1", "100, 0"])
    fun `로또 발급기는 금액 입력시 구입 가능한 갯수의 로또를 발급한다`(money: Int, expected: Int) {
        val lottos = lottoMachine1000.purchase(money)
        lottos.lottoList shouldHaveSize expected
    }
}
