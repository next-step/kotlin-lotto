package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("로또 생성기 테스트")
class LottoGeneratorTest {

    @Test
    fun `수동 로또의 금액이 지불 금액을 초과하면 예외 발생`() {
        // given
        val paymentPrice = 900
        val customLottos = Lottos(listOf(Lotto(LottoNumber.LOTTO_NUMBERS.subList(0, 6))))

        // when, then
        val exception = assertThrows<IllegalArgumentException> {
            LottoGenerator.generateLottos(paymentPrice, customLottos, RandomLottoGenerating)
        }
        assertEquals("구입금액은 최소 1000원 이상이어야 합니다.", exception.message)
    }

    @Test
    fun `지불 금액, 수동 로또, 나머지 로또 생성 전략에 맞게 최종 로또를 정상 생성`() {
        // given
        val paymentPrice = 2500
        val customLottos = Lottos(listOf(Lotto(LottoNumber.LOTTO_NUMBERS.subList(0, 6))))
        val restLottos = Lottos(listOf(Lotto(LottoNumber.LOTTO_NUMBERS.subList(7, 13))))
        val totalLottos = LottoGenerator.generateLottos(paymentPrice, customLottos) { restLottos }

        // when, then
        assertEquals(totalLottos.count, 2)
        assertTrue(totalLottos.lottos.containsAll(customLottos.lottos))
        assertTrue(totalLottos.lottos.containsAll(restLottos.lottos))
    }
}
