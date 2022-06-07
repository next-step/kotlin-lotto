package lotto

import lotto.model.LottoMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    private lateinit var lottoMachine: LottoMachine

    @BeforeEach
    fun setUp() {
        lottoMachine = LottoMachine()
    }

    @ParameterizedTest(name = "발급 매수만큼의 로또를 생성한다.")
    @ValueSource(strings = ["1", "5", "10"])
    fun `발급 매수만큼의 로또를 생성한다`(count: Int) {
        val lottos = lottoMachine.createLottos(count)
        assertThat(lottos.size).isEqualTo(count)
    }
}
