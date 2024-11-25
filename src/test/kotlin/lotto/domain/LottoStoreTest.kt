package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoStoreTest : BehaviorSpec({
    val lottoStore = LottoStore()

    Given("로또 구입 금액이 주어졌을 때") {
        forAll(
            row(14000, 14),
            row(1000, 1),
            row(2000, 2),
            row(2500, 2),
            row(2999, 2),
        ) { amount, expectedCount ->
            When("로또 구입 금액이 ${amount}원일 때") {
                val count = lottoStore.calculateLottoCount(amount)

                Then("구입 가능한 로또 개수는 ${expectedCount}개이다") {
                    count shouldBe expectedCount
                }
            }
        }

        forAll(
            row(999),
            row(0),
        ) { amount ->
            When("구입 금액이 최소금액에 충족하지 못하면") {
                Then("예외가 발생한다") {
                    shouldThrow<IllegalArgumentException> {
                        lottoStore.calculateLottoCount(amount)
                    }.message shouldBe "구입 금액은 최소 1000원 이상이어야 합니다."
                }
            }
        }
    }

    Given("수동 로또와 전체 로또 개수, 로또 번호 생성기가 주어졌을 때") {
        val manualLottos =
            listOf(
                Lotto(setOf(1, 2, 3, 4, 5, 6)),
                Lotto(setOf(7, 8, 9, 10, 11, 12)),
            )
        val totalLottoCount = 5

        When("자동 로또 번호를 생성하여 발급하면") {
            val mockGenerator =
                object : LottoNumberGenerator {
                    override fun generate(): Set<Int> = setOf(13, 14, 15, 16, 17, 18)
                }
            val purchasedLottos = LottoStore().issueLottos(manualLottos, totalLottoCount, mockGenerator)

            Then("수동 로또는 manualLottos에 포함된 번호와 동일하다") {
                purchasedLottos.lottos.subList(0, manualLottos.size) shouldBe manualLottos
            }

            Then("자동 로또는 자동 생성된 번호로 구성된다") {
                val autoLottos = purchasedLottos.lottos.subList(manualLottos.size, totalLottoCount)
                autoLottos.forEach { lotto ->
                    lotto.numbers shouldBe setOf(13, 14, 15, 16, 17, 18)
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
                            override fun generate(): Set<Int> = setOf(13, 14, 15, 16, 17, 18)
                        },
                    )
                }
            }
        }
    }
})
