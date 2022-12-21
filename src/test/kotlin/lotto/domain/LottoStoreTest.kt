package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoStoreTest {

    @DisplayName("로또 구매 테스트")
    @ParameterizedTest(name = "배열 {0}원으로 {1}장의 로또를 구매할 수 있다")
    @MethodSource("valueSource")
    fun `1000원 당 한장의 로또가 발행된다`(krw: KRW, numberOfLotto: Int) {
        val lottos = LottoStore().sell(krw)
        assertThat(lottos.size).isEqualTo(numberOfLotto)
    }

    @Test
    fun `수동으로 로또를 구매할 수 있다`() {
        val lottos = LottoStore().sell(KRW(1000), listOf("1,2,3,4,5,6"))
        assertThat(lottos.size).isEqualTo(1)
    }

    @Test
    fun `금액보다 로또의 장수가 더 크면 에러를 반환한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            LottoStore().sell(KRW(0), listOf("1,2,3,4,5,6"))
        }
        assertThat(exception.message).isEqualTo("구매할 로또의 수 이상의 금액을 가지고 있으셔야합니다.")
    }

    companion object {
        @JvmStatic
        fun valueSource(): List<Arguments> {
            return listOf(
                Arguments.of(KRW(1000), 1),
                Arguments.of(KRW(2000), 2),
                Arguments.of(KRW(3000), 3),
                Arguments.of(KRW(4000), 4),
                Arguments.of(KRW(5000), 5),
                Arguments.of(KRW(6000), 6),
            )
        }
    }
}
