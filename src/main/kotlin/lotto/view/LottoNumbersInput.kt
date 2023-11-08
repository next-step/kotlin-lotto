package lotto.view

import lotto.domain.LottoNumbers

class LottoNumbersInput(text: String) {
    val numbers: LottoNumbers

    init {
        val numbersList = text.split(',').map {
            try {
                it.trim().toInt()
            } catch (e: Exception) {
                throw IllegalArgumentException("You need to enter six numbers separated by comma as the delimiter.(ex - 1,2,3, 4, 5,6)")
            }
        }
        numbers = LottoNumbers(*numbersList.toIntArray())
    }
}
