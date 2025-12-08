package com.example.mylotto.service

import com.example.mylotto.constant.LottoConstant
import com.example.mylotto.enum.Rank
import com.example.mylotto.model.LottoNumber
import com.example.mylotto.model.LottoNumbers

class LottoService {
    fun generateAutoLottoNumbers(
        purchaseAmount: Long,
        manualCount: Int,
    ): List<LottoNumbers> {
        require(purchaseAmount > 0 && purchaseAmount % LottoConstant.LOTTO_TICKET_PRICE == 0L) {
            "Purchase amount must be a positive multiple of ${LottoConstant.LOTTO_TICKET_PRICE}."
        }
        require(purchaseAmount / LottoConstant.LOTTO_TICKET_PRICE >= manualCount) {
            "Total purchase count must be equal or bigger than manual count."
        }

        val autoTicketCount = (purchaseAmount / LottoConstant.LOTTO_TICKET_PRICE).toInt() - manualCount

        return List(autoTicketCount) {
            LottoNumbers.auto()
        }
    }

    fun matchLottoTicket(
        lottoNumbers: LottoNumbers,
        winningNumbers: LottoNumbers,
        bonusNumber: Int,
    ): Rank {
        val matchedCount = lottoNumbers.numbers.intersect(winningNumbers.numbers).size
        val matchedBonusNumber = lottoNumbers.numbers.contains(LottoNumber(bonusNumber))
        return Rank.valueOf(matchedCount, matchedBonusNumber)
    }
}
