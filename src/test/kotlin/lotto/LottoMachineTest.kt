package lotto

import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import lotto.number.Numbers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
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

    @ParameterizedTest
    @MethodSource("lottoNumberList")
    fun `입력 받은 번호 목록으로 로또 번호 목록을 생성한다`(numbers: List<Numbers>) {
        lottoMachine
            .generateByManual(numbers)
            .lottos
            .map { it.numbers } shouldContainExactly numbers
    }

    companion object {
        @JvmStatic
        private fun lottoNumberList() =
            listOf(
                listOf(
                    Numbers(listOf(1, 2, 3, 4, 5, 0)),
                    Numbers(listOf(1, 2, 3, 4, 5, 6)),
                ),
            )
    }
}
