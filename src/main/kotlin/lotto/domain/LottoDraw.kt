package lotto.domain

import lotto.domain.dto.LottoMatchResult
import lotto.domain.dto.LottoNumber
import lotto.domain.dto.Rank

class LottoDraw(private val luckyDrawNumber: List<Int>, private val bonusNumber: Int) {
    val winningRanks: List<Rank>
        get() = _winningRanks
    private var _winningRanks: MutableList<Rank> = mutableListOf()

    fun draw(lottoList: List<LottoNumber>) {
        lottoList.forEach {
            this.addDrawResult(getDrawResult(it))
        }
    }

    private fun getDrawResult(lottoNumber: LottoNumber): LottoMatchResult {
        val numbers = lottoNumber.numbers
        return LottoMatchResult(
            luckyDrawNumber.count { numbers.contains(it) },
            numbers.contains(bonusNumber)
        )
    }

    private fun addDrawResult(lottoMatchResult: LottoMatchResult) {
        this._winningRanks.add(Rank.of(lottoMatchResult))
    }
}
