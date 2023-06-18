package lotto.controller

import lotto.domain.LottoNumbers

data class WinningNumbers(val lottoNumbers: LottoNumbers) {
    fun countMatches(other: LottoNumbers): Int {
        return lottoNumbers.countMatches(other.lottoNumbers)
    }
    companion object {
        fun of(lottoNumbers: LottoNumbers): WinningNumbers {
            return WinningNumbers(lottoNumbers)
        }
    }
}
