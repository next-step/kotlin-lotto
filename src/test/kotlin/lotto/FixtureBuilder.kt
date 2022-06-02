package lotto

import lotto.agency.number.LottoNumberStrategy

class FixtureBuilder {

    companion object {

        class RandomNumberFixture(private val numbers: Set<Int>) : LottoNumberStrategy {
            override fun makeLottoNumbers(): Set<Int> {
                return numbers
            }
        }
    }
}
