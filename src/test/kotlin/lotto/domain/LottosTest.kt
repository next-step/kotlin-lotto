package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.RawLottoNumbers

class LottosTest : FunSpec({
    context("create") {
        test("create with list of lottos") {
            shouldNotThrowAny {
                Lottos(
                    listOf(
                        Lotto(1, 2, 3, 4, 5, 6),
                        Lotto(2, 3, 4, 5, 6, 7),
                    ),
                )
            }
        }

        test("create with raw lotto numbers") {
            shouldNotThrowAny {
                val rawNumbers =
                    listOf(
                        listOf(1, 2, 3, 4, 5, 6),
                        listOf(2, 3, 4, 5, 6, 7),
                    )
                RawLottoNumbers(rawNumbers).toLottos()
            }
        }
    }

    test("return size") {
        val lottos =
            Lottos(
                listOf(
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(2, 3, 4, 5, 6, 7),
                ),
            )

        lottos.size shouldBe 2
    }

    test("compareAllTo should return matchCounts to given lotto") {
        val actual =
            mapOf(
                Lotto(1, 2, 3, 4, 5, 6) to 6,
                Lotto(2, 3, 4, 5, 6, 7) to 5,
            )
        val lottos = Lottos(actual.map { it.key })

        lottos.compareAllTo(Lotto(1, 2, 3, 4, 5, 6)) shouldBe actual
    }

    test("can add more lottos to existing lottos") {
        val lottos1 =
            Lottos(
                listOf(
                    Lotto(1, 2, 3, 4, 5, 6),
                ),
            )
        val lottos2 =
            Lottos(
                listOf(
                    Lotto(2, 3, 4, 5, 6, 7),
                ),
            )

        (lottos1 + lottos2).size shouldBe 2
    }
})
