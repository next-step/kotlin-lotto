package com.example.mylotto.view

import com.example.mylotto.model.LottoNumber
import com.example.mylotto.model.LottoTicket

class InputView {
    fun readPurchaseAmount(): Long {
        println("구입금액을 입력해 주세요.")
        return readLong()
    }

    fun readWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readInts()
    }

    fun readBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readInt()
    }

    fun readManualTicketCount(ticketCount: Int): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualTicketCount = readInt()
        require(manualTicketCount in 0..ticketCount) { "수동 구매 수는 0부터 총 구매 수($ticketCount) 사이여야 합니다." }
        return manualTicketCount
    }

    fun readManualLottoNumbers(count: Int): List<LottoTicket> {
        println("수동으로 구매할 로또 번호를 입력해 주세요.")
        val ret = mutableListOf<LottoTicket>()
        repeat(count) {
            tryUntilSuccess {
                val numbers = readInts().map(LottoNumber::of).toSet()
                ret.add(LottoTicket.of(numbers))
            }
        }
        return ret
    }

    private fun readLong(): Long {
        val input = readlnOrNull()
        return requireNotNull(input?.toLongOrNull())
    }

    private fun readInt(): Int {
        val input = readlnOrNull()
        return requireNotNull(input?.toIntOrNull())
    }

    private fun readInts(): List<Int> {
        val numbers =
            readlnOrNull()
                ?.split(",")
                ?.mapNotNull { it.trim().toIntOrNull() }
        return requireNotNull(numbers)
    }

    fun tryUntilSuccess(action: () -> Unit) {
        while (true) {
            try {
                action()
                break
            } catch (e: Exception) {
                println("잘못된 입력입니다. 다시 시도해주세요. 오류: ${e.message}")
            }
        }
    }
}
