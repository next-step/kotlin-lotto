package lotto

class LotteryShop {

    fun buy(money: Int): UserLottery {
        val count = money / LOTTERY_PRICE
        val lotteryTickets = mutableListOf<Lottery>()
        repeat(count) {
            lotteryTickets.add(
                Lottery((1..45).shuffled().take(6).sorted())
            )
        }

        return UserLottery(count, lotteryTickets)
    }

    companion object {
        private const val LOTTERY_PRICE = 1000
    }
}
