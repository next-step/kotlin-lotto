package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoNum

class InputView {
    private lateinit var winningNums: Lotto

    fun readMoney(): Int {
        println(INPUT_MONEY_MSG)
        return validateMoney(readLine())
    }

    fun readWinningNums(): Lotto {
        println(INPUT_WINNING_NUMS_MSG)
        return parseToLottoNums(readLine())
    }

    fun parseToLottoNums(nums: String?): Lotto {
        require(nums != null) { INVALID_LOTTO_NUMS_EXCEPTION_MSG }

        val stringNums = nums.split(WINNING_NUM_DELIMITER)
        winningNums = Lotto(stringNums.map { convertToLottoNum(it) }.toSet())
        return winningNums
    }

    private fun convertToLottoNum(num: String?): LottoNum {
        require(num != null && num.toIntOrNull() != null) { INVALID_LOTTO_NUMS_EXCEPTION_MSG }
        return LottoNum(num.toInt())
    }

    fun readBonusNum(): LottoNum {
        println(INPUT_BONUS_NUM_MSG)
        return validateBonusNum(readLine(), winningNums)
    }

    fun readManualCount(availableCount: Int): Int {
        println(INPUT_MANUAL_COUNT_MSG)
        return validateManualCount(availableCount, readLine())
    }

    fun readManualNums(manualCount: Int): List<Lotto> {
        println(INPUT_MANUAL_NUMS_MSG)

        val manualLottoTickets = mutableListOf<Lotto>()
        repeat(manualCount) {
            manualLottoTickets.add(parseToLottoNums(readLine()))
        }
        return manualLottoTickets
    }

    companion object {
        private const val INPUT_MONEY_MSG = "구입금액을 입력해 주세요."
        private const val INVALID_MONEY_EXCEPTION_MSG = "구입금액을 바르게 입력해 주세요. (1000 이상의 숫자로 입력)"
        private const val INPUT_MANUAL_COUNT_MSG = "\n수동으로 구매할 로또 수를 입력해 주세요."
        private const val INVALID_MANUAL_COUNT_EXCEPTION_MSG = "수동으로 구매할 로또 개수를 바르게 입력해 주세요. (구매 가능한 개수 내에서 숫자로 입력)"
        private const val INPUT_MANUAL_NUMS_MSG = "\n수동으로 구매할 번호를 입력해 주세요."
        private const val INPUT_WINNING_NUMS_MSG = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUM_MSG = "보너스 볼을 입력해 주세요."
        private const val INVALID_LOTTO_NUMS_EXCEPTION_MSG =
            "로또 번호를 바르게 입력해 주세요. (1 ~ 45 사이의 서로 다른 6개의 숫자를 쉼표로 구분하여 입력)"
        private const val INVALID_BONUS_NUM_EXCEPTION_MSG =
            "보너스 번호를 바르게 입력해 주세요. (입력한 당첨 번호 이외의 1 ~ 45 사이의 숫자 입력)"
        private val WINNING_NUM_DELIMITER = ",\\s*".toRegex()

        fun validateMoney(inputMoney: String?): Int {
            require(inputMoney != null && inputMoney.toIntOrNull() != null) { INVALID_MONEY_EXCEPTION_MSG }

            val money = inputMoney.toInt()
            require(money >= LottoGame.PRICE) { INVALID_MONEY_EXCEPTION_MSG }
            return money
        }

        fun validateBonusNum(bonusNum: String?, winningNums: Lotto): LottoNum {
            require(bonusNum != null && bonusNum.toIntOrNull() != null) { INVALID_BONUS_NUM_EXCEPTION_MSG }

            val resultNum = LottoNum(bonusNum.toInt())
            require(!winningNums.nums.contains(resultNum)) { INVALID_BONUS_NUM_EXCEPTION_MSG }
            return resultNum
        }

        fun validateManualCount(availableCount: Int, inputCount: String?): Int {
            require(inputCount != null && inputCount.toIntOrNull() != null) { INVALID_MANUAL_COUNT_EXCEPTION_MSG }

            val manualCount = inputCount.toInt()
            require(manualCount <= availableCount) { INVALID_MANUAL_COUNT_EXCEPTION_MSG }
            return manualCount
        }
    }
}
