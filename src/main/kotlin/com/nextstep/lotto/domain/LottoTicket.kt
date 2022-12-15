package com.nextstep.lotto.domain

class LottoTicket(private val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.distinct().size == LOTTO_TICKET_COUNT) { "로또 티켓은 $LOTTO_TICKET_COUNT 개의 로또번호가 필요합니다." }
    }

    fun matchCount(winningNumber: WinningNumber): Int {
        return LOTTO_TICKET_COUNT - lottoNumbers.subtract(winningNumber.winningNumbers).size
    }

    fun containsBonus(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    fun getLottoNumbers(): Set<LottoNumber> {
        return lottoNumbers.sorted().toSet()
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_TICKET_COUNT = 6
    }
}
