package lottery

class Lotteries {
    val lotteries = mutableListOf<Lottery>()

    companion object {
        fun makeAutoLotteries(number: Int): Lotteries {
            val lotteries = Lotteries()
            for (i in 0 until number) {
                lotteries.lotteries.add(Lottery.makeAutoLottery())
            }
            return lotteries
        }
    }
}
