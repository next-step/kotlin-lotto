package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : StringSpec({
    val lottoGenerator = LottoGenerator()

    "구입 금액을 1000원 단위로 나눈다." {
        val inputPayment = 14000
        val count = lottoGenerator.getLottoCount(inputPayment)

        count shouldBe inputPayment / 1000
    }

    "로또 번호 6자리를 생성한다." {
        val count = 6
        val lottoNumbers = lottoGenerator.generateLottoNumbers()
        lottoNumbers.size shouldBe count
    }

    "중복되지 않은 로또 번호를 생성해야 한다." {
        val lottoNumbers = lottoGenerator.generateLottoNumbers()

        lottoNumbers shouldHaveSize 6
        lottoNumbers.distinct() shouldHaveSize 6
    }

    "지정된 개수의 로또를 생성해야 한다." {
        val manualLottos = Lottos(
            listOf(
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6)
                    )
                ),
                Lotto(
                    listOf(
                        LottoNumber(7),
                        LottoNumber(8),
                        LottoNumber(9),
                        LottoNumber(10),
                        LottoNumber(11),
                        LottoNumber(12)
                    )
                )
            )
        )
        val generatedLottos = lottoGenerator.generateLottos(5, manualLottos)
        generatedLottos.lottoNumbers shouldHaveSize 5
    }

    "수동 로또와 자동 로또로 전체 로또를 생성한다." {
        val manualLottos = Lottos(
            listOf(
                Lotto(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6)
                    )
                ),
                Lotto(
                    listOf(
                        LottoNumber(7),
                        LottoNumber(8),
                        LottoNumber(9),
                        LottoNumber(10),
                        LottoNumber(11),
                        LottoNumber(12)
                    )
                )
            )
        )

        val generatedLottos = lottoGenerator.generateLottos(3, manualLottos)

        generatedLottos.lottoNumbers shouldHaveSize 3
        generatedLottos.lottoNumbers shouldContain manualLottos.lottoNumbers[0]
    }
})
