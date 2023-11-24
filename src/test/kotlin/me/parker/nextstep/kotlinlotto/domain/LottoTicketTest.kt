package me.parker.nextstep.kotlinlotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoTicketTest : DescribeSpec({

    describe("automatic() 메서드") {
        it("6개의 랜덤한 로또 번호 숫자를 갖는 LottoTicket 객체를 생성한다.") {
            val lottoTicket = LottoTicket.automatic()

            lottoTicket.lottoNumbers.values.size shouldBe 6
        }
    }

    describe("manual() 메서드") {
        context("6개의 서로 다른 숫자 리스트가 주어지면") {
            it("해당 로또 번호 숫자를 갖는 LottoTicket 객체를 생성한다.") {
                val numbers = listOf(1, 2, 3, 4, 5, 6)
                val lottoTicket = LottoTicket.manual(numbers)

                lottoTicket.lottoNumbers.values.size shouldBe 6
                lottoTicket.lottoNumbers.values shouldBe numbers.map { LottoNumber(it) }
            }
        }

        context("6개 보다 많은 7개의 서로 다른 숫자 리스트가 주어지면") {
            it("예외가 발생한다.") {
                val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

                shouldThrow<IllegalArgumentException> { LottoTicket.manual(numbers) }
                    .message shouldBe "로또 번호는 중복되지 않은 ${LottoNumbers.LOTTO_NUMBERS_SIZE} 개를 가지고 있어야합니다."
            }
        }

        context("6개 보다 적은 5개의 서로 다른 숫자 리스트가 주어지면") {
            it("예외가 발생한다.") {
                val numbers = listOf(1, 2, 3, 4, 5)

                shouldThrow<IllegalArgumentException> { LottoTicket.manual(numbers) }
                    .message shouldBe "로또 번호는 중복되지 않은 ${LottoNumbers.LOTTO_NUMBERS_SIZE} 개를 가지고 있어야합니다."
            }
        }

        context("6개의 번호를 갖지만 중복되는 번호가 주어지면") {
            it("예외가 발생한다.") {
                val numbers = listOf(1, 2, 3, 4, 5, 5)

                shouldThrow<IllegalArgumentException> { LottoTicket.manual(numbers) }
                    .message shouldBe "로또 번호는 중복되지 않은 ${LottoNumbers.LOTTO_NUMBERS_SIZE} 개를 가지고 있어야합니다."
            }
        }
    }

    describe("match() 메서드") {
        context("당첨 번호와 일치하는 번호가 6개인 경우, 보너스 볼 번호 일치와 상관없이") {
            it("1등이다. (보너스 볼 번호와 매칭되지 않음.)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val bonusLottoNumber = LottoNumber(7)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.FIRST
            }
        }

        context("당첨 번호와 일치하는 번호가 5개이고, 보너스 볼 번호와 일치하면") {
            it("2등이다.") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 7))
                val bonusLottoNumber = LottoNumber(6)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.SECOND
            }
        }

        context("당첨 번호와 일치하는 번호가 5개이고, 보너스 볼 번호와 일치하지 않으면") {
            it("3등이다.") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 7))
                val bonusLottoNumber = LottoNumber(8)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.THIRD
            }
        }

        context("당첨 번호와 일치하는 번호가 4개인 경우, 보너스 볼 번호 일치와 상관없이") {
            it("4등이다. (보너스 번호와 일치)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 7, 8))
                val bonusLottoNumber = LottoNumber(6)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.FOURTH
            }

            it("4등이다. (보너스 번호와 일치하지 않음)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 7, 8))
                val bonusLottoNumber = LottoNumber(10)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.FOURTH
            }
        }

        context("당첨 번호와 일치하는 번호가 3개인 경우, 보너스 볼 번호 일치와 상관없이") {
            it("5등이다. (보너스 번호와 일치)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 7, 8, 9))
                val bonusLottoNumber = LottoNumber(6)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.FIFTH
            }

            it("5등이다. (보너스 번호와 일치하지 않음)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 7, 8, 9))
                val bonusLottoNumber = LottoNumber(10)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.FIFTH
            }
        }

        context("당첨 번호와 일치하는 번호가 2개인 경우, 보너스 볼 번호 일치와 상관없이") {
            it("MISS이다. (보너스 번호와 일치)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 7, 8, 9, 10))
                val bonusLottoNumber = LottoNumber(6)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.MISS
            }

            it("MISS이다. (보너스 번호와 일치하지 않음)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 7, 8, 9, 10))
                val bonusLottoNumber = LottoNumber(15)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.MISS
            }
        }

        context("당첨 번호와 일치하는 번호가 1개인 경우, 보너스 볼 번호 일치와 상관없이") {
            it("MISS이다. (보너스 번호와 일치)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 7, 8, 9, 10, 11))
                val bonusLottoNumber = LottoNumber(6)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.MISS
            }

            it("MISS이다. (보너스 번호와 일치하지 않음)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 7, 8, 9, 10, 11))
                val bonusLottoNumber = LottoNumber(15)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.MISS
            }
        }

        context("당첨 번호와 일치하는 번호가 0개인 경우, 보너스 볼 번호 일치와 상관없이") {
            it("MISS이다. (보너스 번호와 일치)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(7, 8, 9, 10, 11, 12))
                val bonusLottoNumber = LottoNumber(6)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.MISS
            }

            it("MISS이다. (보너스 번호와 일치하지 않음)") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(7, 8, 9, 10, 11, 12))
                val bonusLottoNumber = LottoNumber(15)

                lottoTicket.match(winningLottoTicket, bonusLottoNumber) shouldBe LottoRank.MISS
            }
        }
    }
})
