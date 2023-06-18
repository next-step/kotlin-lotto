package shffule

import lotto.domain.lottonumber.LottoNumber

class MockLottoNumberDescendingSortShuffler : Shuffler<LottoNumber> {

    override fun shuffled(source: List<LottoNumber>): List<LottoNumber> {
        return source.sortedDescending()
    }
}
