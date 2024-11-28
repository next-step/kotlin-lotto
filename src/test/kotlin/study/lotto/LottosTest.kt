package study.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.lotto.model.Lotto
import study.lotto.model.LottoNumber
import study.lotto.model.Lottos

/**
 * @author 이상준
 */
class LottosTest : StringSpec({
    "로또 합치기 테스트" {
        val lottos1 =
            Lottos(
                mutableListOf(
                    Lotto(
                        setOf(
                            LottoNumber(1),
                            LottoNumber(2),
                            LottoNumber(3),
                            LottoNumber(4),
                            LottoNumber(5),
                            LottoNumber(6),
                        ),
                    ),
                    Lotto(
                        setOf(
                            LottoNumber(1),
                            LottoNumber(20),
                            LottoNumber(30),
                            LottoNumber(40),
                            LottoNumber(33),
                            LottoNumber(21),
                        ),
                    ),
                ),
            )

        val lottos2 =
            Lottos(
                mutableListOf(
                    Lotto(
                        setOf(
                            LottoNumber(1),
                            LottoNumber(2),
                            LottoNumber(3),
                            LottoNumber(4),
                            LottoNumber(5),
                            LottoNumber(6),
                        ),
                    ),
                    Lotto(
                        setOf(
                            LottoNumber(1),
                            LottoNumber(2),
                            LottoNumber(3),
                            LottoNumber(4),
                            LottoNumber(5),
                            LottoNumber(6),
                        ),
                    ),
                ),
            )
        lottos1.addAllLotto(lottos2)

        lottos1.getLottos().size shouldBe 4
    }
})
