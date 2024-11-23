package lotto

import io.kotest.matchers.collections.shouldHaveSize
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {
    private lateinit var lottoMachine: LottoMachine

    @BeforeEach
    fun beforeEach() {
        lottoMachine = LottoMachine()
    }

    @ParameterizedTest
    @ValueSource(ints = [14])
    fun `입력 받은 개수 만큼 로또 번호 목록을 생성한다`(lottoCount: Int) {
        lottoMachine.generate(lottoCount).lottos shouldHaveSize lottoCount
    }
}
