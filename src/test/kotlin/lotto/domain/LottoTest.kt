package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoTest : BehaviorSpec({
    Given("유효한 로또 번호로 생성") {
        forAll(
            row(setOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6)),
            row(setOf(21, 24, 13, 41, 5, 6), listOf(5, 6, 13, 21, 24, 41)),
        ) { input, expected ->
            When("로또 번호를 생성") {
                val lotto = Lotto.from(input)
                Then("로또 번호는 6개이다") {
                    lotto.numbers.size shouldBe 6
                }

                Then("모든 번호는 1부터 45 사이여야 한다") {
                    lotto.numbers.all { it.value in 1..45 } shouldBe true
                }

                Then("중복된 번호는 없어야 한다") {
                    lotto.numbers.size shouldBe lotto.numbers.toSet().size
                }

                Then("로또 번호는 오름차순으로 정렬되어 있다") {
                    lotto.numbers shouldBe expected.map { LottoNumber.of(it) }
                }
            }
        }
    }

    Given("로또 생성 시") {
        When("번호가 유효하지 않은 경우") {
            forAll(
                row(setOf(1, 2, 3, 4, 5), "로또 번호는 6개여야 합니다."),
                row(setOf(1, 2, 3, 4, 5, 6, 7), "로또 번호는 6개여야 합니다."),
                row(setOf(0, 2, 3, 4, 5, 6), "로또 번호는 1부터 45 사이여야 합니다."),
                row(setOf(1, 2, 3, 4, 5, 46), "로또 번호는 1부터 45 사이여야 합니다."),
            ) { invalidNumbers, expectedMessage ->
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        Lotto.from(invalidNumbers)
                    }
                Then("예외가 발생한다") {
                    exception.message shouldBe expectedMessage
                }
            }
        }
    }
    Given("로또 번호가 주어졌을 때") {
        val lotto = Lotto.from(setOf(1, 2, 3, 4, 5, 6))

        forAll(
            row(setOf(1, 2, 3, 7, 8, 9).map { LottoNumber.of(it) }.toSet(), 3),
            row(setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) }.toSet(), 6),
            row(setOf(7, 8, 9, 10, 11, 12).map { LottoNumber.of(it) }.toSet(), 0),
            row(setOf(1, 2, 3, 4, 5).map { LottoNumber.of(it) }.toSet(), 5),
            row(emptySet<LottoNumber>(), 0),
        ) { winningNumbers, expectedMatchCount ->
            When("당첨 번호가 ${winningNumbers}인 경우") {
                val matchCount = lotto.matchCount(winningNumbers)

                Then("일치하는 번호의 개수는 ${expectedMatchCount}이다") {
                    matchCount shouldBe expectedMatchCount
                }
            }
        }
    }
})
