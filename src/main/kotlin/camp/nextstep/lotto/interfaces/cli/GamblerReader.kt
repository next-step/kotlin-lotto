package camp.nextstep.lotto.interfaces.cli

import camp.nextstep.lotto.user.Gambler

object GamblerReader {

    fun read(): Gambler {
        val money = readMoney()
        return Gambler(money)
    }

    private fun readMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return requireNotNull(readLine()?.toInt())
    }
}
