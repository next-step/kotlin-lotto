package lotto.common

class InputValidation {
    fun amountValidate(input: String?): Int {
        require(!input.isNullOrBlank()) {
            throw ExceptionCode.NotAllowNullOrBlank
        }

        require(input.matches(Regex("\\d+"))) {
            throw ExceptionCode.NotMatchNumeric
        }
        return input.toInt()
    }

    fun winLotteryValidation(input: String?): List<Int> {
        require(!input.isNullOrBlank()) {
            throw ExceptionCode.NotAllowNullOrBlank
        }

        require(input.matches(Regex("(.*),(.*)"))) {
            throw ExceptionCode.NotFindSeparator
        }

        val winLottery = input.split(",").map { it.toInt() }
        if (winLottery.size != 6) {
            throw ExceptionCode.NotWinLotteryCount
        }
        return winLottery
    }
}
