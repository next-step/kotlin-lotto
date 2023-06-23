package service

import domain.Lottery

object LotteryMachine {

    fun buyAutomaticLotteries(automaticSize: Int, existingLotteries: List<Lottery>): List<Lottery> {
        val newLotteries = List(automaticSize) { Lottery() }
        return existingLotteries + newLotteries
    }
}
