package me.parker.nextstep.kotlinlotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LottoNumbersTest : DescribeSpec({

    describe("LottoNumbers 생성") {
        context("1 ~ 45 사이의 중복되지 않는 번호로 6개 주입하면") {
            it("정상적으로 LottoNumbers 객체를 생성한다.") {
                val lottoNumbers = LottoNumbers((1..6).map { LottoNumber(it) })

                lottoNumbers.values.size shouldBe 6
                lottoNumbers.values.forEach { it.number shouldBeInRange 1..45 }
                lottoNumbers.values.toSet().size shouldBe 6
            }
        }

        context("1 ~ 45 사이의 중복이 포함된 번호로 6개 주입하면") {
            it("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) })
                }.message shouldBe "로또 번호는 중복되지 않아야 합니다."
            }
        }

        context("1 ~ 45 사이의 번호로 5개 주입하면") {
            it("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers(listOf(1, 2, 3, 4, 5).map { LottoNumber(it) })
                }.message shouldBe "로또 번호는 ${LottoNumbers.LOTTO_NUMBERS_SIZE} 개를 가지고 있어야합니다."
            }
        }
    }

    describe("LottoNumbers 캐시 생성 규칙으로 생성") {
        context("랜덤 로또 번호 생성 규칙을 주입하면") {
            it("정상적으로 LottoNumbers 객체를 생성한다.") {
                val lottoNumbers = LottoNumbers(RandomLottoNumbersGenerationRule())

                lottoNumbers.values.size shouldBe 6
                lottoNumbers.values.forEach { it.number shouldBeInRange 1..45 }
                lottoNumbers.values.toSet().size shouldBe 6
            }
        }

        context("1 ~ 45 사이의 번호로 수동 로또 번호 생성 규칙을 주입하면") {
            it("정상적으로 LottoNumbers 객체를 생성한다.") {
                val lottoNumbers = LottoNumbers(ManualLottoNumbersGenerationRule(listOf(1, 2, 3, 4, 5, 6)))

                lottoNumbers.values.size shouldBe 6
                lottoNumbers.values.forEach { it.number shouldBeInRange 1..45 }
                lottoNumbers.values.toSet().size shouldBe 6
            }
        }

        context("1 ~ 45 이외의 번호가 포함된 수동 로또 번호 생성 규칙을 주입하면") {
            it("예외가 발생한다. (유효한 번호가 아니면 생성되지 않아 개수 예외가 발생함.)") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers(ManualLottoNumbersGenerationRule(listOf(1, 2, 3, 4, 5, 56)))
                }.message shouldBe "로또 번호는 ${LottoNumber.MIN_NUMBER} ~ ${LottoNumber.MAX_NUMBER} 사이만 가능합니다."
            }
        }

        context("1 ~ 45 사이의 번호지만, 6개보다 많은 수를 입력하는 수동 로또 번호 생성 규칙을 주입하면") {
            it("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers(ManualLottoNumbersGenerationRule(listOf(1, 2, 3, 4, 5, 6, 7)))
                }.message shouldBe "로또 번호는 ${LottoNumbers.LOTTO_NUMBERS_SIZE} 개를 가지고 있어야합니다."
            }
        }

        context("1 ~ 45 사이의 번호지만, 6개보다 적은 수를 입력하는 수동 로또 번호 생성 규칙을 주입하면") {
            it("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers(ManualLottoNumbersGenerationRule(listOf(1, 2, 3, 4, 5)))
                }.message shouldBe "로또 번호는 ${LottoNumbers.LOTTO_NUMBERS_SIZE} 개를 가지고 있어야합니다."
            }
        }

        context("1 ~ 45 사이의 번호지만, 중복되는 번호를 입력하는 수동 로또 번호 생성 규칙을 주입하면") {
            it("예외가 발생한다. (유효한 번호가 아니면 생성되지 않아 개수 예외가 발생함.)") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers(ManualLottoNumbersGenerationRule(listOf(1, 2, 3, 4, 5, 5)))
                }.message shouldBe "로또 번호는 중복되지 않아야 합니다."
            }
        }
    }
})
