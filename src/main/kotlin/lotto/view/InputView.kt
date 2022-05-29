package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoShop
import lotto.domain.LottoTicket
import lotto.dto.LottoBuyingRequest
import lotto.dto.WinningLottoRequest
import lotto.vo.Money

object InputView {
    private const val INPUT_AMOUNT = "구입금액을 입력해 주세요."
    private const val INPUT_MANUAL_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요."
    private const val INPUT_MANUAL_NUMBER = "\n수동으로 구매할 번호를 입력해 주세요."
    private const val INPUT_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
    private const val LOTTO_NUMBER_SEPARATOR = ", "

    fun buying(): LottoBuyingRequest {
        val buyingAmount = amount()
        val manualCount = manualCount(buyingAmount)
        val manualNumbers = manualNumbers(manualCount)
        return LottoBuyingRequest(
            amount = buyingAmount,
            manualCount = manualCount,
            manualNumbers = manualNumbers
        )
    }

    fun winningLotto(): WinningLottoRequest {
        println(INPUT_WINNING_LOTTO)
        val winningLottoNumbers = toLottoNumbers(manualNumbers())
        println(INPUT_BONUS_NUMBER)
        val bonusNumber = toBonusNumber(readln())
        return WinningLottoRequest(winningLottoNumbers, bonusNumber)
    }

    private tailrec fun amount(): Money {
        println(INPUT_AMOUNT)
        val amount = convertMoney(readln())

        return if (amount < LottoShop.LOTTO_TICKET_PRICE) {
            println("최소 ${LottoShop.LOTTO_TICKET_PRICE.amount}원 이상이어야 합니다.")
            amount()
        } else {
            amount
        }
    }

    private fun convertMoney(amount: String): Money {
        return try {
            Money(amount.toBigDecimal())
        } catch (e: IllegalArgumentException) {
            println("금액을 잘못 입력하셨습니다. 다시 입력해주세요")
            amount()
        }
    }

    private tailrec fun manualCount(buyingAmount: Money): Int {
        println(INPUT_MANUAL_COUNT)
        val count = convertCount(readln(), buyingAmount)

        return if (count < 0 || LottoShop.LOTTO_TICKET_PRICE.multiply(count) > buyingAmount) {
            println("구매할 수 있는 수량이 아닙니다. 수량을 다시 입력해 주세요.")
            manualCount(buyingAmount)
        } else {
            count
        }
    }

    private fun convertCount(count: String, buyingAmount: Money): Int {
        return try {
            count.toInt()
        } catch (e: IllegalArgumentException) {
            println("수량을 잘못 입력하셨습니다. 다시 입력해주세요")
            manualCount(buyingAmount)
        }
    }

    private fun manualNumbers(manualCount: Int): List<List<LottoNumber>> {
        println(INPUT_MANUAL_NUMBER)
        return List(manualCount) { toLottoNumbers(manualNumbers()) }
    }

    private fun toLottoNumbers(manualNumbers: String): List<LottoNumber> {
        return try {
            val lottoNumbers = manualNumbers.split(LOTTO_NUMBER_SEPARATOR)
            require(lottoNumbers.size == LottoTicket.LOTTO_NUMBERS_SIZE)
            lottoNumbers.map(LottoNumber::of)
        } catch (e: IllegalArgumentException) {
            println("로또 번호 목록이 잘못 입력 되었습니다. 다시 입력해주세요 (번호 구분자: $LOTTO_NUMBER_SEPARATOR))")
            return toLottoNumbers(manualNumbers())
        }
    }

    private fun manualNumbers(): String {
        val manualNumber = readln()
        if (manualNumber.isEmpty()) {
            return readln()
        }
        return manualNumber
    }

    private fun toBonusNumber(value: String): LottoNumber {
        return try {
            LottoNumber.of(value)
        } catch (e: IllegalArgumentException) {
            println("보너스 번호가 잘못 입력 되었습니다. 다시 입력해주세요.")
            return toBonusNumber(readln())
        }
    }
}
