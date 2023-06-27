package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object PurchaseManualReader {

    private const val DELIMITER = ","
    fun manual(): List<Lotto> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val count = readln().toInt()

        println("수동으로 구매할 번호를 입력해 주세요.")
        return (0 until count).map {
            val readNumbers = readln().split(DELIMITER)

            val lottoNumbers = readNumbers
                .map { it.trim() }
                .map { it.toInt() }
                .map { LottoNumber(it) }

            Lotto.from(lottoNumbers)
        }
    }
}
