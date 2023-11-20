package lotto.domain.model

import lotto.domain.model.vo.LottoNumbers
import lotto.domain.model.vo.WinningLottoNumbers

/**
 * 로또 객체
 * */
data class Lotto(val lottoNumbers: LottoNumbers) {

    /**
     * 로또 맞은 횟수 반환
     * */
    fun getMatchCount(winningLottoNumbers: WinningLottoNumbers): Int {
        return lottoNumbers.numbers.filter { winningLottoNumbers.winningNumbers.contains(it) }.size
    }

    companion object {
        fun from(lottoNumbers: Set<Int> = LottoNumbers.createPrimitiveLottoNumberList()): Lotto {
            return Lotto(LottoNumbers.valueOf(lottoNumbers))
        }
    }
}
