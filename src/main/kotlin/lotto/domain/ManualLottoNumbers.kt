package lotto.domain

import lotto.utils.StringUtil

@JvmInline
value class ManualLottoNumbers(private val lottoNumbers: List<LottoNumbers>) {

    fun getManualLottoNumberSize(): Int = lottoNumbers.size
    fun generate(): List<Lotto> = lottoNumbers.map { Lotto.from(it) }

    companion object {
        fun generateManualLottoNumbers(lottoNumberTexts: List<String>): ManualLottoNumbers {
            if (lottoNumberTexts.isNotEmpty()) {
                val values = lottoNumberTexts.map {
                    StringUtil.toInts(it)
                }.map {
                    LottoNumbers.generateLottoNumbers(it)
                }
                return ManualLottoNumbers(values)
            }

            return ManualLottoNumbers(listOf())
        }
    }
}
