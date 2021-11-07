package lotto.domain.model

import lotto.domain.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    fun `automaticLottos 가 1개일때 getAutomaticLottoSize 는 1이다`() {
        val automaticLottos = listOf(
            Lotto(
                LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
                Price(1000),
            )
        )

        val lottos = Lottos(automaticLottos = automaticLottos)

        assertEquals(1, lottos.getAutomaticLottoSize())
    }

    @Test
    fun `passivityLottos 가 1개일때 getPassivityLottoSize 는 1이다`() {
        val passivityLottos = listOf(
            Lotto(
                LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
                Price(1000),
            )
        )

        val lottos = Lottos(passivityLottos = passivityLottos,)

        assertEquals(1, lottos.getLottos().size)
    }

    @Test
    fun `automaticLottos 가 1개, passivityLottos 가 1개일때 getLottos() 의 size 는 2이다`() {
        val automaticLottos = listOf(
            Lotto(
                LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
                Price(1000),
            )
        )
        val passivityLottos = listOf(
            Lotto(
                LottoNumbers(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    )
                ),
                Price(1000),
            )
        )

        val lottos = Lottos(
            automaticLottos = automaticLottos,
            passivityLottos = passivityLottos,
        )

        assertEquals(2, lottos.getLottos().size)
    }
}
