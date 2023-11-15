package lotto.domain

import lotto.enums.Rank

class WinningLotto(
    val winningLotto: Lotto,
    val bonusNumber: LottoNumber
) {
    init {
        require(!winningLotto.lottoNumbers.contains(bonusNumber)) {
            "로또 번호와 보너스번호는 중복이 될 수 없습니다. 중복된 번호 : $bonusNumber"
        }
    }

    fun matchByRank(bundle: LottoBundle): List<Rank> {
        return bundle.findAllByMatchRanks(this)
    }
}
