package common.shffule

import lotto.domain.shop.LottoNumber

class MockLottoNumberDescendingSortShuffler : Shuffler<LottoNumber> {

    override fun shuffled(source: List<LottoNumber>): List<LottoNumber> {
        return source.sortedDescending()
    }
}
