package lotto.domain

class Lotto(lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {
    val numbers = lottoNumberGenerator.getLottoNumbers()

    companion object {
        const val NUMBER_OF_NUMBER = 6
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
    }
}
