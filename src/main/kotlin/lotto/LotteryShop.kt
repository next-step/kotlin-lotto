package lotto

class LotteryShop {

    fun buy(money: Int): UserLottery {
        val count = money / LOTTERY_PRICE
        val lotteryTickets = mutableListOf<Lottery>()
        repeat(count) {
            lotteryTickets.add(
                Lottery((MIN_LOTTERY_NUMBER..MAX_LOTTERY_NUMBER).shuffled().take(6).sorted())
            )
        }
        return UserLottery(count, lotteryTickets)
    }

    companion object {
        private const val LOTTERY_PRICE = 1000
        private const val MIN_LOTTERY_NUMBER = 1
        private const val MAX_LOTTERY_NUMBER = 45
    }
}
