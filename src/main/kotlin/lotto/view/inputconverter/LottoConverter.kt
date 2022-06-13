package lotto.view.inputconverter

import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.UserInputResult

object LottoConverter : InputConverter<Lotto> {
    private const val DELIMITER = ", "

    override fun convert(input: String?): UserInputResult<Lotto> {
        return input.toLotto()?.let { lotto ->
            UserInputResult.Success(lotto)
        } ?: UserInputResult.Failed
    }

    private fun String?.toLotto(): Lotto? {
        val lottoNumbers = this
            ?.split(DELIMITER)
            ?.mapNotNull { stringNumber ->
                stringNumber.toLottoNumber()
            }?.toSet()

        return Lotto.from(lottoNumbers)
    }

    private fun String.toLottoNumber(): LottoNumber? {
        return this.toIntOrNull()?.let { number ->
            LottoNumber[number]
        }
    }
}
