package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoCoupon
import lotto.domain.LottoNumber
import lotto.domain.Money

object InputView {

    tailrec fun readAmountOfMoney(): Money {
        println("구입금액을 입력해 주세요.")
        val amount = readln().toIntOrNull()
        return when (amount != null && amount >= 0) {
            true -> Money(amount)
            else -> {
                println("**잘못된 금액을 입력했습니다! 다시 입력해 주세요**")
                readAmountOfMoney()
            }
        }
    }

    tailrec fun readWinningLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요")
        val result = runCatching {
            Lotto.of(splitLine(readln()))
        }
        return when (result.isSuccess) {
            true -> result.getOrThrow()
            false -> {
                println("**잘못된 당첨 번호를 입력했습니다! 다시 입력해 주세요**")
                readWinningLotto()
            }
        }
    }

    private fun splitLine(line: String): Set<Int> {
        return line.split(",")
            .map { it.trim() }
            .filter {
                it.isNumeric()
            }
            .map { it.toInt() }
            .toSet()
    }

    private fun String.isNumeric(): Boolean = this.toCharArray().all { it.isDigit() }

    tailrec fun readBonusBall(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val result = runCatching {
            LottoNumber(readln().toInt())
        }
        return when (result.isSuccess) {
            true -> result.getOrThrow()
            false -> {
                println("**잘못된 보너스 번호를 입력했습니다! 다시 입력해 주세요**")
                readBonusBall()
            }
        }
    }

    tailrec fun readNumberOfManualLotto(maxNumber: Int): Int {
        val numberOfLottoCoupons = readNumberOfManualLotto()
        return when (numberOfLottoCoupons <= maxNumber) {
            true -> numberOfLottoCoupons
            false -> {
                println("**보유 금액으로 해당 개수만큼의 로또를 구매할 수 없습니다**")
                readNumberOfManualLotto(maxNumber)
            }
        }
    }

    private tailrec fun readNumberOfManualLotto(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toIntOrNull() ?: readNumberOfManualLotto()
    }

    fun readLottoCoupons(numberOfLottoCoupons: Int): List<LottoCoupon> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(numberOfLottoCoupons) {
            readLottoCoupon()
        }
    }

    private tailrec fun readLottoCoupon(): LottoCoupon {
        val numbers = splitLine(readln())
        val result = runCatching {
            LottoCoupon.of(numbers)
        }
        return when (result.isSuccess) {
            true -> result.getOrThrow()
            false -> {
                println("**잘못된 로또 번호를 입력했습니다! 다시 입력해 주세요**")
                readLottoCoupon()
            }
        }
    }
}
