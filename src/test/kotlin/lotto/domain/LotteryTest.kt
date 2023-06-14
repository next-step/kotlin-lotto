package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.mockLottery
import lotto.mockLottoNumbers
import lotto.model.LottoErrorCode

class LotteryTest : DescribeSpec({

    describe(name = "복권을 생성할 수 있다.") {
        forAll(
            row(mockLottoNumbers(1, 2, 3, 4, 5, 6), mockLottery(1, 2, 3, 4, 5, 6)),
            row(mockLottoNumbers(5, 8, 23, 45, 24, 43), mockLottery(5, 8, 23, 45, 24, 43)),
            row(Lottery(lotteryText = "5, 8, 23, 45, 24, 43"), mockLottery(5, 8, 23, 45, 24, 43)),
            row(Lottery(lotteryText = "1, 2, 3, 4, 5, 6"), mockLottery(1, 2, 3, 4, 5, 6)),
        ) { numbers, expect ->
            context(name = "중복되지 않고, 정해진 수의 번호를 입력하면") {
                val lottery = Lottery(numbers = numbers)

                it(name = "입력한 번호로 복권이 생성된다.") {
                    lottery shouldBe expect
                }
            }
        }

        forAll(
            row(mockLottoNumbers(1, 2, 3, 4, 5), 5),
            row(mockLottoNumbers(5, 8, 23, 45, 24, 43, 32), 7),
            row(mockLottoNumbers(1, 1, 1, 1, 1, 1), 1),
            row(mockLottoNumbers(), 0),
        ) { numbers, expect ->
            context(name = "번호가 중복되거나, 정해진 수의 복권 범위를 벗어나게 입력하면") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Lottery(numbers = numbers)
                }

                it(name = "중복되지 않고, 정해진 수의 복권 번호를 입력하라고 에러가 발생한다.") {
                    exception shouldHaveMessage LottoErrorCode.INVALID_LOTTERY_NUMBER.message(
                        "$expect ${Lottery.ALLOW_LOTTO_NUMBER_COUNT}"
                    )
                }
            }
        }
    }

    describe(name = "복권을 문자열로 생성할 수 있다.") {
        forAll(
            row("5, 8, 23, 45, 24, 43", mockLottery(5, 8, 23, 45, 24, 43)),
            row("1, 2, 3, 4, 5, 6", mockLottery(1, 2, 3, 4, 5, 6)),
        ) { text, expect ->
            context(name = "중복되지 않고, 정해진 수의 번호를 입력하면") {
                val lottery = Lottery(lotteryText = text)

                it(name = "입력한 번호로 복권이 생성된다.") {
                    lottery shouldBe expect
                }
            }
        }

        forAll(
            row("1, 1, 1, 1, 1, 1", 1),
            row("5, 8, 23, 45, 24, 43, 32", 7),
        ) { text, expect ->
            context(name = "번호가 중복되거나, 정해진 수의 복권 범위를 벗어나게 입력하면") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Lottery(lotteryText = text)
                }

                it(name = "중복되지 않고, 정해진 수의 복권 번호를 입력하라고 에러가 발생한다.") {
                    exception shouldHaveMessage LottoErrorCode.INVALID_LOTTERY_NUMBER.message(
                        "$expect ${Lottery.ALLOW_LOTTO_NUMBER_COUNT}"
                    )
                }
            }
        }
    }

    describe(name = "복권은 다른 복권을 넣어 등수를 구할 수 있다.") {
        val mockLottery = mockLottery(1, 2, 3, 4, 5, 6)

        forAll(
            row(mockLottery(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
            row(mockLottery(1, 2, 3, 4, 5, 8), LottoRank.SECOND),
            row(mockLottery(1, 2, 3, 4, 5, 7), LottoRank.THIRD),
            row(mockLottery(1, 2, 3, 4, 8, 7), LottoRank.FOUR),
            row(mockLottery(1, 2, 3, 9, 8, 7), LottoRank.FIVE),
            row(mockLottery(1, 2, 10, 11, 12, 13), LottoRank.MISS),
            row(mockLottery(1, 22, 23, 34, 25, 15), LottoRank.MISS),
            row(mockLottery(11, 22, 23, 34, 25, 15), LottoRank.MISS),
        ) { numbers, expect ->
            context(name = "다른 복권이 주어지면") {
                val lottoRank = mockLottery.scratchLottery(
                    otherLottery = numbers,
                    bonusBall = LottoNumber(number = 8),
                )

                it(name = "일치하는 복권 등수를 반환한다.") {
                    lottoRank shouldBe expect
                }
            }
        }
    }
})
