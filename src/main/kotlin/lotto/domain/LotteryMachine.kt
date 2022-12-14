package lotto.domain

class LotteryMachine {

    fun buyLotteries(payAmount: Int): Lotteries {
        val howMany = (payAmount / PRICE)
        val lotteryList = List(howMany) { Lottery(LottoNumber.allNumbers().shuffled().subList(0, 6)) }
        return Lotteries(lotteryList)
    }

    fun getResult(lotteries: Lotteries, lastWinningLottery: List<Int>): LotteryResult {

        return LotteryResult()
    }

    companion object {
        const val PRICE = 1_000
    }
}

data class Lotteries(val lotteries: List<Lottery>) {
    fun count(): Int {
        return lotteries.size
    }
}

data class Lottery(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == 6)
    }
}

class LottoNumber private constructor(number: Int) {
    val number: Int = number

    init {
        require(number in (1..45))
    }

    companion object {
        private val NUMBERS = List(45) { LottoNumber(it + 1) }

        fun allNumbers(): List<LottoNumber> {
            return NUMBERS
        }
    }
}
