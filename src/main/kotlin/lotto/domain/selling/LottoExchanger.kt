package lotto.domain.selling

import lotto.domain.Lotto

object LottoExchanger {

    fun exchange(lottoes: List<Lotto>, winningLotto: Lotto): ExchangeResult {
        val exchangeDetails = lottoes.groupingBy { it.getMatchCount(winningLotto) }.eachCount()
        return ExchangeResult(exchangeDetails)
    }
}
