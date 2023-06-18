import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRoundTest {

    @Test
    fun `새로운 로또를 개수만큼 추가할 수 있다`() {
        // given
        val sut = LottoRound(LottoRoundElements())
        val newLottoSize = 3

        // when
        sut.addNewLottos(newLottoSize)

        // then
        assertThat(sut.getLottos().size).isEqualTo(newLottoSize)
    }
}
