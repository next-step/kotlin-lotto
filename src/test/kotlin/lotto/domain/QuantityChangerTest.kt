package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class QuantityChangerTest {

    @ParameterizedTest
    @MethodSource("provide")
    fun `금액에 따라 맞는 수량을 반환해야 한다`(input: Pair<Int, Int>) {
        // given
        val changer: QuantityChanger = QuantityChangerImpl()

        // when
        val result = changer.change(input.first)

        // then
        assertThat(result).isEqualTo(input.second)
    }

    companion object {
        @JvmStatic
        fun provide(): List<Pair<Int, Int>> = listOf(
            14000 to 14,
            21333 to 21,
            0 to 0,
        )

    }

}
