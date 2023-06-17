package lotto.domain

class LotteryTicket(private val lotteries: List<Lottery>) : List<Lottery> by lotteries
