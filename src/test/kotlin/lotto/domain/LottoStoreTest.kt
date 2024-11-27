package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : BehaviorSpec({
    Given("수동 로또와 전체 로또 개수, 로또 번호 생성기가 주어졌을 때") {
        val manualLottos =
            listOf(
                Lotto.from(setOf(1, 2, 3, 4, 5, 6)),
                Lotto.from(setOf(7, 8, 9, 10, 11, 12)),
            )
        val totalLottoCount = 5

        When("자동 로또 번호를 생성하여 발급하면") {
            val mockGenerator =
                object : LottoNumberGenerator {
                    override fun generate(): Set<LottoNumber> = setOf(13, 14, 15, 16, 17, 18).map { LottoNumber.of(it) }.toSet()
                }
            val purchasedLottos = LottoStore().issueLottos(manualLottos, totalLottoCount, mockGenerator)

            Then("수동 로또는 manualLottos에 포함된 번호와 동일하다") {
                purchasedLottos.lottos.subList(0, manualLottos.size) shouldBe manualLottos
            }

            Then("자동 로또는 자동 생성된 번호로 구성된다") {
                val autoLottos = purchasedLottos.lottos.subList(manualLottos.size, totalLottoCount)
                autoLottos.forEach { lotto ->
                    lotto.numbers shouldBe setOf(13, 14, 15, 16, 17, 18).map { LottoNumber.of(it) }
                }
            }

            Then("발급된 전체 로또 개수는 totalLottoCount와 동일하다") {
                purchasedLottos.lottos.size shouldBe totalLottoCount
            }
        }

        When("전체 로또 개수가 수동 로또 개수보다 작으면") {
            Then("예외가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    LottoStore().issueLottos(
                        manualLottos,
                        1,
                        object : LottoNumberGenerator {
                            override fun generate(): Set<LottoNumber> = setOf(13, 14, 15, 16, 17, 18).map { LottoNumber.of(it) }.toSet()
                        },
                    )
                }
            }
        }
    }
})
