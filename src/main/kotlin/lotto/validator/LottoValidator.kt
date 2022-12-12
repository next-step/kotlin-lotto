package lotto.validator

import lotto.domain.LottoNumber

object LottoValidator {
    private const val NUMBER_OF_SINGLE_LOTTO_GAME: Int = 6
    private const val NOT_ENOUGH_LOTTO_NUMBER_ERROR_MESSAGE: String = "로또 한게임에는 6개의 숫자가 필요합니다.[%s]"

    fun validateLottoSize(lottoNumbers: Set<LottoNumber>) {
        require(lottoNumbers.size == NUMBER_OF_SINGLE_LOTTO_GAME) { NOT_ENOUGH_LOTTO_NUMBER_ERROR_MESSAGE.format(lottoNumbers) }
    }
}
