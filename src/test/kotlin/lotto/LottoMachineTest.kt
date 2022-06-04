package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMachineTest {

    @Test
    fun `1에서 45 숫자를 갖는 자동 로또 컬렉션 생성`() {
        val lottoMaker = object : LottoMaker {
            override fun make(lottos: List<LottoNumber>): Lotto {
                val lottoNumbers = setOf(
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(1),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
                return Lotto(lottoNumbers)
            }
        }

        val lottoMachine = LottoMachine(lottoMaker, lottoMaker)
        val buyLotto = lottoMachine.buyLotto(1)
        assertThat(buyLotto.size).isEqualTo(1)
    }

    @Test
    fun `1에서 45 숫자를 갖는 수동 로또 컬렉션 생성`() {
        val lottoMaker = object : LottoMaker {
            override fun make(lottos: List<LottoNumber>): Lotto {
                val lottoNumbers = setOf(
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(1),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
                return Lotto(lottoNumbers)
            }
        }

        val lottoMachine = LottoMachine(lottoMaker, lottoMaker)
        val buyManualLotto = lottoMachine.buyManualLotto(listOf())

        assertThat(buyManualLotto.lotto).containsAll(
            setOf(
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(1),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
    }
}
